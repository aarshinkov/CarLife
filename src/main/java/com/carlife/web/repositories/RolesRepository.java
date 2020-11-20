package com.carlife.web.repositories;

import com.carlife.web.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, String>
{
  RoleEntity findByRolename(String rolename);
}
