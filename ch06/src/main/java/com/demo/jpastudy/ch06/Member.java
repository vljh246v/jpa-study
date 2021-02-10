package com.demo.jpastudy.ch06;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String username;

  public Member(Long id, String username){
    this.id = id;
    this.username = username;
  }

  public Member(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
