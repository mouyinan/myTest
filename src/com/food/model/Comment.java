package com.food.model;



/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment  implements java.io.Serializable {


    // Fields    

     private Integer commentid;
     private Customer customer;
     private Food food;
     private String comment;


    // Constructors

    /** default constructor */
    public Comment() {
    }

    
    /** full constructor */
    public Comment(Customer customer, Food food, String comment) {
        this.customer = customer;
        this.food = food;
        this.comment = comment;
    }

   
    // Property accessors

    public Integer getCommentid() {
        return this.commentid;
    }
    
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Food getFood() {
        return this.food;
    }
    
    public void setFood(Food food) {
        this.food = food;
    }

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
   








}