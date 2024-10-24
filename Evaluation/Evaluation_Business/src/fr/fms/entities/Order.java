package fr.fms.entities;

public class Order {

	private int idOrder;
	private double amountOrder;
	private int idCustomer;	
	
	public Order(int idOrder, double amountOrder, int idCustomer) {
		this.idOrder = idOrder;
		this.amountOrder = amountOrder;
		this.idCustomer = idCustomer;
	}
	public Order(double amountTotal, int idCustomer) {
		this.amountOrder = amountTotal;
		this.idCustomer = idCustomer;
	}
	
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public double getAmountOrder() {
		return amountOrder;
	}
	public void setAmountOrder(double amountOrder) {
		this.amountOrder = amountOrder;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
 
}
