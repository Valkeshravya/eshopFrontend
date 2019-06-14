package com.shravya.eshopfrontend.controller;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.CartDaoImpl;
import com.shravya.eshopbackend.daoImpl.OrderDaoImpl;
import com.shravya.eshopbackend.daoImpl.UserDaoImpl;
import com.shravya.eshopbackend.model.Cart;
import com.shravya.eshopbackend.model.ShippingAddress;
import com.shravya.eshopbackend.model.User;
import com.shravya.eshopbackend.model.UserOrder;
@Controller
public class OrdersController 
{
	@Autowired
	CartDaoImpl cartDaoImpl;
	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	OrderDaoImpl orderDaoImpl;
	
	 @RequestMapping("/order")
	  public ModelAndView placeOrder(HttpSession httpSession)
	  {
		 String email=(String)httpSession.getAttribute("un");
		User user=userDaoImpl.getUser(email);
		ShippingAddress shippingAddress;
		shippingAddress=user.getShippingAddress();
		  ModelAndView modelAndView=new ModelAndView("shippingaddress");
		  modelAndView.addObject("shi",shippingAddress);
		  return modelAndView;
	  }
	 @RequestMapping(value = "/shipadd",method = RequestMethod.POST)
    public ModelAndView getShippingForm(@ModelAttribute("shi") ShippingAddress shippingAddress,HttpSession httpSession)
    {
		 ModelAndView modelAndView=new ModelAndView("orderdetails");
		 UserOrder userOrder=new UserOrder();
		 Cart cart=new Cart();
		 Date date=new Date();
		 String em=(String)httpSession.getAttribute("un");
		 System.out.println(em);
		 List<Cart> list=cartDaoImpl.getCartList(em);
		 int totalP=0;
	     for (Cart cart2:list) 
	     {
			totalP=totalP+cart2.getTotalPrice();
		}
	     userOrder.setGrandTotal(totalP);
		 userOrder.setDate(date);
		// userOrder.setShippingAddress(shippingAddress);
		 System.out.println(totalP);
		User user=userDaoImpl.getUser(em);
		user.setShippingAddress(shippingAddress);
		userOrder.setUser(user);
		orderDaoImpl.saveOrder(userOrder);
		modelAndView.addObject("sh",userOrder);
		 return modelAndView;
    }
	 @RequestMapping("/myorder")
	 public ModelAndView myOrders(HttpSession httpSession)
	 {
		 ModelAndView modelAndView=new ModelAndView("myorders");
		 String em=(String)httpSession.getAttribute("un");
		 List<UserOrder> list=orderDaoImpl.getMyOrders(em);
		 System.out.println("list-------"+list);
		 modelAndView.addObject("ord",list);
		 return modelAndView;
	 }
}
