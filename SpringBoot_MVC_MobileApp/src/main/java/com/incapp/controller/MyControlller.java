package com.incapp.controller;

import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.incapp.dao.Mobile;
import com.incapp.repo.MobileRepo;

@Controller
public class MyControlller {
	
	@Autowired
	MobileRepo mobileRepo;
	
	//home 
	@RequestMapping("/")
	public String home() {
		return"index";
	}
	
	//addMobile
	@RequestMapping("/addMobile")
	public String addMobile(@ModelAttribute Mobile m ,Part image1  ,Model model ) {
		
		InputStream in1 =null;
		if(image1!=null) {
		try {
				in1 = image1.getInputStream();
			
		} catch (Exception e) {
			in1 = null;
		}
	}
		
		String result = mobileRepo.addMobile(m, in1);
		
		model.addAttribute("result",result);
	
		return"index";
		
	}
	
	
	@RequestMapping("/update")
	public String updatePage() {
		
		return"update";
	}
	
	
	//common values 
    @ModelAttribute()
    public void commonValues(Model model) {
      List<String> n =	mobileRepo.getAllMobilesNames();
      model.addAttribute("name", n);
    	
    }
    
    @RequestMapping("/updateMobile")
    public String updateMobile(@ModelAttribute Mobile m , String names , Model model ) {
     
    String update =	mobileRepo.updateMobile(m, names);
    
   model.addAttribute("u",update);
    	
    	return"update";
    }
    
    
   @RequestMapping("/getAllData")
   public String getAllData(Model model) {
	   
	  List<Mobile> mobiles = mobileRepo.getallMobile();
	   
			  model.addAttribute("mdata", mobiles);
	   
	   return"getAllData";
	   
   }
   
   //getImge1
   
   @RequestMapping("/getImage")
   public void getImage(String name , HttpServletResponse response ) {   
	   
	   try {
		  byte [] b =mobileRepo.getImage1(name);
		 response.getOutputStream().write(b);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
   }
   
   
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
