package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;

public class ProductTest {

	private ProductService productService;
	
	@Test
	public void testAddProduct() {
		Product product = new Product(1,"chocolate cake",25.99);
		productService.addProduct(product);
		List<Product> products = productService.getAllProducts();
		assertEquals(1,products.size());
		assertEquals("chocolate Cake",products.get(0).getProductName());
		assertEquals(25.99,products.get(0).getPrice(),0.01);
	}
	
	@Test
	public void testGetAllProducts() {
		List<Product> expectedProducts = new ArrayList<>();
		expectedProducts.add(new Product(1,"chocolate cake",20.0));
		expectedProducts.add(new Product(2,"Rose Bouquet",15.0));
		List<Product> actualProducts = productService.getAllProducts();
		assertEquals(expectedProducts,actualProducts);
		
	}
	
	
}
