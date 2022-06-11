package edu.mum.cs544.VO;

import java.util.List;

import edu.mum.cs544.model.Order;


public class ResponseTemplate {

    //private List<Food> food;
    private Order order;
    private User user;
    private Food food;
    
    
    public ResponseTemplate() {
    }

    

    public ResponseTemplate(Food food, Order order, User user) {
        this.food = food;
        this.order = order;
        this.user = user;
    }


    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }


    // public List<Food> getFood() {
    //     return food;
    // }

    // public void setFood(List<Food> food) {
    //     this.food = food;
    // }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    // public void addFood(Food food) {
    //     this.food.add(food);
    // }


    
}
