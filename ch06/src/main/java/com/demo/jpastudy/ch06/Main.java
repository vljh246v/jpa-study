package com.demo.jpastudy.ch06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
    // 엔티티 매니저 팩토리 생성
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    // 엔티티 매니저 생성
    EntityManager em = emf.createEntityManager();

    // 트랜잭션 획득
    EntityTransaction tx = em.getTransaction();

    try{
      tx.begin();

      save(em);


      tx.commit();

    } catch (Exception e){
      System.out.println("=====================================");
      System.out.println(e.getMessage());
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

  private static void save(EntityManager em) {


    Member member1 = new Member();
    member1.setId(1L);
    member1.setUsername("회원1");
    em.persist(member1);


    Product productA = new Product();
    productA.setId(1L);
    productA.setName("상품 A");
    em.persist(productA);

    MemberProduct memberProduct = new MemberProduct();
    memberProduct.setMember(member1);
    memberProduct.setProduct(productA);
    memberProduct.setOrderAmount(2);
    em.persist(memberProduct);
  }
}
