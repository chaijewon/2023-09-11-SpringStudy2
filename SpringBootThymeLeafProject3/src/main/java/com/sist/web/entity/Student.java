package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 *   id int auto_increment,
     name varchar(51) not null,
     sid int,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
  @Id
  private int id;
  private String name;
  private int schoole_id;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="SCHOOL_ID")
  private School school;
  
}
