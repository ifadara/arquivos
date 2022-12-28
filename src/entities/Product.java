package entities;

public class Product {
	
	private String description;
	private Double value;
	private Integer quantity;
	
	
	public Product(String description, Double value, Integer quantity) {
		super();
		this.description = description;
		this.value = value;
		this.quantity = quantity;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double calculateTotalValue() {
		return quantity * value; 
	}


	@Override
	public String toString() {
		return description + "," + String.format("%.2f", calculateTotalValue());
	}
	
	
	

}
