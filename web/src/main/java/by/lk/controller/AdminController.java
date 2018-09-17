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
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;

/**
 * Created by SystemUser on 29.06.2017.
 */
@Controller
public class AdminController {
  private final UserService userService;

  @Autowired
  public AdminController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute("systemUsers")
  public SystemUser systemUser() {
    return new SystemUser();
  }

  @GetMapping(path = "/Admin")
  public String showHelpDesk(Model model) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String systemUserEmail = user.getUsername();
    Collection<GrantedAuthority> priveleges = user.getAuthorities();
    if (priveleges.iterator().hasNext()) {
      model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
    }
    model.addAttribute("systemUsername", systemUserEmail);
    return "Admin";
  }

//    @PostMapping(path = "/HelpDesk")
//    public String taskDto(TaskDto taskDtoFromView, Model model, HttpSession httpSession) {
//        taskDtoFromView.setTypeOfJobId(1L);
//        taskDtoFromView.setSystemUser((Long) httpSession.getAttribute("httpUserId"));
//        taskService.saveTask(taskDtoFromView);
//        model.addAttribute("systemUsername", httpSession.getAttribute("httpEmail"));
//        model.addAttribute("userAuthority", httpSession.getAttribute("httpUserAuthority"));
//        return "HelpDesk";
//    }

}
