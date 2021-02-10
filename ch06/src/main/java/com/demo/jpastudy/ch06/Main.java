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

      saveMember(em);

      tx.commit();

    } catch (Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

  private static void saveMember(EntityManager em) {
    Member member1 = new Member("member1");
    Member member2 = new Member("member2");

    Team team1 = new Team("team1");
    team1.getMembers().add(member1);
    team1.getMembers().add(member2);

    em.persist(member1); // INSERT-member1
    em.persist(member2); // INSERT-member2
    em.persist(team1); // INSERT-team1, UPDATE-member1.fk, UPDATE-member2.fk
  }


}
