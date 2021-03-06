# **3. 영속성 관리**

-   JPA가 제공하는 기능은 크게 두가지가 있음
    1. 엔티티와 테이블을 매핑하는 설계 부분
    2. 매핑한 엔티티를 실제로 사용하는 부분
-   엔티티 매니저는 엔티티를 저장 / 수정 / 삭제 / 조회 하는 등 엔티티와 관련된 일을 한다.
-   엔티티 매니저는 엔티티를 저장하는 가상의 데이터베이스로 생각하면 된다.

## **3.1 엔티티 매니저 팩토리와 엔티티 매니저**

-   데이터베이스를 하나만 사용하는 애플리케이션은 일반적으로 EntityManagerFactory 를 하나만 생성하고, 엔티티 매니저 팩토리에서 엔티티 매니저를 생성하여 사용한다.
-   엔티티 매니저 팩토리를 생성하는 비용은 상당히 크고 팩토리에서 엔티티 매니저를 생성하는 비용은 적다.
-   엔티티 매니저 팩토리는 여러 스레드가 동시에 접근해도 안전하므로 서로 다른 스레드간 공유 가능
-   엔티티 매니저는 동시성 문제가 발생하므로 스레드간 절대 공유 하면 안된다.
-   엔티티 매니저는 데이터베이스 연결이 꼭 필요한 시점까지 커넥션을 얻지 않고 보통 트랜잭션을 시작할 때 커넥션을 획득한다.
-   JPA 구현체들은 EntityMangerFactory 를 생성할때 커넥션풀도 만드는데, JEE 환경(스프링 프레임워크 포함)에서 사용하면 해당 컨테이너가 제공하는 데이터소스를 사용한다.

## **3.2 영속성 컨텍스트란?**

-   영속성 컨텍스트는 우리말로 해석하면 '엔티티를 영구 저장하는 환경' 이라는 뜻이다.
-   엔티티 매니저를 통해 엔티티를 사용하면 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관하고 관리한다.
-   persist 메소드는 단순히 엔티티를 저장한다고 표현하기 보다는, **'엔티티 매니저를 사용해서 회원 엔티티를 영속성 컨텍스트에 저장 한다'** 가 더 정확한 말이다.
-   영속성 컨텍스트는 논리적 개념에 가깝다.
-   영속성 컨텍스트는 엔티티 매니저를 생성할 때 하나 만들어진다. 그리고 그 엔티티 매니저는 영속성 컨택스트에 접근할 수 있고, 영속성 컨텍스트를 관리할 수 있다.

## **3.3 엔티티의 생명 주기**

