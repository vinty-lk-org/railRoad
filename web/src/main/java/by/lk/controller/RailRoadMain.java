package by.lk.controller;

import by.lk.entity.SystemUser;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class RailRoadMain {
  private final UserService userService;
  private Long userId;

  @Autowired
  public RailRoadMain(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(path = "/railRoad")
  public String showHelpDesk(Model model, HttpSession httpSession) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String systemUserEmail = user.getUsername();
    model.addAttribute("systemUsername", systemUserEmail);
    SystemUser systemUser = userService.findByEmail(systemUserEmail);
    userId = systemUser.getId();

    httpSession.setAttribute("httpUserId", systemUser.getId());
    httpSession.setAttribute("httpBranch", systemUser.getBranch());
    httpSession.setAttribute("httpSubdivision", systemUser.getSubdivision());
    httpSession.setAttribute("httpEmail", systemUser.getEmail());
    Collection<GrantedAuthority> priveleges = user.getAuthorities();
    if (priveleges.iterator().hasNext()) {
      httpSession.setAttribute("httpUserAuthority", priveleges.iterator().next().getAuthority().toString());
      model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
    }
    return "RailRoadMain";
  }
}
