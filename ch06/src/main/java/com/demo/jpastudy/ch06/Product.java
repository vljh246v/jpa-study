package com.demo.jpastudy.ch06;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUCT_ID")
  private Long id;

  private String name;
}
