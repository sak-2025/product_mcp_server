package com.sak.products;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.sak.products.ProductMcpServerApplication.class, args);
	}

@Bean
	public List<ToolCallback> productTools(ProductService productService) {
		return List.of(
				ToolCallbacks.from(productService));
	}
}

