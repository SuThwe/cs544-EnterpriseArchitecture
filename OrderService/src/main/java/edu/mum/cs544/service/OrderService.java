package edu.mum.cs544.service;

import edu.mum.cs544.VO.Food;
import edu.mum.cs544.VO.ResponseTemplate;
import edu.mum.cs544.VO.User;
import edu.mum.cs544.model.Order;
import edu.mum.cs544.repository.IOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAll() {
        return orderDao.findAll();
    }

    public Order add(Order food) {
        return orderDao.save(food);
    }

    public ResponseTemplate get(int id) {
        ResponseTemplate vo = new ResponseTemplate();
        Order order = orderDao.getById(id);
        Food food = restTemplate.getForObject("http://localhost:8081/api/foods/" + order.getFoodId(), Food.class);
        User user = restTemplate.getForObject("http://localhost:9090/customer/get/" + order.getUserId(), User.class);
        //for (Food f : order.getFood()) {
            //Food food = restTemplate.getForObject("http://localhost:8081/api/foods/", Food.class);
            //vo.addFood(food);
            ////List<Food> foods = food.;
       // }
       
        vo.setOrder(order);
       vo.setFood(food);
        vo.setUser(user);

        return vo;

        // Optional<Food> food = foodDao.findById(id);

        // if(food.isPresent()) {
        // return ResponseEntity.ok().body(food.get());
        // } else {
        // return ResponseEntity.notFound().build();
        // }

    }

    public void update(Order food) {
        orderDao.save(food);
    }

    public void delete(int id) {
        orderDao.deleteById(id);
    }

}
