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
public interface UsersRepository extends JpaRepository<UserEntity, Long>
{
  UserEntity findByUserId(Long userId);

  UserEntity findByEmail(String email);
}
