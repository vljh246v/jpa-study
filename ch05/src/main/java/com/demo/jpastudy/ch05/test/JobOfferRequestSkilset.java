package com.demo.jpastudy.ch05.test;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jb_job_offer_request_skilset")
public class JobOfferRequestSkilset {

  @Id
  private Long id;

  @ManyToOne
  private JobOfferRegisterRequest request;

  private String code;
}
