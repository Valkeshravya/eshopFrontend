package com.shravya.eshopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.SupplierDaoImpl;
import com.shravya.eshopbackend.model.Supplier;

@Controller
public class SupplierController
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@RequestMapping("/supplier")
	public ModelAndView goToSupplierForm()
	{
	    ModelAndView  modelAndView=new ModelAndView("supplier");
	    
	    modelAndView.addObject("sup",new Supplier());
	    modelAndView.addObject("buttonName","Add Supplier");
	    return  modelAndView;
	}

	@RequestMapping(value="/addsup",method=RequestMethod.POST)
	public ModelAndView recieveSupplierFormData(@ModelAttribute ("sup") Supplier supplier)
	{
		
	    ModelAndView modelAndView=new ModelAndView("home");
	    if(supplier.getSupplierId()==0)
		  {
			  supplierDaoImpl.saveSupplier(supplier);
		  }
		  else
		  {
			supplierDaoImpl.editSupplier(supplier);
		}
		
	    
	    return modelAndView;

	}
	  @RequestMapping("/showSupp")
	 	public ModelAndView recieveData()
	 		{
	 		ModelAndView modelAndView=new ModelAndView("showsupplier");	
	 	
	 		List<Supplier> list=supplierDaoImpl.getSupplierList();
	 		modelAndView.addObject("datarecieve", list);
	 		return modelAndView;
	 		}

	
	@RequestMapping("/delete")
	 public String deleteCategory(@RequestParam("suppId") int supplierId)
	 {
		Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
		supplierDaoImpl.deleteSupplier(supplier);
		 return "redirect:showSupp"; 
		 }
	
 @RequestMapping("/ed")
 public ModelAndView updateCategory(@RequestParam("suppId") int supplierId)
 {
	  ModelAndView modelAndView=new ModelAndView("supplier");
	  Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
	 
	  modelAndView.addObject("sup",supplier);
	  modelAndView.addObject("buttonName","Update Supplier");
	  return modelAndView;
 }


}
