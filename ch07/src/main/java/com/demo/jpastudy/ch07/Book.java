package com.demo.jpastudy.ch07;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("B")
public class Book extends Item{

  private String author; // 작가
  private String isbn; // ISBN
}
