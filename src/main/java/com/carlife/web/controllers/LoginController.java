package com.carlife.web.controllers;

import com.carlife.web.base.*;
import com.carlife.web.dto.*;
import com.carlife.web.enums.*;
import com.carlife.web.models.users.*;
import com.carlife.web.services.*;
import javax.validation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Controller
public class LoginController extends Base
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService userService;

  @GetMapping(value = "/login")
  public String prepareLogin(Model model)
  {
    model.addAttribute("globalMenu", "login");

    return "auth/login";
  }

  @GetMapping(value = "/signup")
  public String prepareSignup(Model model)
  {
    UserCreateModel ucm = new UserCreateModel();

    model.addAttribute("ucm", ucm);
    model.addAttribute("globalMenu", "signup");

    return "auth/signup";
  }

  @PostMapping(value = "/signup")
  public String signup(@ModelAttribute("ucm") @Valid UserCreateModel ucm,
          BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
  {
    if (!ucm.getPassword().equals(ucm.getConfirmPassword()))
    {
      bindingResult.rejectValue("password", "errors.password.nomatch");
      bindingResult.rejectValue("confirmPassword", "errors.password.nomatch");
    }

    if (bindingResult.hasErrors())
    {
      model.addAttribute("globalMenu", "signup");
      return "auth/signup";
    }

    try
    {
      UserDto createdUser = userService.createUser(ucm, Roles.USER);
      redirectAttributes.addFlashAttribute("msgSuccess", getMessage("signup.success", createdUser.getFullName()));
    }
    catch (Exception e)
    {
      redirectAttributes.addFlashAttribute("msgError", getMessage("signup.error"));
    }

    return "redirect:/login";
  }
}
