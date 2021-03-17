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
@DiscriminatorValue("M")
public class Movie extends Item{

  private String director; // 감독
  private String actor; // 배우
}
