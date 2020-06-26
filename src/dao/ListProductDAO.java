package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;

public class ListProductDAO {
	
	
	//return all the of products from DB
	public List<Product> search() throws Exception {
		Product product = null;
		List<Product> products = new ArrayList<Product>();
		Connection conn = new DBContext().getConnection();

		String sql = "select * from products;";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		 
		while(rs.next()) {
			product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setDescription(rs.getString("product_des"));
			product.setPrice(rs.getFloat("product_price"));
			product.setSrc(rs.getString("product_img_source"));
			product.setBrand(rs.getString("product_brand"));
			product.setType(rs.getString("product_type"));
			
			products.add(product);
		}
		
		conn.close();
		
		return products;
	}
	
	//return the list of products by product name
	public List<Product> search(String productName) throws Exception {
		Product product = null;
		List<Product> products = new ArrayList<Product>();
		Connection conn = new DBContext().getConnection();

		String sql = "select * from products where product_name like ?";
		
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, "%" + productName +  "%");
		
		ResultSet rs = stm.executeQuery();
		 
		while(rs.next()) {
			product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setDescription(rs.getString("product_des"));
			product.setPrice(rs.getFloat("product_price"));
			product.setSrc(rs.getString("product_img_source"));
			product.setBrand(rs.getString("product_brand"));
			product.setType(rs.getString("product_type"));
			
			products.add(product);
		}
		
		conn.close();
		
		return products;
	}
	
	//get the product
	public Product getProduct(String productName) throws Exception {
		Product product = null;
		Connection conn = new DBContext().getConnection();
		String sql = "select * from products where product_name = ? or product_id = ?";
		
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, productName);
		stm.setString(2, productName);
		
		ResultSet rs = stm.executeQuery();
		 
		if(rs.next()) {
			product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setDescription(rs.getString("product_des"));
			product.setPrice(rs.getFloat("product_price"));
			product.setSrc(rs.getString("product_img_source"));
			product.setBrand(rs.getString("product_brand"));
			product.setType(rs.getString("product_type"));
		}
		
		conn.close();
		
		return product;
	}

}
