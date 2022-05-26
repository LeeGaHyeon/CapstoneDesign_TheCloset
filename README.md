# 내 손안의 AI 가상옷장, TheCloset

## 웹 기반 딥러닝을 활용한 패션 아이템 관리 및 분류 시스템

## 개요
사용자의 의류를 AI가 자동으로 분류해서 저장해주는 가상옷장 시스템
![프젝설명이미지](https://user-images.githubusercontent.com/57384781/170487350-69436f42-d096-4cfc-ba16-0a302cb91b46.png)


## 기술스택
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/jpa-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/thymeleaf-007396?style=for-the-badge&logo=thymeleaf&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
<img src="https://img.shields.io/badge/tensorflow.js-F7DF1E?style=for-the-badge&logo=tensorflow&logoColor=orange"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/pytorch-000000?style=for-the-badge&logo=pytorch&logoColor=orange"> <img src="https://img.shields.io/badge/JupyterNotebook-E8E8E8?style=for-the-badge&logo=Jupyter&logoColor=orange"> <img src="https://img.shields.io/badge/python-E8E8E8?style=for-the-badge&logo=python&logoColor="> <img src="https://img.shields.io/badge/tensorflow-F7DF1E?style=for-the-badge&logo=tensorflow&logoColor=orange">

## 아키텍쳐
![16](https://user-images.githubusercontent.com/50908451/170485427-0c3414b5-b82c-475f-b768-14202b11b6ce.PNG)
![아키텍처](https://user-images.githubusercontent.com/57384781/170486927-36550980-0c2f-40e1-975c-d5b4fa568f09.png)


## 일정
![SC](https://user-images.githubusercontent.com/50908451/170326905-c0b84d53-0d20-42e5-be88-4eaebadcaf5d.png)


## 요구사항
![15](https://user-images.githubusercontent.com/50908451/170442263-15d0427b-b1e5-4d3c-84e5-303758250b8b.PNG)


## 딥러닝
의류이미지를 분류하는 문제를 컴퓨터비전 기술 중 하나인 image classification을 통해 구현한다.
데이터셋은 약 70,000장의 의류 데이터셋  fashion-MNIST이다.
딥러닝 모델구축에 사용한 네트워크로는 fully conected network와 convolutional neural network이다.


## 프론트엔드
HTML을 사용해 전체적인 구조를 잡고 css를 사용하여 사용자가 보기 편하도록 디자인했다.
보다 더 깔끔한 디자인을 위해 부트스트랩을 사용하였다.
웹페이지에 필요한 동작에는 자바스크립트로 작성하였다.


## 백엔드
백엔드에서는 spring boot, jpa, mariaDB를 사용하였다. 로그인과 회원가입의 보안을 위해 security를 이용하였고,
MVC model을 사용하여 서버와 프론트를 타임리프를 통해 연결했다.


## 설계

### UI 설계서
![3](https://user-images.githubusercontent.com/50908451/170425216-1f5cfdee-644b-4dab-8e56-a4cff0879a5f.PNG)
![4](https://user-images.githubusercontent.com/50908451/170425219-8e98e7e0-8ab6-4433-952a-0a0fafb02c4f.PNG)
![5](https://user-images.githubusercontent.com/50908451/170425221-c5c1b47a-c1c7-4f91-adb3-6fcea3a3509e.PNG)
![2](https://user-images.githubusercontent.com/50908451/170424499-4e33b177-afb1-4f20-bffe-1845054720f6.PNG)
[KakaoTalk_20220526_212825158](https://user-images.githubusercontent.com/57384781/170488013-7c8b99d8-cba2-471b-9e81-936b4b2b7997.png)
![8](https://user-images.githubusercontent.com/50908451/170426242-556013ed-5437-4112-8bef-c2e993f0119d.png) 
![아키텍처](https://user-images.githubusercontent.com/57384781/170486927-36550980-0c2f-40e1-975c-d5b4fa568f09.png)


## 테스트
![9](https://user-images.githubusercontent.com/50908451/170426359-7eb10787-1697-41af-932e-90914c7ae75c.png)

## 메인페이지
![main](https://user-images.githubusercontent.com/57384781/170471821-e3e72471-e593-444d-a4af-9148700069b2.png)

## 로그인페이지
![login](https://user-images.githubusercontent.com/57384781/170471978-3ca4e553-adf0-4412-8fa4-17ca4c062ff4.png)

## 회원가입페이지
![register](https://user-images.githubusercontent.com/57384781/170472113-82a9a817-ffdc-40c8-8d29-45b7cfe2db23.png)

## 옷장페이지
![closet](https://user-images.githubusercontent.com/57384781/170472660-6431a3db-fbbc-470d-97ae-abb098eaf74b.png)

## 업로드페이지
![upload](https://user-images.githubusercontent.com/57384781/170472580-cedf464a-cb46-43e7-b8a9-cac6768d9ace.png)
