package com.demo.jpastudy.ch05.sub01;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Member {

  @Id
  @Column(name = "MEMBER_ID")
  private String id;
  private String username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  public Member(String id, String username){
    this.id = id;
    this.username = username;
  }

  public Member(){}

  public void setTeam(Team team) {
    this.team = team;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Team getTeam() {
    return team;
  }
}
