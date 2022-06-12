package edu.mum.cs544.controller;

import edu.mum.cs544.model.Food;
import edu.mum.cs544.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Food> getAll(){return foodService.getAll();}

    @GetMapping(value = "/{id}", produces = "application/json")
    public Food get(@PathVariable (value = "id") int id)
    {
        return foodService.get(id);
    }

    @PostMapping(value = "/", consumes = "application/json")
    public RedirectView add( @RequestBody Food food){
       Food f= foodService.add(food);
       return new RedirectView("/api/foods/"+f.getId());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public String update (@PathVariable (value = "id") int id, @RequestBody Food food)
    {
        if(id!=food.getId()){throw new IllegalArgumentException();}
        foodService.update(food);
        return "Food with id = " + id + " is updated.";
    }

    @DeleteMapping(value = "/{id}")
    public String delete (@PathVariable int id){
        foodService.delete(id);
        return "Food with id = " + id + " is deleted.";
    }

}
