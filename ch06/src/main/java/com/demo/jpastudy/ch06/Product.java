package com.demo.jpastudy.ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

  @Id @GeneratedValue
  @Column(name = "PRODUCT_ID")
  private Long id;

  private String name;
}
