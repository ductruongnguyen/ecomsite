package model;

public class ProductOrders {
	
	private int orderId;
	private int productId;
	private int amountProduct;
	private String nameProduct;
	private float priceProduct;
	
	public ProductOrders() {
		super();
	}
	
	public ProductOrders(int orderId, int productId, int amountProduct, String nameProduct, float priceProduct) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	

}
