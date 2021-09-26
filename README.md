# side_project
개인 프로젝트
깃허브블로그(시현영상을 볼수 있습니다.) : https://ricky9397.github.io/Portfolio_bolg/ 

2021/7/13
<h2>개발 환경 및 기술</h2>
 - eclipse <br>
 - HTML,CSS,JS,JQuery,json,ajax<br>
 - jsp,servlet,java<br>
 - EL,JSTL<br>
 - DB(oracle)<br>
 - apache-tomcat-8.5<br>
 - servlet mvc2패턴, frontcontroller 사용<br>
<br><br>

![패키지2](https://user-images.githubusercontent.com/84554175/134033693-a7f65bc0-38c5-4751-860f-bc75c7b117ba.png)
![화면 캡처 2021-08-04 173201](https://user-images.githubusercontent.com/84554175/134033696-e13c1e64-0c99-49d3-b85b-fabf540f98b9.png)
![jsp1](https://user-images.githubusercontent.com/84554175/134033701-abbc9454-73f1-45e1-9573-9c35a29a00fd.png)
![jsp css js](https://user-images.githubusercontent.com/84554175/134033706-346268bd-d725-45f9-84e9-5d05cf208c6e.png)
<br><br>
<h2>1. 주제</h2>
신발 쇼핑몰 만들기
<br>
<h2>2. EXERD</h2>

![화면 캡처 2021-09-25 231700](https://user-images.githubusercontent.com/84554175/134811358-28007b67-8bea-4f3c-a9d9-5edfcfb7e3c7.png)

<br>
<h2>3. 기능 구현</h2>
-회원가입, 로그인, 회원정보수정, 회원탈퇴<br>
-게시글 입력, 수정, 삭제<br>
-페이징 처리<br>
-글 입력시 사진 업로드<br>
-답변 글 달기<br>
-조회수 증가<br>
-상품 주문, 상품 주문 취소<br>
-장바구니 상품담기, 장바구니 상품삭제<br>
-관리자 상품등록, 상품삭제<br>
<br>
<hr>

<h4>상품등록</h4>
 - 관리자 로그인을 통해 관리자로 접속한뒤 관리자만 상품을 등록할 수 있다.<br>
 - 아이디 : admin 비밀번호 : 1234  <br>
 
![관리자 등록 1](https://user-images.githubusercontent.com/84554175/134034863-ce5689e9-3d10-43dc-a491-fe0b75c5aeaf.png)

<br>
<hr>

<h4>상품관리</h4>
 - 관리자는 상품등록 및 삭제를 할 수 있다.
 <br>
 
![상품등록완료](https://user-images.githubusercontent.com/84554175/134034937-26ef1afb-99a4-49e9-91f6-385147aff5a7.png)
<br>
<hr>

<h4>회원가입 이용약관</h4> 
 - 이용약관 모두 동의 해야지만 회원가입 가능하다.
 <br>
 
![회원가입1](https://user-images.githubusercontent.com/84554175/134035009-d7aeadac-5a2a-4da1-b978-e7681add537a.png)
<br>
<hr>

<h4>회원가입 메인</h4>
 - 아이디 중복확인 ajax로 유효성 검사를 실시  <br>
 - jquery 정규식 패턴 사용하여 필수입력란에 맞지않으면 회원가입이 불가능하다. <br>

![회원가입2](https://user-images.githubusercontent.com/84554175/134035939-8f053678-8792-4d41-864e-761e8d10e9f3.png)

<br>
<hr>

<h4>우편등록 다음 api</h4>
 - 다음 api사용 우편등록 가능<br>

![회원가입4](https://user-images.githubusercontent.com/84554175/134035115-6d68f3ee-b4c1-4ba3-a40b-06dc4066f85e.png)
<br>
<hr>

<h4>가입완료</h4>
 - 가입이 완료되면 자동로그인과 세션을 저장 후 세션을 뿌려준었다. <br>

![회원가입 완료](https://user-images.githubusercontent.com/84554175/134035175-c4e6f991-ec68-4b56-8a08-99c0257acb6b.png)
<br>
<hr>

<h2>my페이지</h2>
 - 회원정보와 주문내역조회를 할 수 있다. <br>
 
![my페이지](https://user-images.githubusercontent.com/84554175/134036459-33152a10-bf44-4851-94de-62ebfc8917dc.png)
<br>
<hr>

<h2>회원정보 수정</h2>
 - 회원정보 수정 : 기존 기록을 남기고 자주 변경되는 패스워드와 전화번호는 기록을 빼고 아이디는 입력란이 변경 되지 않는다. <br>
 - 회원탈퇴버튼 클릭시 회원이 탈퇴된다. <br>
 
![회원정보수정](https://user-images.githubusercontent.com/84554175/134036387-5aaf441f-27e6-4b4c-bba3-761759b50d93.png)
<br>
<hr>

<h2>로그인</h2>
 - 로그인 유효성검사를 ajax로 구현하여 로그인 실패시 alert창을 띄어준다. <br>
 - 로그인이 성공하면 index화면으로 이동한다. <br>
 
![로그인](https://user-images.githubusercontent.com/84554175/134035996-9959185f-6f40-4e37-93eb-44fdfb96f64b.png)
<br>
<hr>

<h2>상품상세페이지</h2>
 - shop에 있는 상품을 클릭하면 상품을 상세볼 수 있다. <br>
 - 상품 상세페이지에서 사이즈 수량을 선택하고 장바구니에 담을지 주문을 할지 선택 할 수 있다.  <br>
 - 비회원의 경우에 주문버튼을 누를 경우 로그인창으로 이동한다.  <br>
 - 비회원은 장바구니를 사용할 수 있다. <br>
 
![상품상세페이지](https://user-images.githubusercontent.com/84554175/134036061-c8f20044-0e73-4544-9ffa-4c1daa92a217.png)
<br>
<hr>

<h2>상품장바구니</h2>
 - 비회원도 사용할 수 있기때문에 장바구니를 세션으로 구현했다. <br>
 - 1개 뿐아니라 2~3 등록이 되면 가격 변동이 일어 난다. <br>
 - 삭제하기 버튼을 누를 경우 세션은 하나씩만 지워진다. 사실 이부분이 어려웠던 것 같다. 세션을 전부 삭제하지않고 신발idx를 가진 세션만 삭제해야 대서 ..ㅠ 그래도 세션에 대해 많이 공부 되었다.<br>
 - 비회원이 주문할 경우 로그인창으로 이동하게 된다. <br>
 
![장바구니](https://user-images.githubusercontent.com/84554175/134036124-3b9ab9b6-1ca3-4355-8b1b-9c7403b2c9f0.png)
<br>
<hr>

<h2>상품주문</h2>
- 상단에 있는 장바구니 모양 클릭이나, 마이페이지 주문 결제 확인 할 수 있다. <br>
- 주문내용이 없으면 상품없다는 문구로 알려주었다. <br>

![주문내역](https://user-images.githubusercontent.com/84554175/134036197-f905dc21-c842-442c-9966-1632c735dd5f.png)
<br>
<hr>

<h2>주문완료</h2>

![주문완료](https://user-images.githubusercontent.com/84554175/134036270-06d67d74-4960-481c-b440-408dffcdc5f7.png)
<br>
<hr>

<h2>상품주문내역</h2>
- 주문할경우 DB에 저장된 주문상품을 뿌려주었다. <br>
- 주문을 취소할 경우 주문은 삭제가 된다.  <br>

![주문내역1](https://user-images.githubusercontent.com/84554175/134036235-344a8423-3c47-45f3-aa4a-b324664f56b5.png)
<br>
<hr>

<h2>페이징 및 게시판 메인</h2>
 - 게시판 조회수도 확인 할 수 있다.<br>
 
![페이징](https://user-images.githubusercontent.com/84554175/134036698-53e4c094-5715-45d8-92ef-f4a2f2e970b6.png)
<br>
<hr>

<h2>게시글 검색</h2>
 - 게시글 검색은 제목, 작성자 나누어 검색할 수 있다.<br>
 
![게시글 검색](https://user-images.githubusercontent.com/84554175/134036740-b67937f9-9da7-4858-81df-6395fd48aae5.png)
<br>
<hr>

<h2>게시판 글작성</h2>
 - 게시글 작성 할때 사진과 같이 첨부하면 게시판메인에 사진도 같이 출력도 되고 게시글 상세페이지에서도 사진을 확인 할 수 있다.<br>
 - 사진을 첨부하지 않을 경우에는 사진이 출력 되지 않는다.<br>
 
![게시판 글쓰기](https://user-images.githubusercontent.com/84554175/134036796-c9ce54b2-91b0-44a1-a2b1-e312795c049c.png)
<br>
<hr>

<h2>게시글 보기</h2>
 - 게시글 볼 때 자기가 쓴글이면 삭제, 수정 버튼이 보인다.<br>
 - 자기가 쓴글이 아닐때는 삭제, 수정 버튼을 숨기어 삭제, 수정을 할수 없다.<br>
 
![게시판글 보기](https://user-images.githubusercontent.com/84554175/134036852-0a640838-12e0-433b-b1a8-1d04d6d561f0.png)
<br>
<hr>

<h2>댓글</h2>
 - 댓글작성과 댓글삭제는 ajax 로 구현하여 화면이동없이 비동기로 처리하였다.<br>
 - 마찬가지로 자기가 쓴글이 아니면 삭제를 숨기어 삭제 할 수가 없다.<br>
 
![댓글](https://user-images.githubusercontent.com/84554175/134036898-8ffe0081-2f6f-4023-b9a0-1513f45de9d2.png)

<h2>MVC의 이해</h2>
- mvc1은 jsp파일과 controller와 함께 사용한다.(유지보수가 어렵다.)<br>
- mvc2는 view와 controller를 분리 하여 개발한다. (유지보수가 쉬워진다.)<br>
- 말그대로 m : model(모델은 컨트롤러에서 받은 데이터를 처리한뒤 컨트롤러로 다시보내주는 역활), v : view(사용자에게 보여주는 역활), c : controller(사용자에게 입력받은 값을 받아 컨트롤 해주는 역활이다.<br>
- frontcontroller는 인터페이스를 상속한다. 맨앞에 frontcontroller가 있고 모든 데이터를 요청 받아 처리 하기 때문에 굉장히 편리하다. 경로를 xml에서<br>
  *.do로 설정하면 경로 #####.do로하면 프론트컨트롤러로 간다.<br>
<h2>json의 이해</h2>
 - json은 통합언어 이다. <br>
 - 쉽게 설명하면 java는 다른언어를 읽을 수 없다. 그렇기 때문에 중간에 json에 담아 보내면 다른언어도 java를 읽을 수 있게 해준다.(java뿐만이아니라 다른언어도 마찬가지로 json에 담아보내면 java에서 읽을 수 있다.)<br>
<h2>ajax의 이해</h2>
 - ajax는 화면이동없이 비동기 통신을 하기위해 주로 많이 사용 되는 것 같다.<br>
 - 동적인 화면 출력 및 웹 서버와 비동기적으로 데이터를 교환하고 조작하기 위한 웹 개발 기법이다. <br>
 - 그냥 쉽게 말해서 controller -> DAO -> DB 를 초고속으로 빠르게 다녀온다. <br>
