package com.demo.jpastudy.ch07;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ParentId implements Serializable {

  private String id1;
  private String id2;
}
