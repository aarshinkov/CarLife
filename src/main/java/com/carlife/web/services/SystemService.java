package com.carlife.web.services;

import com.carlife.web.dto.*;
import javax.servlet.http.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
public interface SystemService
{
  Object getSessionAttribute(HttpServletRequest request, String attributeName);

  void changeLoggerUserInfo(HttpServletRequest request, UserDto user);
}
