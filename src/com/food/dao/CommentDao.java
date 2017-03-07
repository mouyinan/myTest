package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import com.food.model.Customer;
import com.food.model.Food;
import com.food.model.Comment;
import com.food.model.Order;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class CommentDao {
	@Resource SessionFactory factory;
	
	 /*添加Comment信息*/
    public void AddComment(Comment comment) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(comment);
    }
    
    /*删除Comment信息*/
    public void DeleteComment (Integer commentId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object comment = s.load(Comment.class, commentId);
        s.delete(comment);
    }
    
    /*更新Comment信息*/
    public void UpdateComment(Comment comment) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(comment);
    }
    
    /*查询所有Comment信息*/
    public ArrayList<Comment> QueryAllComment() {
        Session s = factory.getCurrentSession();
        String hql = "From Comment";
        Query q = s.createQuery(hql);
        List CommentList = q.list();
        return (ArrayList<Comment>) CommentList;
    }

    /*根据主键获取对象*/
    public Comment GetCommentById(Integer commentid) {
        Session s = factory.getCurrentSession();
        Comment comment = (Comment)s.get(Comment.class, commentid);
        return comment;
    }
    
    /*根据查询条件查询，一般来说，订单查询时，会根据用户ID查对应的订单，或根据美食的名称查对应的订单*/
    public ArrayList<Comment> QueryCommentInfo( Food food) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Comment comment where 1=1";
    	
    	if(null != food && null!=food.getFoodname()) 
    		hql = hql + " and comment.food.foodname  ='"+ food.getFoodname() + "'";
    	Query q = s.createQuery(hql);
    	List CommentList = q.list();
    	return (ArrayList<Comment>) CommentList;
    }

}
