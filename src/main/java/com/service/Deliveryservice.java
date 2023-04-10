package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Delivery;
import com.repository.DeliveryRepository;
import com.repository.OrderredProductRepo;

@Service
public class Deliveryservice {
	@Autowired
	private OrderredProductRepo orderredProductRepo;

	@Autowired
	private DeliveryRepository deliveryRepository;

//	to see all Deliveries
	public List<Delivery> getallDeliveries() {
		return deliveryRepository.findAll();
	}
//	to update the delivery Status
	public String UpdateDeliveryStatus(int deliveryId) throws Exception {
		Delivery delivery = deliveryRepository.findById(deliveryId).get();
		if(delivery != null) {
			delivery.setDeliveryStatus("Delivered");
			deliveryRepository.save(delivery);
			return "SuccessFully Delivered the Product";
		}else {
			throw new Exception("No Order found");
		}
		
	}
	
	public List<Delivery> findAllUserOrders(int uid){
		return deliveryRepository.findAllByUserid(uid);
	}
	
	public String AddFeedback(int did,String feedback) throws Exception {
		Delivery delivery = deliveryRepository.findById(did).get();
		if(delivery != null) {
			if(delivery.getDeliveryStatus().equalsIgnoreCase("Delivered")) {
				delivery.setFeedback(feedback);
				deliveryRepository.save(delivery);
				return "Thanks for your FeedBack ";
			}else {
				return "Still Your Order is Not Delivery !! Thank For Your Interest";
			}
			
		}else {
			throw new Exception("No Order found");
		}
	}

}
