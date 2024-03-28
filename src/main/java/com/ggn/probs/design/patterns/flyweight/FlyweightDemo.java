package com.ggn.probs.design.patterns.flyweight;

import java.util.AbstractMap;
import java.util.Map;

public class FlyweightDemo {
	private static final String[] color = { "Green", "Yellow", "Pink" };
	private static final Map<String, String> urlMap = Map.ofEntries(
			new AbstractMap.SimpleEntry<String, String>("Green", "url1"),
			new AbstractMap.SimpleEntry<String, String>("Yellow", "url2"),
			new AbstractMap.SimpleEntry<String, String>("Pink", "url3"));

	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i++) {
			String color = getColor();
			String url = urlMap.get(color);
			Ball ball = BallFactory.getBall(color, url);
			ball.setX(getX());
			ball.setY(getY());
			ball.setRadius(75);
			ball.draw();
		}
	}
	
	private static String getColor() {
		return color[(int)(Math.random()*color.length)];
	}
	
	private static int getX() {
		return (int)(Math.random()*50);
	}
	
	private static int getY() {
		 return (int)(Math.random()*50);
	}

}
