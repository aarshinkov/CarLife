package com.carlife.web;

import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@SpringBootApplication
public class CarLifeApplication
{
  public static void main(String[] args)
  {
    SpringApplication.run(CarLifeApplication.class, args);
  }

  @Bean
  public PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder(12);
  }

  @Bean
  public ModelMapper mapper()
  {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);

    return mapper;
  }
}
