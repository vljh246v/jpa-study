package com.demo.jpastudy.ch07;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Child {

  @EmbeddedId
  private ChildId id;

  @MapsId("parentId")
  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Parent parent;



  private String name;
}

