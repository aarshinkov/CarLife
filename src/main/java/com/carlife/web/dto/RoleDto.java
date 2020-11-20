package com.carlife.web.dto;

import java.io.*;
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
public class RoleDto implements Serializable
{
  private String rolename;
}
