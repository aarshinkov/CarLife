package com.carlife.web.entities;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cars")
@DynamicInsert
@DynamicUpdate
public class CarEntity implements Serializable
{
  @Id
  @SequenceGenerator(name = "seq_gen_car", sequenceName = "s_cars", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_car")
  @Column(name = "car_id")
  private Long carId;

  @Column(name = "name")
  private String name;

  @Column(name = "year_made")
  private Integer yearMade;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private UserEntity user;

  @Column(name = "added_on")
  private Timestamp addedOn;

  @Column(name = "edited_on")
  private Timestamp editedOn;
}
