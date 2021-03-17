package com.demo.jpastudy.ch07;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Embeddable
public class GrandChildId implements Serializable {

  private ChildId childId;

  @Column(name = "GRANDCHILD_ID")
  private String id;
}
