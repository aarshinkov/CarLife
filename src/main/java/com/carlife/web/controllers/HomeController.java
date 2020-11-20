package com.carlife.web.controllers;

import com.carlife.web.base.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Controller
public class HomeController extends Base
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @GetMapping(value =
  {
    "/", "/home", "/index"
  })
  public String home()
  {
    return "redirect:/dashboard";
  }
}
