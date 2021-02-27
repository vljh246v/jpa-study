package com.demo.jpastudy.ch07;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class GrandChild {

  @EmbeddedId
  private GrandChildId id;


  @MapsId("childId")
  @ManyToOne
  @JoinColumns({
      @JoinColumn(name = "PARENT_ID"),
      @JoinColumn(name = "CHILD_ID")
  })
  private Child child;



  private String name;
}
