package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Delivery;
import com.model.Product;
import com.model.User;
import com.service.Deliveryservice;
import com.service.ProductService;
import com.service.Userservice;

@RestController
@RequestMapping("Admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Deliveryservice deliveryservice;
	
	@Autowired
	private Userservice userservice;
//	adding products to the Database ;
	@PostMapping(value = "addProduct")
	public Product addproduct( @RequestBody Product product) throws Exception {
		return productService.addProduct(product);
	}
	@GetMapping("getAllUsers")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@GetMapping(value = "showAllFeedbacks")
	public List<Delivery> getallDeliveries(){
		return deliveryservice.getallDeliveries();
	}
	
}
