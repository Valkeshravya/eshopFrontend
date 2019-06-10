package com.shravya.eshopfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.CartDaoImpl;
import com.shravya.eshopbackend.daoImpl.ProductDaoImpl;
import com.shravya.eshopbackend.model.Cart;
import com.shravya.eshopbackend.model.Category;
import com.shravya.eshopbackend.model.Product;
import com.shravya.eshopbackend.model.User;

@Controller
public class CartController
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	  @RequestMapping("/cart")
	   public ModelAndView addToCart(HttpServletRequest request,HttpSession  session)
	   {
		  String username=(String)session.getAttribute("un");
		  
		   ModelAndView modelAndView=new ModelAndView("singleproduct");
		 int productId=Integer.parseInt(request.getParameter("pid"));
		 Product product=productDaoImpl.getProduct(productId);
	 	 int quantity=Integer.parseInt(request.getParameter("quan"));
	 	 
	 	 cartDaoImpl.saveCart(product, quantity,username);
	 	 
	 	modelAndView.addObject("buttonName","AddTOCart");
		 return modelAndView;
	   }

	  @RequestMapping("/showcart")
	  public ModelAndView displayCart(HttpSession session) 
	  {
		String userName= (String)session.getAttribute("un");
		  
		ModelAndView modelAndView=new ModelAndView("showcart");
		List<Cart> list=cartDaoImpl.getCartList(userName);
		modelAndView.addObject("add", list);
		return modelAndView;
		
	}

	  @RequestMapping("/de")
	  public String deleteCart(@RequestParam("cartId") int cartId)
	  {
		  ModelAndView modelAndView=new ModelAndView("showcart");
		  Cart cart=cartDaoImpl.getCart(cartId);
		  cartDaoImpl.deleteCart(cart);
		  return "redirect:showcart";
	  }
	  
	  @RequestMapping("/update")
	  public ModelAndView updateCart(@RequestParam("cartId") int cartId,int productId)
	  {
		  ModelAndView modelAndView=new ModelAndView("singleproduct");
		  Cart cart=cartDaoImpl.getCart(cartId);
		  modelAndView.addObject("add",cart);
		Product product=productDaoImpl.getProduct(productId);
		  modelAndView.addObject("showdata",product);
		  modelAndView.addObject("buttonName","Update Cart");
		  return modelAndView;
	  }
}
