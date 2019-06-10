package com.shravya.eshopfrontend.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.UserDaoImpl;
import com.shravya.eshopbackend.model.User;

@Controller
public class UserController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping("/registr")
	public ModelAndView goToRegForm()
	{
	  User user=new User();
		ModelAndView modelandview=new ModelAndView("register");
		modelandview.addObject("usr",user);
		return modelandview;
	}
  
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
      public ModelAndView recieveUserFormData(@ModelAttribute ("usr") User user)
      {
	  ModelAndView modelAndView=new ModelAndView("userhome");
      userDaoImpl.addUser(user);
      return modelAndView;
      }
	@RequestMapping(value="/login",method=RequestMethod.GET)
	  
	public ModelAndView goToLoginForm(@ModelAttribute ("usr") User user)
     {
	  User user2=new User();
	  ModelAndView modelAndView=new ModelAndView("login");
	  return modelAndView;
     }
	@RequestMapping("/loginerror")
	public ModelAndView loginFailure()
	{
		ModelAndView modelAndView=new ModelAndView("login");
		modelAndView.addObject("message","INVALID USER");
		return modelAndView;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView recieveLoginFormData(@ModelAttribute ("usr") User user)
      {
        boolean result=userDaoImpl.checkLogin(user);
        if(result==true)
         {
           ModelAndView modelAndView=new ModelAndView("loginsuccess");
  	      return modelAndView;
          }
         else {
  	    ModelAndView modelAndView=new ModelAndView("login");
  	 return modelAndView;
	}
}

	@RequestMapping("/afterlogin")
	public String afterLogin(HttpSession session)
	{
	   String page="";
	   //get Username for future purpose
	   //get context object
	   SecurityContext context=SecurityContextHolder.getContext();

	   //get authentication object
	   Authentication authentication=context.getAuthentication();

	   
	String userId=authentication.getName();
	//add userid in session 
	   session.setAttribute("un",userId);
	System.out.println("login username "+userId);
	   //get role(authority) and go to userhome/adminhome
	    Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>)authentication.getAuthorities();

	    for (GrantedAuthority grantedAuthority : authorities) {

	        System.out.println(grantedAuthority);

	        String role=grantedAuthority.getAuthority();

	        if(role.equals("ROLE_USER"))
	        {
	            page="userhome";

	        }
	        else
	        if(role.equals("ROLE_ADMIN"))
	        {
	            page="home";
	        }
	    }
		return page;
	}
}
