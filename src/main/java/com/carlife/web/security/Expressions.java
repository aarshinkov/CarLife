package com.carlife.web.security;

import com.carlife.web.services.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Service
public class Expressions
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private SystemService systemService;

  public boolean isUserOwner(Long storyId, HttpServletRequest request)
  {
    Long userId = (Long) systemService.getSessionAttribute(request, "userId");

    return true;

//    return owner.getUserId().equals(userId);
  }
}
