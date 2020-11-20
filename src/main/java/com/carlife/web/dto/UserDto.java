package com.carlife.web.dto;

import java.io.*;
import java.sql.*;
import java.util.*;
import lombok.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto implements Serializable
{
  private Long userId;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Timestamp createdOn;
  private Timestamp editedOn;
  private List<RoleDto> roles;

  public String getFullName()
  {
    return lastName != null ? firstName + ' ' + lastName : firstName;
  }
}
