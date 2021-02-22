package com.demo.jpastudy.ch06;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

  @Id @Column(name = "PRODUCT_ID")
  private Long id;

  @ManyToMany(mappedBy = "products")
  private List<Member> memberList;

  private String name;
}
