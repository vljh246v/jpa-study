package com.demo.jpastudy.ch05.training;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

  @Id @Column(name = "MEMBER_ID")
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private String name;

  private String city;
  private String street;
  private String zipcode;

  @OneToMany(mappedBy="member")
  private List<Order> orders = new ArrayList<>();
}
