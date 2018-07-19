package com.projecto.Horadada.Model;

public class ModeloAuto {

	private String fipeMarca;
	private String name;
	private String marca;
	private String key;
	private String id;
	private String fipeName;
	
	public ModeloAuto() {
	}

	public ModeloAuto(String fipeMarca, String name, String marca, String key, String id, String fipeName) {
		this.fipeMarca = fipeMarca;
		this.name = name;
		this.marca = marca;
		this.key = key;
		this.id = id;
		this.fipeName = fipeName;
	}

	public String getFipeMarca() {
		return fipeMarca;
	}

	public void setFipeMarca(String fipeMarca) {
		this.fipeMarca = fipeMarca;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFipeName() {
		return fipeName;
	}

	public void setFipeName(String fipeName) {
		this.fipeName = fipeName;
	}
	
	
}
