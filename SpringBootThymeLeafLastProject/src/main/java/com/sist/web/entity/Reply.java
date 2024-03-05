package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reply {
  @Id
  private int no;
  private int fno;
  private String id;
  private String name;
  private String msg;
  private String regdate;
}
