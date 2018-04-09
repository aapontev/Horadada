package com.projecto.Horadada.model;

public class UsuarioPrueba {

	private String username;
	private String contrase;
	private int tipoUser;
	
	
	public UsuarioPrueba() {
		super();
	}
	public UsuarioPrueba(String username, String contrase, int tipPer) {
		super();
		this.username = username;
		this.contrase = contrase;
		this.tipoUser = tipPer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrase() {
		return contrase;
	}
	public void setContrase(String contrase) {
		this.contrase = contrase;
	}
	public int getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}
	
	
}
