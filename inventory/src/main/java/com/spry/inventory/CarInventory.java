package com.spry.inventory;


public class CarInventory {

	private String name;
	private int count;
	private float cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public CarInventory(String name, int count, float cost) {
		super();
		this.name = name;
		this.count = count;
		this.cost = cost;
	}
	
	
}
