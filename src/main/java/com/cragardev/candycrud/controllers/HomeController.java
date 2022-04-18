package com.cragardev.candycrud.controllers;



import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cragardev.candycrud.models.Candy;
import com.cragardev.candycrud.models.LoginUser;
import com.cragardev.candycrud.models.Owner;
import com.cragardev.candycrud.models.User;
import com.cragardev.candycrud.services.CandyService;
import com.cragardev.candycrud.services.OwnerService;
import com.cragardev.candycrud.services.UserService;

@Controller
public class HomeController {
	
	
	// Inject the Service
	private final CandyService candyService;
	private final OwnerService ownerService;
	private final UserService userService;
	
	
	

	 public HomeController(CandyService candyService, OwnerService ownerService, UserService userService) {
		super();
		this.candyService = candyService;
		this.ownerService = ownerService;
		this.userService = userService;
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

    
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  LOGIN REGISTRATION  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
    @GetMapping("/candy/login")
    public String login(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/candy/login")
    public String loginProcess(
    		@Valid 
    		@ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	User user = userService.login(newLogin, result);
    	
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());

        
    
        return "redirect:/candy/dashboard";
    }
    
    @PostMapping("/candy/register")
    public String registerProcess(
    		@Valid 
    		@ModelAttribute("newUser") User newUser, 
    		BindingResult result, 
    		Model model, 
    		HttpSession session) {
    	
    	// TO-DO Later -- call a register method in the service 
    	// to do some extra validations and create a new user!
    	userService.register(newUser, result);
    	
    	
    	if(result.hasErrors()) {
    		// Be sure to send in the empty LoginUser before 
    		// re-rendering the page.
    		model.addAttribute("newLogin", new LoginUser());
    		return "login.jsp";
    	}
    	
    	// No errors! 
    	// TO-DO Later: Store their ID from the DB in session, 
    	// in other words, log them in.
    	
    	session.setAttribute("user_id", newUser.getId());
    	
    	return "redirect:/candy/dashboard";
    }
    
    // Log out user
    @GetMapping("/candy/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/candy/login";
    	
    }
    
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //
    // ========= Candy Dashboard page ===========
    // To show all candies and all owners
    //
    @GetMapping("/candy/dashboard")
    public String dashboard(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
			
    	// Get users info to show them logged in
    	Long userId = (Long) session.getAttribute("user_id");
    	model.addAttribute("user", userService.findUser(userId));
    	
    	
    	
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
    		@PathVariable(value="id") Long id, HttpSession session) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
    	
    	Candy candy = candyService.findCandy(id);
    	model.addAttribute("candy", candy);

        return "showOneCandy.jsp";
    }
    
    //
    // ========= Show One Owner page ===========
    //
    @GetMapping("/candy/showOneOwner/{id}") // add an Id
    public String showOneOwner(Model model,
    		@PathVariable(value="id") Long id, HttpSession session) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
    	
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
    		Model model, 
    		HttpSession session) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
    	
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
    // ========= Update Candy page ===========
    //
    @GetMapping("/candy/updateCandy/{id}") // add an Id
    public String updateCandy(@PathVariable("id") Long id,
    		@ModelAttribute("candy") Candy candy,
    		Model model, HttpSession session) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
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
    		@ModelAttribute("owner") Owner owner,
    		HttpSession session) {
    	
    	// check to see if user is logged in
    	
    	if (session.getAttribute("user_id") == null) {
			// if not in session, redirect to login
    		return "redirect:/createError";
			}
    	
    	
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
    
    //
    //================== ERRORS ==========================
    //
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Please log in or Register!");
        return "redirect:/candy/login";
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
