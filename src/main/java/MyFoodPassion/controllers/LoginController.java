package MyFoodPassion.controllers;

import MyFoodPassion.forms.LoginForm;
import MyFoodPassion.models.User;

import MyFoodPassion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyservice;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyservice.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        if (!userService.authenticate(
                LoginForm.getUserName(),  LoginForm.getPassword())) {
            notifyservice.addErrorMessage("Invalid login!");
            return "users/login";
        }

        notifyservice.addInfoMessage("Login successful");
        return "redirect:/";
    }

}



/**@RequestMapping("/users/login")
public String login(LoginForm loginForm){
    // User doesn't need to re-enter credentials
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if ( (auth instanceof AnonymousAuthenticationToken) ) {
        return "users/login";
    } else {
        return "redirect:/";
    }

}**/

    /**
     * Display user's registration form
     * @return
     */
  /**  @RequestMapping("/users/register")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject(user);
        modelAndView.setViewName("users/register");
        return modelAndView;
    }
    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public ModelAndView registration(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = this.userService.findByUserName(user.getUserName());
        modelAndView.setViewName("users/register");
        if( userExists != null ){
            bindingResult.rejectValue("userName", "error.user", "User exists");
        }
        if( !bindingResult.hasErrors() ){
            this.userService.create(user);
            modelAndView.addObject("successMessage", "User has been created");
            modelAndView.addObject("user", new User());
        }
        return modelAndView;}**/

