package com.demo.jpastudy.ch07;

import java.io.Serializable;
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
public class ChildId implements Serializable {

  private String parent;
  private String childId;

}
