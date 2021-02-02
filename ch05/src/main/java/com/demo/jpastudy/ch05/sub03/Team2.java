package com.demo.jpastudy.ch05.sub03;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team2 {

  @Id
  @Column(name = "TEAM_ID")
  private String id;

  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member2> members = new ArrayList<>();


  public Team2(String id, String name){
    this.id = id;
    this.name = name;

  }

  public Team2(){ }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Member2> getMembers() {
    return members;
  }
}
