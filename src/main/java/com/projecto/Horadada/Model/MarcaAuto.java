package com.projecto.Horadada.Model;

public class MarcaAuto {

	private String name;
	private String fipe_name;
	private int order;
	private String key;
	private int id;

	public MarcaAuto() {
	}

	public MarcaAuto(String name, String fipe_name, int order, String key, int id) {
		this.name = name;
		this.fipe_name = fipe_name;
		this.order = order;
		this.key = key;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
