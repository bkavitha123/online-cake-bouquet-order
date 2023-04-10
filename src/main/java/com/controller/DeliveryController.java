package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Delivery;
import com.service.Deliveryservice;

@RestController
@RequestMapping("DeliveryPerson")
public class DeliveryController {
	
	@Autowired
	private Deliveryservice deliveryservice;
	
	@GetMapping(value = "showAllDeliveris")
	public List<Delivery> getallDeliveries(){
		return deliveryservice.getallDeliveries();
	}
	
	@PutMapping(value = "UpdateDeliveryStatus/{did}")
	public String UpdateDeliveryStatus(@PathVariable("did") int did) throws Exception {
		return deliveryservice.UpdateDeliveryStatus(did);
	}

}
