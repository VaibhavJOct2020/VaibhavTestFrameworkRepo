package vaibhav.framework.pojo;

public class ProductDetailsPojo {
	
	private String unitPrice;   
	private String quantity; 
	private String size; 
	private String colour;
	private String productName;
	private String productPrice; 
		
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String unitPrice) {
		int intQuantity = Integer.parseInt(quantity);
		System.out.println(intQuantity);
		String actualUnitprice = unitPrice.substring(1);
		System.out.println(actualUnitprice);
		double intUnitPrice = Double.parseDouble(actualUnitprice);
		System.out.println(intQuantity);
		double intproductPrice = intQuantity * intUnitPrice;
		productPrice = ""+String.format("%.2f", intproductPrice);
		
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
}
