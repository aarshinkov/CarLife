package com.carlife.web.config;

import java.util.*;
import nz.net.ultraq.thymeleaf.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.dialect.*;
import org.thymeleaf.extras.springsecurity5.dialect.*;
import org.thymeleaf.spring5.*;
import org.thymeleaf.spring5.templateresolver.*;
import org.thymeleaf.spring5.view.*;
import org.thymeleaf.templateresolver.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Configuration
public class MvcViewConfig implements WebMvcConfigurer
{
  @Bean
  public SpringResourceTemplateResolver srtr()
  {
    SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
    srtr.setPrefix("/WEB-INF/views/");
    srtr.setSuffix(".html");
    srtr.setTemplateMode("HTML");
    srtr.setCharacterEncoding("UTF-8");
    srtr.setCacheable(false);
    srtr.setOrder(1);

    return srtr;
  }

  @Bean
  public LayoutDialect layoutDialect()
  {
    LayoutDialect layoutDialect = new LayoutDialect();
    return layoutDialect;
  }

  @Bean
  public SpringSecurityDialect ssd()
  {
    SpringSecurityDialect ssd = new SpringSecurityDialect();
    return ssd;
  }

  @Bean
  public Set<ITemplateResolver> templateResolvers()
  {
    Set<ITemplateResolver> templateResolvers = new HashSet<>();
    templateResolvers.add(srtr());

    return templateResolvers;
  }

  @Bean
  public Set<IDialect> additionalDialects()
  {
    Set<IDialect> additionalDialects = new HashSet<>();
    additionalDialects.add(layoutDialect());
    additionalDialects.add(ssd());

    return additionalDialects;
  }

  @Bean
  public SpringTemplateEngine templateEngine()
  {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolvers(templateResolvers());
    templateEngine.setAdditionalDialects(additionalDialects());

    return templateEngine;
  }

  @Bean
  public ThymeleafViewResolver viewResolver()
  {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("UTF-8");

    return viewResolver;
  }
}