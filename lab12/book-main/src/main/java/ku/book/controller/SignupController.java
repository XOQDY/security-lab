package ku.book.controller;

import ku.book.dto.SignupDto;
import ku.book.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    @GetMapping("/signup")
    public String getSignupPage(SignupDto user) {
        return "signup"; // return signup.html
    }

    @PostMapping("/signup")
    public String signupUser(@Valid SignupDto user, BindingResult result,
                             Model model) {
        if (result.hasErrors())
            return "signup";

        signupService.createUser(user);

        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }
}
