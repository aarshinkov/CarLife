package com.carlife.web.services;

import com.carlife.web.collections.*;
import com.carlife.web.dto.*;
import com.carlife.web.enums.*;
import com.carlife.web.models.users.*;
import org.springframework.security.core.userdetails.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
public interface UserService extends UserDetailsService
{
  UserDto getUserByUserId(Long userId);

  ObjCollection<UserDto> getUsers(Integer page, Integer limit);

  UserDto createUser(UserCreateModel ucm, Roles... role) throws Exception;

  UserDto updateUser(UserEditModel uem);

  UserDto deleteUser(Long userId) throws Exception;

  UserDto changePassword(UserChangePasswordModel ucpm);

  boolean isPasswordMatch(Long userId, String password);
}
