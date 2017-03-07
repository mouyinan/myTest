package com.food.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer  implements java.io.Serializable {


    // Fields    

     private Integer customerid;
     private String name;
     private String password;
     private Integer role;
     private Set comments = new HashSet(0);
     private Set orders = new HashSet(0);


    // Constructors

    /** default constructor */
    public Customer() {
    }

	/** minimal constructor */
    public Customer(String name, String password, Integer role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
    
    /** full constructor */
    public Customer(String name, String password, Integer role, Set comments, Set orders) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.comments = comments;
        this.orders = orders;
    }

   
    // Property accessors

    public Integer getCustomerid() {
        return this.customerid;
    }
    
    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return this.role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }

    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }

    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }
   








}