package com.model;

import java.time.LocalDate;

public class Order {

	private int orderId;
	private LocalDate orderDate;
	private int regionId;
	private int orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", regionId=" + regionId + ", orderStatus="
				+ orderStatus + "]";
	}
	public Order(int orderId, LocalDate orderDate, int regionId, int orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.regionId = regionId;
		this.orderStatus = orderStatus;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
