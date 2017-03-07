package com.food.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.CustomerDao;
import com.food.dao.FoodDao;
import com.food.dao.OrderDao;
import com.food.dao.CommentDao;
import com.food.model.Comment;
import com.food.model.Customer;
import com.food.model.Food;
import com.food.model.Order;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class CommentAction extends ActionSupport{
	
	 /*业务层对象*/
    @Resource OrderDao orderDao;
    @Resource CustomerDao customerDao;
    @Resource FoodDao foodDao;
    @Resource CommentDao commentDao;
    
    private Order order;
    private List<Comment> commentList;
    private Customer customer;
    private Food food;
    private Comment comment;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	/*添加Order*/
	public String addComment() throws Exception{
		
		commentDao.AddComment(comment);
	       return "message";
		
	}
	
	/*显示所有Order*/
    public String showComment() {
    	
    	commentList = commentDao.QueryAllComment();
        return "show";
    }

    /*显示某一Order的详细信息*/
    public String showDetail() {
    	System.out.print(comment.getCommentid());
    	comment = commentDao.GetCommentById(comment.getCommentid());
        return "detail_view";
    }
    
    /*显示Order的修改项*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*编辑Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*删除Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /*查询Order*/
    public String queryComments() throws Exception {
    	//food = foodDao.GetFoodById(food.getFoodid());
    	commentList = commentDao.QueryCommentInfo(food);
        return "show";
    }

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


}
