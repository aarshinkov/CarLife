package com.carlife.web.security;

import com.carlife.web.entities.*;
import com.carlife.web.services.*;
import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException
  {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserEntity storedUser = (UserEntity) userService.loadUserByUsername(username);

    List<GrantedAuthority> roles = new ArrayList<>();

    for (RoleEntity role : storedUser.getRoles())
    {
      roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
    }

    if (username != null)
    {
      return new UsernamePasswordAuthenticationToken(username, password, roles);
    }

    return null;
  }

  @Override
  public boolean supports(Class<?> authentication)
  {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
