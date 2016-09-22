package com.base.action;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.base.biz.UsersBiz;
import com.base.biz.impl.UsersBizImpl;
import com.base.entity.Users;


public class UsersAction {
	UsersBiz biz=null;
	Users user=new Users();

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public void setBiz(UsersBiz biz) {
		this.biz = biz;
	}
   public String findAll() throws IOException{
	//public List findAll() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse reponse = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		List list = biz.findAll();
		session.setAttribute("list", list);
		String url="error.jsp";
		if(list!=null){
			url="index.jsp";
		}
		reponse.sendRedirect(url);
		return null;
		//return list;
	}
    public String save() throws IOException{
    	HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		int i=biz.save(user);
		String url="error.jsp";
		if(i>0){
			url="list.action";
		}
		response.sendRedirect(url);
    	return null;
    }
//	public static void main(String[] args) throws IOException {
//		UsersAction usersAction = new UsersAction();
//		List list =  usersAction.findAll();
//		System.out.println(list);
//		//System.out.println(list.toString());
//	}
    public String delete() throws IOException{
    	HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		Users user1=biz.findById(user.getId());
		int i=biz.delete(user1);
		String url="error.jsp";
		if(i>0){
			url="list.action";
		}
		response.sendRedirect(url);
    	return null;
    }
    public String update() throws IOException{
    	HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		Users user2=biz.findById(user.getId());
		user2.setName(user.getName());
		user2.setPassword(user.getPassword());
		int i=biz.attachDirty(user2);
		String url="error.jsp";
		if(i>0){
			url="list.action";
		}
		response.sendRedirect(url);
		return null;
    
    }

	
	
}
