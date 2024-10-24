package fr.fms.entities;

public class Customer {
	
	@Override
	public String toString() {
		return " " + nameCustomer + " , " + surnameCustomer + " , " + emailCustomer + " , " + phoneCustomer + " , " + addressCustomer;
	}

	private int idCustomer;
	private String nameCustomer;
	private String surnameCustomer;
	private String emailCustomer;
	private String phoneCustomer;
	private String addressCustomer;
	private int idUser;
	
	
	public Customer(int idCustomer, String nameCustomer, String surnameCustomer, String emailCustomer,
			String phoneCustomer, String addressCustomer, int idUser) {
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.surnameCustomer = surnameCustomer;
		this.emailCustomer = emailCustomer;
		this.phoneCustomer = phoneCustomer;
		this.addressCustomer = addressCustomer;
		this.idUser = idUser;
	}
	
	public Customer(String nameCustomer, String surnameCustomer, String emailCustomer,
			String phoneCustomer, String addressCustomer, int idUser) {
		this.nameCustomer = nameCustomer;
		this.surnameCustomer = surnameCustomer;
		this.emailCustomer = emailCustomer;
		this.phoneCustomer = phoneCustomer;
		this.addressCustomer = addressCustomer;
		this.idUser = idUser;
	}
	
	
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getSurnameCustomer() {
		return surnameCustomer;
	}
	public void setSurnameCustomer(String surnameCustomer) {
		this.surnameCustomer = surnameCustomer;
	}
	public String getEmailCustomer() {
		return emailCustomer;
	}
	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}
	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public String getAddressCustomer() {
		return addressCustomer;
	}
	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
