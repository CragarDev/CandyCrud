package com.cragardev.candycrud.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cragardev.candycrud.models.Candy;
import com.cragardev.candycrud.services.CandyService;

@Controller
public class HomeController {
	
	
	// Inject the Service
	private final CandyService candyService;
	

	 public HomeController(CandyService candyService) {
		super();
		this.candyService = candyService;
	}

	 
	//
    // ========= /, Landing, home, index page 1 ===========
    //
    @GetMapping("/")
    public String index() {

        return "index.jsp";
    }

    //
    // ========= /candy, Landing, home, index page 1 ===========
    //
    @GetMapping("/candy")
    public String home() {

        return "index.jsp";
    }

    //
    // ========= Candy Dashboard page ===========
    // To show all candies
    //
    @GetMapping("/candy/dashboard")
    public String dashboard(Model model) {
    	
    	// Send all our candies to the JSP using Model model
    	model.addAttribute("candies", candyService.allCandys());

        return "dashboard.jsp";
    }

    //
    // ========= Show One Candy page ===========
    //
    @GetMapping("/candy/showOneCandy/{id}") // add an Id
    public String showOneCandy(Model model,
    		@PathVariable(value="id") Long id) {
    	
    	Candy candy = candyService.findCandy(id);
    	model.addAttribute("candy", candy);

        return "showOneCandy.jsp";
    }

    // ---------------------------------------- CREATE NEW CANDY-----------
    //
    // ========= Create New Candy page ===========
    //
    @GetMapping("/candy/newCandy")
    public String newCandy(
    		@ModelAttribute("candy") Candy candy) {
    	
    	
        return "newCandy.jsp";
    }

    //
    // ========= Create Candy PROCESS ===========
    //
    @PostMapping("/candy/newCandy")
    public String createCandy(
    		@Valid
    		@ModelAttribute("candy") Candy candy,
    		BindingResult result,
    		Model model) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("candy", candy);
    		return "newCandy.jsp";
    	} else {
    		candyService.createCandy(candy);
    		return "redirect:/candy/dashboard";
    	}    	
    }

    // ---------------------------------------- UPDATE CANDY-----------

    //
    // ========= Update HomeController page ===========
    //
    @GetMapping("/candy/updateCandy/{id}") // add an Id
    public String updateCandy(@PathVariable("id") Long id,
    		@ModelAttribute("candy") Candy candy,
    		Model model) {
    	
    	model.addAttribute("candy", candyService.findCandy(id));
    	
        return "updateCandy.jsp";
    }

    //
    // ========= Update Candy PROCESS ===========
    //
    @RequestMapping(value="/candy/updateCandy/{id}", method=RequestMethod.PUT)
    public String updateCandy(
    		@Valid
    		@ModelAttribute("candy") Candy candy,
    		BindingResult result) {
    	
    	if (result.hasErrors()) {
    		return "updateCandy.jsp";
    	} else {
    		
    		candyService.updateCandy(candy);
    		return "redirect:/candy/dashboard";
    	}
    	
    }
    
    

    // ---------------------------------------- DELETE CANDY----------

    //
    // ========= Delete Candy PROCESS ===========
    //
    @GetMapping("/candy/delete/{id}") // add an Id
    public String deleteCandy(@PathVariable("id") Long id) {
    	
    	candyService.deleteCandy(id);

        return "redirect:/candy/dashboard";
    }
    
}
