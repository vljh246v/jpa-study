package com.demo.jpastudy.ch04;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {

    // 엔티티 매니저 팩토리 생성
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    // 엔티티 매니저 생성
    EntityManager em = emf.createEntityManager();

    // 트랜잭션 획득
    EntityTransaction tx = em.getTransaction();

    try{
      tx.begin();
      logic(em);
      tx.commit();
    } catch (Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

  private static void logic(EntityManager em){

    Member member = new Member();
    member.setId(id);
    member.setUsername("demo");
    member.setAge(30);

    // 등록
    em.persist(member);

    // 수정
    member.setAge(31);

    // 한건 조회
    Member findMember = em.find(Member.class, id);
    System.out.println("findMember=" + findMember.getUsername()
        + ", age=" + findMember.getAge());

    // 목록 조회
    List<Member> members =
        em.createQuery("select m from Member m", Member.class)
        .getResultList();
    System.out.println("member.size=" + members.size());

    // 삭제
    em.remove(findMember);
  }
}
