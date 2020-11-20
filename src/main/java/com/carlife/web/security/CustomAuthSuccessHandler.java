package com.carlife.web.security;

import com.carlife.web.domain.*;
import com.carlife.web.entities.*;
import com.carlife.web.repositories.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.savedrequest.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Component
public class CustomAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  private final RequestCache requestCache = new HttpSessionRequestCache();

  @Autowired
  private MessageSource messageSource;

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException
  {
    log.debug("Authentication successful");

    HttpSession session = request.getSession();

    String email = authentication.getName();

    UserEntity user = usersRepository.findByEmail(email);

    NameDomain names = NameDomain.builder().firstName(user.getFirstName()).lastName(user.getLastName()).build();

    session.setAttribute("user", names);
    session.setAttribute("userId", user.getUserId());
    session.setAttribute("email", email);

    SavedRequest savedRequest = requestCache.getRequest(request, response);

    if (savedRequest == null)
    {
      super.onAuthenticationSuccess(request, response, authentication);

      return;
    }

    String targetUrlParameter = getTargetUrlParameter();
    if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter))))
    {
      requestCache.removeRequest(request, response);
      super.onAuthenticationSuccess(request, response, authentication);

      return;
    }

    clearAuthenticationAttributes(request);

    // Use the DefaultSavedRequest URL
    String targetUrl = savedRequest.getRedirectUrl();
    logger.debug("Redirecting to url: " + targetUrl);
    getRedirectStrategy().sendRedirect(request, response, targetUrl);
  }
}
