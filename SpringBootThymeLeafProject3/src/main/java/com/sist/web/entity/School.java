package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 *  id 
 *  name
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class School {
   @Id
   private int id;
   private String name;
}
