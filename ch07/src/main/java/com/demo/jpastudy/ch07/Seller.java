package com.demo.jpastudy.ch07;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seller extends BaseEntity{

  private String shopName;
}
