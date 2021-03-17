package com.demo.jpastudy.ch07;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor // lombok 사용
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Embeddable
public class ChildId implements Serializable {

  private String parentId;

  @Column(name = "CHILD_ID")
  private String childId;
}
