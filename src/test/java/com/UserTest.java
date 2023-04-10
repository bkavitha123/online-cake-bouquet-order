package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.Product;
import com.model.User;
import com.model.UserAddress;
import com.repository.ProductRepository;
import com.repository.UserRepository;
import com.service.Userservice;

public class UserTest {

	@Test
	public void testRegisterUser()
	{
		User user = new User();
		user.setId(1);
		user.setName("kavitha");
		user.setEmail("battu@kavi.com");
		user.setPassword("Kavitha@16");
		user.setUserAddress("123 Main st");
		List<Product> products = new ArrayList<>();
		Product product1 = new Product();
		product1.setId(1);
		product1.setProductName("Cake");
		product1.setPrice(19);	
		Product product2 = new Product();
		product2.setId(2);
		product2.setProductName("Bouquet");
		product2.setPrice(90);	
		products.add(product1);
		products.add(product2);
		user.setCartlist(products);
		Userservice userService = new Userservice();
		User result = userService.registerUser(user);
		assertEquals(true,result);
	}
	
	@Test
	public void testLoginUser() {
		User user = new User(1,"kavitha","battu@kavi.com","Kavitha@16","123 Main st",null);
		UserDAO userDAO = new UserDAOImpl();
		userDAO.save(user);
		UserModule userModule = new UserModule.loginUser("battu@kavi.com","Kavitha@16");
		assertNotNull(loggedInUser);
		assertEquals(user.getId(),loggedInUser.getId());
		assertEquals(user.getName(),loggedInUser.getName());
		assertEquals(user.getEmail(),loggedInUser.getEmail());
		assertEquals(user.getPassword(),loggedInUser.getPassword());
		assertEquals(user.getUserAddress(),loggedInUser.getUserAddress());
		
		userDAO.delete(user.getId());
	}
	
	@Test
	public void testAddToCart() throws Exception{
		ProductRepository productRepository = mock(ProductRepository.class);
		Product cake = new Product(1,"chocolate cake",19,"abc");
		Product bouquet = new Product(2,"Rose Bouquet",29,"xyz");
		when(productRepository.findById(1)).thenReturn(Optional.of(cake));
		when(productRepository.findById(2)).thenReturn(Optional.of(bouquet));
		when(productRepository.findById(3)).thenReturn(Optional.empty());
		
		UserRepository userRepository = mock(UserRepository.class);
		User user = new User(1,"siri","siri@123.com","Siri@123","123  Main St");
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		
		User newUser = new User(userRepository,productRepository);
		newUser.Addtocart(1,1);
		assertEquals(1,newUser.getCart().getCartItems().size());
		assertEquals(cake,newUser.getCart().getCartItems().get(0).getProduct());
		assertEquals(1,newUser.getCart().getCartItems().get(0).getQuantity());
		 try {
			 newUser.Addtocart(1,3);
			 fail("expected an exception to be thrown");
		 }
		 catch(Exception e)
		 {
			 assertEquals("product not exist", e.getMessage());
			 }
		 try {
			 newUser.Addtocart(2,1);
			 fail("expected an exception to be thrown");
		 }
		 catch(Exception e)
		 {
			 assertEquals("user not exist", e.getMessage());
			 }
		
	}
	}

