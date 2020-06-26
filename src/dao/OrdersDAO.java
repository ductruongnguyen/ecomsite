package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;
import model.ProductOrders;

public class OrdersDAO {
	
	//list Orders
	public List<Orders> listOrders() throws Exception {
		
		List<Orders> Orders = new ArrayList<Orders>();
		Orders order;
		
		Connection conn = new DBContext().getConnection();
		
		String sql1 = "select * from orders;";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql1);
		
		while(rs.next()) {
			order = new Orders();
			order.setUserName(rs.getString("user_mail"));
			order.setOrderId(rs.getInt("order_id"));
			order.setStatus(rs.getInt("order_status"));
			order.setOrderDate(rs.getDate("order_date"));
			order.setDiscount(rs.getString("order_discount_code"));
			order.setAddress(rs.getString("order_address"));
			Orders.add(order);
		}
		
		conn.close();
		
		return Orders;
	}

	//list Order Details
	public List<ProductOrders> listProductOrders(int idd) throws Exception {
		
		List<ProductOrders> productOrders = new ArrayList<ProductOrders>();
		ProductOrders productOrder;
		
		Connection conn = new DBContext().getConnection();
		
		String sql1 = "select * from orders_detail where order_id = ?;";
		PreparedStatement stm = conn.prepareStatement(sql1);
		stm.setInt(1, idd);
		
		ResultSet rs = stm.executeQuery();
		
		ArrayList<Integer> pID = new ArrayList<Integer>();
		
		while(rs.next()) {
			productOrder = new ProductOrders();
			productOrder.setOrderId(rs.getInt("order_id"));
			productOrder.setProductId(rs.getInt("product_id"));
			pID.add(rs.getInt("product_id"));
			productOrder.setAmountProduct(rs.getInt("amount_product"));
			productOrder.setPriceProduct(rs.getFloat("price_product"));
			productOrders.add(productOrder);
		}
		
		String sql2 = "select product_name from products where product_id = ?";
		PreparedStatement stmt2 = conn.prepareStatement(sql2);
		
		for(int id : pID) {
			stmt2.setInt(1, id);
			ResultSet rs1 = stmt2.executeQuery();
			if(rs1.next()) {
				String name = rs1.getString("product_name");
				for(int i = 0; i < productOrders.size(); i++) {
					if(productOrders.get(i).getProductId() == id) {
						productOrders.get(i).setNameProduct(name);
					}
				}
			}
		}
		
		conn.close();
		
		return productOrders;
	}
	
	//insert orders into DB
	public void insertOrder(Orders o, Cart c) throws Exception {
		
		Connection conn = new DBContext().getConnection();
		
		String sql1 = "insert into orders (user_mail, order_status, order_date, order_discount_code, order_address) values(?, ?, ?, ?, ?);";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		stmt1.setString(1, o.getUserName());
		stmt1.setInt(2, o.getStatus());
		stmt1.setString(3, formatter.format(o.getOrderDate()));
		stmt1.setString(4, o.getDiscount());
		stmt1.setString(5, o.getAddress());
		
		stmt1.execute();
		
		String sql2 ="select order_id from orders where order_date = ?";
		PreparedStatement stmt2 = conn.prepareStatement(sql2);
		stmt2.setString(1, formatter.format(o.getOrderDate()));
		
		ResultSet rs = stmt2.executeQuery();
		int orderId = 0;
		
		if(rs.next()) {
			orderId = rs.getInt("order_id");
		}
		
		List<ProductOrders> productOrders = new ArrayList<ProductOrders>();
		ProductOrders productOrder;
		
		for(Product product : c.getItems()) {
			productOrder = new ProductOrders(orderId, product.getId(), product.getNumber(), product.getName(), product.getPrice());
			productOrders.add(productOrder);
		}
		
		String sql3 = "insert into orders_detail values(?, ?, ?, ?);";
		PreparedStatement stmt3 = conn.prepareStatement(sql3);
		
		int i = 0;
		
		for(ProductOrders order : productOrders) {
			stmt3.setInt(1, orderId);
			stmt3.setInt(2, order.getProductId());
			stmt3.setInt(3, order.getAmountProduct());
			stmt3.setFloat(4, order.getPriceProduct());
			stmt3.addBatch();
			i++;
		}
		
		if(i == productOrders.size()) {
			stmt3.executeBatch();
		}
		
		productOrders.clear();
		conn.close();
		
	}

}
