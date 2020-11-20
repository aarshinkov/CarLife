package com.carlife.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
public class ServletInitializer extends SpringBootServletInitializer
{
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
  {
    return application.sources(CarLifeApplication.class);
  }
}
