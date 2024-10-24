package fr.fms.entities;

public class User {
	private int idUser;
	private String loginUser;
	private String passwordUser;
	
	
	public User(int idUser, String loginUser, String passwordUser) {
		this.idUser = idUser;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
	}


	public User(String loginUser, String passwordUser) {
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
	}


	@Override
	public String toString() {
		return "User [id=" + idUser + ", login=" + loginUser + ", password=" + passwordUser + "]";
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	public String getPasswordUser() {
		return passwordUser;
	}


	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}	
}
