package com.demo.jpastudy.ch06;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MEMBER_ID")
  private Long id;

  private String username;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();


}
