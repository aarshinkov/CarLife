package com.carlife.web.repositories;

import com.carlife.web.entities.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Repository
public interface CarsRepository extends JpaRepository<CarEntity, Long>
{
  List<CarEntity> findByUserUserId(Long userId);

  List<CarEntity> findByUserUserIdOrderByAddedOnDesc(Long userId);

  CarEntity findByCarId(Long carId);
}
