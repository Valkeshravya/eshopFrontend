package com.shravya.eshopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.CategoryDaoImpl;
import com.shravya.eshopbackend.model.Category;

@Controller
public class CategoryController 
{
@Autowired
CategoryDaoImpl categoryDaoImpl;
  public CategoryController()
  {
	System.out.println("Category Controller");
  }
  @RequestMapping("/category")
  public ModelAndView goToCategoryForm()
  {
	  Category category=new Category();
	  ModelAndView modelAndView=new ModelAndView("category");
	  System.out.println(categoryDaoImpl);
	 
	  modelAndView.addObject("cat",category);
	  modelAndView.addObject("buttonName","Add Category");
	  return modelAndView;
  }
  
  @RequestMapping(value = "/addcat",method = RequestMethod.POST)
  public ModelAndView recieveCategoryFormData(@ModelAttribute("cat") Category category)
  {
	  ModelAndView modelAndView=new ModelAndView("home");
	//categoryDaoImpl.saveCategory(category);

	  if(category.getCategoryId()==0)
	  {
		  categoryDaoImpl.saveCategory(category);
	  }
	  else
	  {
		categoryDaoImpl.editCategory(category);
	}

	  return modelAndView;
  }
  
  @RequestMapping("/show")
 	public ModelAndView recieveData()
 		{
 		ModelAndView modelAndView=new ModelAndView("showcategory");	
 	
 		List<Category> list=categoryDaoImpl.getCategoryList();
        modelAndView.addObject("data", list);
 		return modelAndView;
 		}
  @RequestMapping("/del")
	 public String deleteCategory(@RequestParam("catId") int categoryId)
	 {
		 System.out.println(categoryId);
		 ModelAndView modelAndView=new ModelAndView("showcategory");
		 Category category= categoryDaoImpl.getCategory(categoryId);
		 categoryDaoImpl.deleteCategory(category);
	     return "redirect:show";
  }
  @RequestMapping("/edit")
  public ModelAndView updateCategory(@RequestParam("catId") int categoryId)
  {
	  ModelAndView modelAndView=new ModelAndView("category");
	  Category category=categoryDaoImpl.getCategory(categoryId);
	  modelAndView.addObject("cat",category);
	  modelAndView.addObject("buttonName","Update Catogory");
	  return modelAndView;
  }
}
