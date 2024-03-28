package com.ggn.probs.design.patterns.flyweight;

public class Ball {
	private String color;
	private String imageUrl;
	private int x;
	private int y;
	private int radius;
	
	public Ball(String color, String imageUrl) {
		this.color = color;
		this.imageUrl = imageUrl;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("Draw Ball");
	}
}
