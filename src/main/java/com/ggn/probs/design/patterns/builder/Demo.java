package com.ggn.probs.design.patterns.builder;

public class Demo {

	public static void main(String[] args) {
		URLBuilder.Builder builder = new URLBuilder.Builder();
		URLBuilder urlBuilder =  builder.protocol("https://").host("127.0.0.1").port(":8080").build();
		
		System.out.println(urlBuilder.toString());
	}

}
