package banky.example.banky.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityControlleur {
    @RequestMapping(value ="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value ="/logout")
    public String home(){
        return "redirect:/operations";
    }

    @RequestMapping(value ="/403")
    public String accessDenied(){
        return "403";
    }
}
