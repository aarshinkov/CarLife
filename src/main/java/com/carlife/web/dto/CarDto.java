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
public class CarDto implements Serializable
{
  private Long carId;
  private String name;
  private Integer yearMade;
  private UserDto user;
  private Timestamp addedOn;
  private Timestamp editedOn;
}
