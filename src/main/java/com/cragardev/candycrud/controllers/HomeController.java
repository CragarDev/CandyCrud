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
import com.cragardev.candycrud.models.Owner;
import com.cragardev.candycrud.services.CandyService;
import com.cragardev.candycrud.services.OwnerService;

@Controller
public class HomeController {
	
	
	// Inject the Service
	private final CandyService candyService;
	private final OwnerService ownerService;
	
	

	 public HomeController(CandyService candyService, OwnerService ownerService) {
		super();
		this.candyService = candyService;
		this.ownerService = ownerService;
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
    // To show all candies and all owners
    //
    @GetMapping("/candy/dashboard")
    public String dashboard(Model model) {
    	
    	// Send all our candies to the JSP using Model model
    	model.addAttribute("candies", candyService.allCandys());
    	
    	// Send all our owners to the JSP using Model model
    	model.addAttribute("owners", ownerService.allOwners());

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
    
    //
    // ========= Show One Owner page ===========
    //
    @GetMapping("/candy/showOneOwner/{id}") // add an Id
    public String showOneOwner(Model model,
    		@PathVariable(value="id") Long id) {
    	
    	Owner owner = ownerService.findOwner(id);
    	model.addAttribute("owner", owner);
    	
    	return "showOneOwner.jsp";
    }

    // ---------------------------------------- CREATE NEW CANDY-----------
    //
    // ========= Create New Candy page ===========
    //
    @GetMapping("/candy/newCandy")
    public String newCandy(
    		@ModelAttribute("candy") Candy candy,
    		Model model) {
    	
    	model.addAttribute("allOwners", ownerService.allOwners());
    	
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
    		model.addAttribute("allOwners", ownerService.allOwners());
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
    	model.addAttribute("allOwners", ownerService.allOwners());
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
    		BindingResult result,
    		Model model) {
    	
    	if (result.hasErrors()) {
    		model.addAttribute("allOwners", ownerService.allOwners());
    		return "updateCandy.jsp";
    	} else {
    		
    		candyService.updateCandy(candy);
    		return "redirect:/candy/dashboard";
    	}
    	
    }
    

    // ---------------------------------------- CREATE NEW OWNER-----------
    //
    // ========= Create New Owner page ===========
    //
    @GetMapping("/candy/newOwner")
    public String newOwner(
    		@ModelAttribute("owner") Owner owner) {
    	
    	
        return "newOwner.jsp";
    }

    //
    // ========= Create Owner PROCESS ===========
    //
    @PostMapping("/candy/newOwner")
    public String newOwnerProcess(
    		@Valid
    		@ModelAttribute("owner") Owner owner,
    		BindingResult result,
    		Model model) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("owner", owner);
    		return "newOwner.jsp";
    	} else {
    		ownerService.createOwner(owner);
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
