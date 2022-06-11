package edu.mum.cs544.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import edu.mum.cs544.VO.Food;

@Entity
@Table(name = "Orders")
public class Order {

    public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}

    @Id
    @GeneratedValue
    private Integer id;
    @Positive
    private double totalPrice;

    private Date orderDate= new Date();
    @Lob
    private String specialNote;

    @Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.Created;

    private Integer userId;
    private Integer foodId;

  // private List<Food> foods;
    

    public Order() {
    }


    public Order(@Positive double totalPrice, Date orderDate, String specialNote, OrderStatus orderStatus,
            Integer userId, Integer foodId) {
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.specialNote = specialNote;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.foodId = foodId;
    }






    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    // public List<Food> getFood() {
    //     return foods;
    // }



    // public void setFood(List<Food> food) {
    //     this.foods = food;
    // }



    public double getTotalPrice() {
        return totalPrice;
    }



    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public Date getOrderDate() {
        return orderDate;
    }



    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }



    public String getSpecialNote() {
        return specialNote;
    }



    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }



    public OrderStatus getOrderStatus() {
        return orderStatus;
    }



    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getFoodId() {
        return this.foodId;
    }


    // public void addFood(Food food) {
    //     this.foods.add(food);
    // }



    
    
}
