package com.food.dao;

import java.util.ArrayList;
import java.util.List;
import com.food.model.Food;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class FoodDao {
	@Resource SessionFactory factory;
	public void AddFood(Food food)throws Exception{
		Session s = factory.getCurrentSession();
    	s.save(food);
		
	}
	public void DeleteFood(int foodid)throws Exception{
		Session s = factory.getCurrentSession(); 
        Object food = s.load(Food.class, foodid);
        s.delete(food);
		}
	 public void UpdateFood(Food food) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(food);
	    }
	 public Food GetFoodById(int foodid) {
	        Session s = factory.getCurrentSession();
	        Food food= (Food)s.get(Food.class, foodid);
	        return food;
	        }
	 @Transactional(propagation=Propagation.NOT_SUPPORTED)
	    public ArrayList<Food> QueryAllFoods() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Food";//等同于select*from food;
	        Query q = s.createQuery(hql);
	        List foodList = q.list();//把查询的结果放入一个List中，List中的每个数据就是一个food对象。
	        return (ArrayList<Food>) foodList;
	    }
	 @Transactional(propagation=Propagation.NOT_SUPPORTED)
	    public ArrayList<Food> QueryFoodInfo(String foodname) { 
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Food food where 1=1";//防止输入的查询的条件为空时报错，如果不写查询条件，相当于是全表查询。
	    	if(!foodname.equals("")) hql = hql + " and food.foodname ='" +foodname + "'";
	    	Query q = s.createQuery(hql);
	        List foodList = q.list();
	    	return (ArrayList<Food>) foodList;
	    }
}
