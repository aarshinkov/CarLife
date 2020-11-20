package com.carlife.web.enums;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
public enum Roles
{
  ADMIN("ADMIN"),
  USER("USER");

  private final String value;

  private Roles(String value)
  {
    this.value = value;
  }

  public String getValue()
  {
    return value;
  }
}
