![header](https://capsule-render.vercel.app/api?type=Waving&color=FFA07A&height=250&section=header&text=The%20Closet&fontSize=90)
========================================================================================================================================

# ✨내 손안의 AI 가상옷장, TheCloset✨

## 👕웹 기반 딥러닝을 활용한 패션 아이템 관리 및 분류 시스템👖

## 🐹 자기소개 🐹
  - 이름 : 박주희
  - 학번 : 20185131
  - 소속 : 소프트웨어 융합대학 빅데이터전공


## 🌱백엔드
백엔드에서는 spring boot, jpa, mariaDB를 사용하였다. 로그인과 회원가입의 보안을 위해 security를 이용하였고,
MVC model을 사용하여 서버와 프론트를 thymeleaf 통해 연결했다.


## ✏️기술스택
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/jpa-D70F64?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> 



## 📌개요
사용자의 의류를 AI가 자동으로 분류해서 저장해주는 가상옷장 시스템
![프젝설명이미지](https://user-images.githubusercontent.com/57384781/170487350-69436f42-d096-4cfc-ba16-0a302cb91b46.png)

## 🤟백엔드 가이드
### src -> main -> java/capston/thecloset
- Config : security 설정 및 권한 설정
-	Controller : 도메인 주소 설정과 view 연결
-	Domain : 서버에서 사용하는 객체 및 DB 연관관계를 맺음
-	Repository : DB 접근과 쿼리
- Service : 비즈니스 로직, Dto : 사용자가 엔티티에 직접 접근 할 수 없도록 별도의 객체를 사용하여 보완성 강화 

### src -> main -> resource -> templates
- 프론트엔드에서 만든 view를 서버에 연결하기 위해 thymeleaf 코드 적용

### src -> test/java/capston/thecloset
junit5 , mvcMock 사용
- controller -> 로그인 성공,실패 테스트 
- service ->  MemberServiceImplTest : 회원가입 테스트
- service -> ItemServiceTest : 아이템리스트 테스트

