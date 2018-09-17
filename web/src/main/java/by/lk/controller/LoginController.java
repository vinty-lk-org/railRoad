package by.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by SystemUser on 29.06.2017.
 */
@Controller
public class LoginController {

  @GetMapping({"/", "/login"})
  public String showLoginPage() {
    return "login";
  }

}
