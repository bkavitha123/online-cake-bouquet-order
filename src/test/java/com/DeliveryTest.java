package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.model.Delivery;
import com.model.Product;
import com.repository.DeliveryRepository;
import com.service.Deliveryservice;

public class DeliveryTest {

	Deliveryservice deliveryService = new Deliveryservice();
	
	void testGetAllDeliveries() {
		List<Delivery> expectedDeliveries = deliveries;
		List<Delivery> actualDeliveries = deliveryService.getallDeliveries();
		assertEquals(expectedDeliveries,actualDeliveries);
	}
	List<Delivery> deliveries = new ArrayList<>();
	public DeliveryServiceTest() {
		deliveries.add(new Delivery(1,"bunny" ,"bunny@12.com","password","156 steel st",
				Arrays.asList(new Product("cake",20.0),new Product("Bouquet",10.0))));
		deliveries.add(new Delivery(2,"sunny" ,"sunny@12.com","password12","178 iron st",
				Arrays.asList(new Product("cake",25.0))));
	}
	class TestDeliveryRepository implements DeliveryRepository{
		@Override
		public List<Delivery> findAll(){
			return deliveries;
		}

	}
	
	private static final int delivery_id=1;
	private static final String feedback=" nice product";
	private static final String delivery_status="delivered";
	private static final String user_name="akhi";
	private static final String user_email="battu@akhi.com";
	private static final String user_password="akhi@12";
	private static final String user_address =" 123 Main st";
	private static final String product_name="chocolate cake";
	private static final double product_price=29.09;
	private Delivery delivery = new Delivery(delivery_id,feedback,delivery_status,user_name,user_email,user_password,user_address,product_name,product_price);
	private Product product = new Product(product_name,product_price);
	
	@Test
	public void testUpdateDeliveryStatus() {
		
		delivery.Addproduct(product);
		delivery.updateDeliveryStatus(DeliveruStatus.DELIVERED);
		assertEquals(DeliveryStatus.DELIVERED,delivery.getDeliveryStatus());
	}
	
	}
