package com.demo.jpastudy.ch07;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

  @Id @GeneratedValue
  private Long id;

  private String name;
}
