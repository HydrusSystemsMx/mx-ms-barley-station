package com.icn.barleystation.components;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.icn.barleystation.entity.DeliveryEntity;
import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.service.IDeliveryService;
import com.icn.barleystation.service.IOrderService;

@Component
public class CronOrder {

	@Autowired
	IOrderService orderService;

	@Autowired
	IDeliveryService deliveryService;

	@Scheduled(fixedRate = 3000000)
	public void fixedRateSch() {

		List<OrderEntity> orderTaken = new ArrayList<>();
		List<OrderEntity> allOrders = orderService.getCurrentOrders();

		if (!allOrders.isEmpty()) {
			List<OrderEntity> distrincOrders = distincOrders(allOrders);
			DeliveryEntity delivery = getDelivery();

			for (int i = 0; i < distrincOrders.size(); i++) {
				System.out.println("Ordenes pendientes: " + distrincOrders.get(i).getIdRequest());
				orderTaken.add(distrincOrders.get(i));
			}

			if (delivery.getIdDelivery() != null && orderTaken != null) {
				deliveryService.assignToDelivery(delivery, orderTaken);
			} else {
				System.out.println("No hay pedidos actuales o repartidores disponibels");
			}

			// Delivery process!

			// Update status to order is taken
		}

	}

	public DeliveryEntity getDelivery() {
		DeliveryEntity delivery = new DeliveryEntity();
		List<DeliveryEntity> avaliableDeliverys = deliveryService.getDeliveryAvaliable();

		if (avaliableDeliverys.size() > 0) {
			delivery = avaliableDeliverys.get(0);
		}

		return delivery;

	}

	public List<OrderEntity> distincOrders(List<OrderEntity> currentOrders) {
		List<OrderEntity> orderList = new ArrayList<>();

		for (int i = 0; i < currentOrders.size(); i++) {
			if (i == 0) {
				orderList.add(currentOrders.get(i));
			} else {
				if (currentOrders.get(i).getIdRequest().equals(currentOrders.get(i - 1).getIdRequest())) {
					System.out.print("");
				} else {
					orderList.add(currentOrders.get(i));
				}

			}

		}

		return orderList;

	}

	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date now = new Date();
		String strDate = sdf.format(now);
		// System.out.println("Fixed Rate scheduler:: " + strDate);

		return strDate;
	}

}