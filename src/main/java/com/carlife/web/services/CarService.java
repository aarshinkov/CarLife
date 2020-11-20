package com.carlife.web.services;

import com.carlife.web.dto.*;
import java.util.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
public interface CarService
{
  List<CarDto> getCarsByUserId(Long userId);
  
  CarDto getCarByCarId(Long carId) throws Exception;
}
