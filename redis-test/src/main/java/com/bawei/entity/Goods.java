package com.bawei.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable{
	
	private Integer id;
	private String name;
	private BigDecimal price;
	private double sell;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getSell() {
		return sell;
	}
	public void setSell(double sell) {
		this.sell = sell;
	}
	public Goods(Integer id, String name, BigDecimal price, double sell) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sell = sell;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", sell=" + sell + "]";
	}
	
	
}
