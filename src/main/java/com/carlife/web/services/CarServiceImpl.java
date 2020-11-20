package com.carlife.web.services;

import com.carlife.web.dto.*;
import com.carlife.web.entities.*;
import com.carlife.web.repositories.*;
import java.util.*;
import org.modelmapper.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * @since 1.0.0
 * @author Atanas Yordanov Arshinkov
 */
@Service
public class CarServiceImpl implements CarService
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private CarsRepository carsRepository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public List<CarDto> getCarsByUserId(Long userId)
  {
    List<CarEntity> cars = carsRepository.findByUserUserIdOrderByAddedOnDesc(userId);

    List<CarDto> result = new ArrayList<>();

    for (CarEntity car : cars)
    {
      CarDto carDto = new CarDto();

      carDto.setCarId(car.getCarId());
      carDto.setName(car.getName());
      carDto.setYearMade(car.getYearMade());
      carDto.setAddedOn(car.getAddedOn());
      carDto.setEditedOn(car.getEditedOn());

      result.add(carDto);
    }

    return result;
  }

  @Override
  public CarDto getCarByCarId(Long carId) throws Exception
  {
    CarEntity storedCar = carsRepository.findByCarId(carId);
    if (storedCar == null)
    {
      throw new Exception("Car with ID: " + carId + " not found!");
    }

    CarDto car = new CarDto();

    car.setCarId(storedCar.getCarId());
    car.setName(storedCar.getName());
    car.setYearMade(storedCar.getYearMade());
    car.setAddedOn(storedCar.getAddedOn());
    car.setEditedOn(storedCar.getEditedOn());

    return car;
  }
}
