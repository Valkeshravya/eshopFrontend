package com.shravya.eshopfrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shravya.eshopbackend.daoImpl.CartDaoImpl;
import com.shravya.eshopbackend.daoImpl.CategoryDaoImpl;
import com.shravya.eshopbackend.daoImpl.ProductDaoImpl;
import com.shravya.eshopbackend.daoImpl.SupplierDaoImpl;
import com.shravya.eshopbackend.model.Category;
import com.shravya.eshopbackend.model.Product;
import com.shravya.eshopbackend.model.Supplier;
@Controller
public class ProductController
{
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
    @RequestMapping("/product")   
	public ModelAndView saveProduct()
	{
		ModelAndView modelAndView=new ModelAndView("product");
		Product product=new Product();
		//product.setProductId((int)(Math.random()*1000));
		modelAndView.addObject("pro", product);
		  List<Category> catList=categoryDaoImpl.getCategoryList();
	        modelAndView.addObject("catlist",catList);
	        List<Supplier> supList=supplierDaoImpl.getSupplierList();
	        modelAndView.addObject("suplist", supList);

		modelAndView.addObject("buttonName","Add Product");
		return modelAndView;
	}

    @RequestMapping(value="/addPro",method=RequestMethod.POST)
    public ModelAndView recieveProductFormData(@ModelAttribute ("pro") Product pr)
    {
    
        ModelAndView modelAndView=new ModelAndView("home");
        if(pr.getProductId()==0)
    	  {
    		  productDaoImpl.saveProduct(pr);
    	  }
    	  else
    	  {
    		productDaoImpl.editProduct(pr);
    	}
      
        MultipartFile image=pr.getProductImage();
        System.out.println("Testing image------"+image);
        BufferedOutputStream bos = null;
        try {
        	byte bytearray[]=image.getBytes();
        	FileOutputStream fos=new FileOutputStream("G:\\eclipse-workspace2\\eshopfrontend\\src\\main\\webapp\\resources\\images\\"+pr.getProductId()+".jpg");
             bos=new BufferedOutputStream(fos);
			bos.write(bytearray);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
        	try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return modelAndView;
    }
    @RequestMapping("/showp")
    public ModelAndView showProductData(Product product)
    {
    	ModelAndView modelAndView=new ModelAndView("showproducts");
    	List<Product> list=productDaoImpl.getProductList();
    	modelAndView.addObject("showdata",list);
    	return modelAndView;
    }
    @RequestMapping("/delet")
    public String deleteProduct(@RequestParam("proId") int productId)
    {
    	ModelAndView modelAndView=new ModelAndView("showproducts");
    	Product product=productDaoImpl.getProduct(productId);
    	productDaoImpl.deleteProduct(product);
		File file=new File("G:\\eclipse-workspace2\\eshopfrontend\\src\\main\\webapp\\resources\\images\\"+productId+".jpg");
		file.delete();
    	return "redirect:showp";
    }
    
    @RequestMapping("/edt")
    public ModelAndView editProductData(@RequestParam("proId") int productId)
    {
    	ModelAndView modelAndView=new ModelAndView("product");
        Product product=productDaoImpl.getProduct(productId);
        modelAndView.addObject("pro",product);
        List<Category> catList=categoryDaoImpl.getCategoryList();
        modelAndView.addObject("catlist",catList);
        List<Supplier> supList=supplierDaoImpl.getSupplierList();
        modelAndView.addObject("suplist", supList);
        modelAndView.addObject("buttonName","Update Product");
	    return modelAndView;	
	}
 
    @RequestMapping("/userproducts") 
    public ModelAndView userproducts()
    {
 	   ModelAndView modelAndView=new ModelAndView("userproducts");
 	   productDaoImpl.getProductList();
    	List<Product> list=productDaoImpl.getProductList();
    	modelAndView.addObject("showdata",list);
       return modelAndView;	
    }
    
    @RequestMapping("/productdetail")
    public ModelAndView displayProduct(@RequestParam("pid") int  productId)
    {
 	   ModelAndView modelAndView=new ModelAndView("singleproduct");
 	 Product product= productDaoImpl.getProduct(productId);
 	   modelAndView.addObject("showdata",product);
 	   return modelAndView;
    }
    
}
