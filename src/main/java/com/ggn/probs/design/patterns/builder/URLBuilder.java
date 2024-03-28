package com.ggn.probs.design.patterns.builder;

public class URLBuilder {
	public static class Builder {
		private String protocol;
		private String host;
		private String port;
		private String pathParams;
		private String queryParams;
		
		public Builder protocol(String protocol) {
			this.protocol = protocol;
			return this;
		}
		
		public Builder host(String host) {
			this.host = host;
			return this;
		}
		
		public Builder port(String port) {
			this.port = port;
			return this;
		}
		
		public Builder pathParams(String pathParams) {
			this.pathParams = pathParams;
			return this;
		}
		
		public Builder queryParams(String queryParams) {
			this.queryParams = queryParams;
			return this;
		}
		
		public URLBuilder build() {
			return new URLBuilder(this);
		}
	}
	
	
	private final String protocol;
	private final String host;
	private final String port;
	private final String pathParams;
	private final String queryParams;
	
	public URLBuilder(Builder builder) {
		this.protocol = builder.protocol;
		this.host = builder.host;
		this.port = builder.port;
		this.pathParams = builder.pathParams;
		this.queryParams = builder.queryParams;
	}
	
	@Override
	public String toString() {
		String r = "";
		
		r += protocol != null? protocol:"";
		r += host != null ? host: "";
		r += port != null ? port: "";
		r += pathParams != null ? pathParams: "";
		r += queryParams != null ? queryParams: "";;
		
		return r;
		
		
	}
}
