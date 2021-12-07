package com.icn.barleystation.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.service.IOrderService;

@Component
public class CronOrder {
	
	@Autowired
	IOrderService orderService;
	
	@Scheduled(fixedRate = 5000)
	public void fixedRateSch() {
		
		List<OrderEntity> currentOrders = orderService.getCurrentOrders();

		for(OrderEntity order : currentOrders) {
			System.out.println("Order: " + order.getIdRequest());
		}
		
		//Delivery process!
		
		//Update status to order is taken
		
	}
	
	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date now = new Date();
		String strDate = sdf.format(now);
		//System.out.println("Fixed Rate scheduler:: " + strDate);
		
		return strDate;
	}
}