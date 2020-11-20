package com.carlife.web.security;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException
  {
    log.debug("Authentication failed: " + ex.getMessage());

    super.onAuthenticationFailure(request, response, ex);
  }
}
