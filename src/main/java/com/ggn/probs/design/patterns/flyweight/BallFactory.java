package com.ggn.probs.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BallFactory {
	private static final Map<String, Ball> ballMap = new HashMap<>();
	
	public static Ball getBall(String color, String imageUrl) {
		StringBuilder sb = new StringBuilder();
		sb.append(color);
		sb.append(imageUrl);
		
		String cacheKey = sb.toString();
		Ball ball = ballMap.get(cacheKey);
		
		if(ball == null) {
			ball = new Ball(color, imageUrl);
			ballMap.put(cacheKey, ball);
		}
		
		return ball;
	}
}
