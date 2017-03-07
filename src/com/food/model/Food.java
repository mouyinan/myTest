package com.food.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food  implements java.io.Serializable {


    // Fields    

     private Integer foodid;
     private String foodname;
     private Integer price;
     private String filepath;
     private Integer vipprice;
     private Set orders = new HashSet(0);
     private Set comments = new HashSet(0);


    // Constructors

    /** default constructor */
    public Food() {
    }

	/** minimal constructor */
    public Food(String foodname, Integer price, String filepath, Integer vipprice) {
        this.foodname = foodname;
        this.price = price;
        this.filepath = filepath;
        this.vipprice = vipprice;
    }
    
    /** full constructor */
    public Food(String foodname, Integer price, String filepath, Integer vipprice, Set orders, Set comments) {
        this.foodname = foodname;
        this.price = price;
        this.filepath = filepath;
        this.vipprice = vipprice;
        this.orders = orders;
        this.comments = comments;
    }

   
    // Property accessors

    public Integer getFoodid() {
        return this.foodid;
    }
    
    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return this.foodname;
    }
    
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFilepath() {
        return this.filepath;
    }
    
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Integer getVipprice() {
        return this.vipprice;
    }
    
    public void setVipprice(Integer vipprice) {
        this.vipprice = vipprice;
    }

    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }

    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }
   








}