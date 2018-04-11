package ekin.example.officialdoc;

import ekin.example.officialdoc.model.User;
import ekin.example.officialdoc.model.UserToSignup;
import ekin.example.officialdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController
{

    @Autowired
    UserService userService;


    @RequestMapping("/adduser")
    public User home(User user)
    {
        user = userService.create(user);
        return user;
    }

    @RequestMapping("/users")
    public List<User> findallUsers()
    {
        List<User> user = userService.findAll();
        return user;
    }


    //GET requestler burada işlenicek. Model parametresi User clasını template'e expose eder. User classı form'daki alanlara denk gelen alanlara sahip olmalıdır.
    @GetMapping("/signup")
    public String signupForm(Model model)
    {
        model.addAttribute("userToSignup", new UserToSignup());
        return "index.html";

    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute UserToSignup userToSignup)
    {
        return "signup";
    }


}
