package com.carlife.web.controllers;

import com.carlife.web.base.*;
import com.carlife.web.dto.*;
import com.carlife.web.services.*;
import java.util.logging.*;
import org.slf4j.*;
import org.slf4j.Logger;
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
public class CarsController extends Base
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private CarService carService;

  @GetMapping(value = "/car")
  public String viewCar(@RequestParam(name = "id", required = true) Long carId, Model model)
  {
    try
    {
      CarDto car = carService.getCarByCarId(carId);

      model.addAttribute("car", car);
      return "cars/car";
    }
    catch (Exception ex)
    {
      log.error("Error getting car!", ex);
      return "redirect:/dashboard";
    }
  }
}
