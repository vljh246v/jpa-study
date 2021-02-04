package com.demo.jpastudy.ch05.sub03;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="MEMBER")
public class Member2 {

  @Id
  @Column(name = "MEMBER_ID")
  private String id;
  private String username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team2 team;

  public Member2(String id, String username){
    this.id = id;
    this.username = username;
  }

  public Member2(){}

  public void setTeam(Team2 team) {
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

  public Team2 getTeam() {
    return team;
  }
}
