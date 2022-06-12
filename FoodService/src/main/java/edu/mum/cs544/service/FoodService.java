package edu.mum.cs544.service;

import edu.mum.cs544.model.Food;
import edu.mum.cs544.repository.IFoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodService {

    @Autowired
    private IFoodDao foodDao;

    public List<Food> getAll(){
     return foodDao.findAll();
    }

    public Food add(Food food) {return foodDao.save(food);}

    public Food  get(int id)
    {
        return foodDao.findById(id).get();
    }

    public void update(Food food) {
        foodDao.save(food);
    }

    public void delete(int id) {
        foodDao.deleteById(id);
    }

}
