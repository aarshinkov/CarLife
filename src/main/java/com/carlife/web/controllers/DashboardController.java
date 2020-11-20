package com.carlife.web.controllers;

import com.carlife.web.base.*;
import com.carlife.web.dto.*;
import com.carlife.web.services.*;
import java.util.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Controller
public class DashboardController extends Base
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private CarService carService;

  @Autowired
  private SystemService systemService;

  @GetMapping(value = "/dashboard")
  public String dashboard(HttpServletRequest request, Model model)
  {
    Long userId = (Long) systemService.getSessionAttribute(request, "userId");

    List<CarDto> cars = carService.getCarsByUserId(userId);

    model.addAttribute("cars", cars);

    model.addAttribute("globalMenu", "dashboard");

    return "profile/dashboard";
  }
}