![생명주기](https://lh3.googleusercontent.com/iXRwZ_0Drs_I7kHbiz2gkPkvycIs8diRT-HPW0S-SvxzU1Z-skl7SaIqqrRgYsmSn5xZ8hzD19MwLye44PvR-XHicn3b4fIg7jD1euTl8JJOP_Jv0u-8KR8PLwxKCbEEPQ5zcwslkYJ0cQWYKzgdKtBtdB9YWz3Vfk_yQjafh9krS_zvJoeEVHP9IlL-KlkRhLuTZ9gsyyX6NRMlyLP-U46viOpx8WOP5fS0dunLCoY-ATMnm_IowSk3EXISlwiye3_bnTcBVUDFRa2bVuFyi_k5wv0zqi6Rc2H_EkhDW1X2Smx392lsC5ZHOVIzg8VGKIl0ZTI8wgnW1_313JvqMe-3T97FXaZsGGcntB8R103hr9YROCPywejpdZL3rWeeXr0p860is0MwV2JPXYQP5SPBSv7tVkkaN51NhCx6Lonm9KEzZ3U9PJcpFLfsHOb2WDOxmYoB-75h0jKmS_ugrw_oNI8kLxw40kK8KA18SjZCPr5lNMznS2JxQR5PMJZIFbiYUvQq5_9o01qHM5dVUsBbuGfBDHmMfwgPabGOgDRY-8YcjUrGzE0VUwa-lgyILGbgL5JSV7ZiupaHFA4514sA7sFCQUQxIUObRBF2MxL88v-oS92wbXhJeBBKwG8GPBwTZ0bxVB-e7Qgkeb0GjMdOZ-Z7w19XEtX5JW2RB0UVVF-Y2wADfVhkuXStgqs=w779-h630-no?authuser=0)

-   엔티티에는 4가지 상태가 존재한다.
    1. 비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태
    2. 영속(managed) : 영속성 컨텍스트에 저장된 상태
    3. 준영속(detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태
    4. 삭제(removed) : 삭제된 상태

**비영속**

-   엔티티 객체를 생성하였고, 순수한 객체 상태이다.
-   영속성 컨텍스트나 데이터베이스와는 전혀 관련이 없다.
    ```java
    // 객체를 생성한 상태
    Member member = new Member();
    member.setId("membeer1");
    member.setUsername("demo");
    ```

**영속**

-   영속성 컨텍스트가 관리하는 엔티티를 영속 상태라고 한다.
-   영속성 컨텍스트에 의해 관리된다는 뜻
-   em.find()나 JPQL을 사용한 조회 / 엔티티 매니저를 통한 저장 했을때 영속 상태가 된다.
    ```java
    em.persist(member);
    ```

**준영속**

-   영속 상태의 엔티티를 영속성 컨텍스트가 관리하지 않으면 준 영속 상태가 된다.
-   준영속 상태로 만드려면 em.detach() 메서드를 호출한다.
-   em.close() 를 호출해 영속성 컨텍스트를 닫거나, em.clear()를 호출해서 영속성 컨텍스트를 초기화해도 준영속 상태가 된다.
    ```java
    em.detach(member);
    ```

**삭제**

-   엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제한다.
    ```java
    em.remove(member);
    ```

## **3.4 영속성 컨텍스트의 특징**

**영속성 컨텍스트와 식별자 값**

-   영속성 컨텍스트는 엔티티를 식별자 값(@Id로 테이블의 기본 키와 매핑한 값)으로 구분한다. 따라서 영속 상태는 식별자 값이 반드시 있어야 한다.
-   엔티티가 저장되는 시점은 트랜잭션을 커밋하는 순간 영속성 컨텍스트에서 새로 저장된 엔티티를 데이터베이스에 반영 하는데 이것을 플러시(flush) 라고 한다.
-   영속성 컨텍스트가 엔티티를 관리할때 장점
    -   1차 캐시
    -   동일성 보장
    -   트랜잭션을 지원하는 쓰기 지연
    -   변경 감지
    -   지연 로딩

### **3.4.1 엔티티 조회**

-   영속성 컨텍스트 내부에는 1차 캐시를 가지고 있고, 영속 상태의 엔티티는 모두 이곳에 저장된다.

-   아래 코드를 실행하면 1차 캐시에 회원 엔티티를 저장하고 아직 데이터베이스에는 저장하지 않는다.

    ```java
    // 객체를 생성한 상태 (비영속)
    Member member = new Member();
    member.setId("membeer1");
    member.setUsername("demo");

    // 엔티티를 영속
    em.persist(member);
    ```

-   1차 캐시의 키는 식별자 값이고, 이 식별자 값은 데이터베이스 기본 키와 매핑되어 있다.
-   따라서 영속성 컨텍스트에 데이터를 저장하고 조회하는 모든 기준은 데이터베이스 기본 키 값이다.
-   em.find()를 호출하면 먼저 1차 캐시에서 엔티티를 찾고 만약 엔티티가 1차 캐시에 없으면 데이터베이스에서 조회한다.

**1차 캐시에서 조회**

-   em.find() 를 호출하면 우선 1차 캐시에서 식별자 값으로 엔티티를 찾고, 엔티티가 있다면 데이터베이스에서 조회하지 않고 메모리에있는 1차 캐시에서 엔티티를 조회한다.

**데이터베이스에서 조회**

-   엔티티가 1차 캐시에 없으면 엔티티 매니저는 데이터베이스를 조회해서 엔티티를 생성한다.
-   그리고 1차 캐시에 저장한 후에 영속 상태의 엔티티를 반환한다.

**영속 엔티티의 동일성 보장**

-   영속성 컨텍스트는 em.find() 를 반복해서 호출한다고 해도 1차 캐시에 있는 엔티티 인스턴스를 반환하기 때문에 영속성 컨텍스트는 **성능상 이점과 엔티티의 동일성**을 보장한다.

### **3.4.2 엔티티 등록**

-   엔티티 매니저는 트랜잭션을 커밋하기 직전까지 데이터베이스에 엔티티를 저장하지 않고 내부 쿼리 저장소에 INSERT SQL을 모아둔다.
-   트랜잭션을 커밋할때 모아둔 쿼리를 데이터베이스에 보낸다. 이것을 **트랜잭션을 지원하는 쓰기 지연(transactional write-behind)** 이라고 한다.
-   트랜잭션을 커밋하면 엔티티 매니저는 우선 영속성 컨텍스트를 플러시 한다.
-   이때 쓰기 지연 SQL 저장소에 모인 쿼리를 데이터베이스에 보낸다.
-   이렇게 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화한 후에 실제 데이터베이스 트랜잭션 커밋을 한다.

### **3.4.3 엔티티 수정**

**SQL 수정 쿼리의 문제점**

-   수정이 일어날 때 마다 다른 컬럼에 영향을 주지 않기 위해 대상 컬럼만 변경한 SQL을 작성하는 일이 많다.
-   이런 개발 방식의 문제점은 수정 쿼리가 많아지고, 비즈니스 로직 분석을 위해서는 SQL을 계속해서 확인해야 한다.
-   결국 비즈니스 로직이 SQL에 의존하게 된다.

**변경감지**

-   JPA 로 엔티티를 수정할 때는 단순히 엔티티를 조회해서 데이터만 변경하면 된다.

    ```java
    member.setUsername("DUDUDUNGA");
    member.setAge(10);

    // em.update(member) 이런 코드는 필요 없다.
    ```

-   엔티티의 변경사항을 데이터베이스에 자동으로 반영하는 기능을 변경 감지라고 한다.

-   JPA는 엔티티를 영속성 컨텍스트에 보관할 때, 최초 상태를 복사해서 저장해두는데 이것을 스냅샷이라고 한다.
-   그리고 플러시 시점에 엔티티와 스냅샷을 비교해서 변경된 엔티티를 찾는다.
-   변경감지가 일어나는 순서
    1. 트랜잭션을 커밋하면 엔티티 매니저 내부에서 flush()가 호출
    2. 엔티티와 스냅샷을 비교해서 변경된 엔티티를 찾음
    3. 변경된 엔티티가 있으면 수정 쿼리를 생성해서 쓰기 지연 SQL저장소에 보냄
    4. 쓰기 지연 저장소의 SQL을 데이터베이스에 보냄
    5. 데이터베이스 트랜잭션을 커밋함
-   변경 감지는 영속성 컨텍스트가 관리하는 영속 상태의 엔티티에만 적용된다.
-   JPA는 UPDATE SQL 기본 전략은 엔티티의 모든 필드를 업데이트하는것이다.
-   전송량이 증가하는 단점이 있지만 아래와 같은 장점이 있다
    -   모든 필드를 사용하면 수정 쿼리가 동일해짐, 따라서 애플리케이션 로딩 시점에 수정 쿼리를 미리 생성해두고 재사용 가능
    -   데이터베이스에 동일한 쿼리를 보내면 데이터베이스는 이전에 한 번 파싱된 쿼리를 재사용 할 수 있음
-   물론 하이버네이트와 같이 구현체에서 다이나믹 SQL을 제공하기도 한다.

### **3.4.4 엔티티 삭제**

```java
em.remove(memberA) // 엔티티 삭제
```

-   엔티티 등록과 비슷하게 삭제 쿼리를 쓰기 지연 SQL 저장소에 등록한다.
-   트랜잭션을 커밋해서 플러시를 호출하면 실제 데이터베이스에 삭제 쿼리를 전달한다.
-   em.remove()를 호출하는 순간 엔티티는 영속성 컨텍스트에서 제거된다.
-   삭제된 엔티티는 재사용하지말고 자연스럽게 가비지 컬렉션의 대상이 되도록 두는 것이 좋다.


## **3.5 플러시**

-   플러시(flush())는 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영한다.
    1. 변경 감지가 동작해서 영속성 컨텍스트에 모든 엔티티를 스냅샷과 비교해서 수정된 엔티티를 찾는다.
    2. 수정된 엔티티는 수정 쿼리를 만들어 쓰기 지연 SQL저장소에 등록한다.
    3. 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송한다.
   
-   영속성 컨텍스트를 플러시하는 방법은 3가지다
    1. em.flush()를 직접 호출한다.
    2. 트랜잭션 커밋 시 플러시가 자동 호출된다.
    3. JPQL쿼리 실행 시 플러시가 자동 호출된다.

**자동 호출**

-   엔티티 매니저의 flush() 메소드를 직접 호출해서 영속성 컨텍스트를 강제로 플러시한다.

**트랜잭션 커밋 시 플러시 자동 호출**

-   변경 내용을 저장하지 않고 트랜잭션만 커밋하면 어떤 데이터도 반영되지 않는다. 따라서 트랜잭션을 커밋하기 전에 꼭 플러시를 호출해서 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영해야한다.
-   그렇기 때무넹 JPA에서는 트랜잭션을 커밋하기 전에 플러시를 자동으로 호출한다. 


**JPQL 쿼리 실행 시 플러시 자동 호출**

-   JPQL 이나 Criterail 같은 객체지향 쿼리를 호출할 때도 플러시가 실행된다.
-   그 이유는 JPQL은  SQL로 변환되어 데이터베이스에 엔티티를 조회 한다. 그때 엔티티 정보가 데이터베이스에 반영되지 않고 영속성에만 머무르기 때문에 쿼리 결과가 조회되지 않는다.
-   따라서 쿼리를 실행하기 직전에 영속성 컨텍스트를 플러시해 데이터베이스에 반영한다.

### **3.5.1 플러시 모드 옵션**

-   FlushModeType.AUTO : 커밋이나 쿼리를 실행한 때 플러시 실행(기본값)
-   FlushModeType.COMMIT : 커밋할 때만 플러시
-   플러시가 영속성 컨텍스트에 보관된 엔티티를 지운다고 생각하면 안된다.
-   영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화 하는것이 플러시다.
