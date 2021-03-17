package com.demo.jpastudy.ch05.test;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jb_job_offer_register_request")
public class JobOfferRegisterRequest {

  @Id
  private Long id;

  @OneToMany(mappedBy = "request")
  private List<JobOfferRequestSkilset> requestSkilset;

}
