
### NXT 개발 환경 설정하기(IntelliJ IDEA 기준)


NXT는 java version 8이상에서 지원하는 지원하는 기능(람다 표현식)등을 사용하므로 빌드를 위해서는 자바 8버전 이상 필요


1. 인텔리제이 다운로드 & 설치
https://www.jetbrains.com/idea/download/download_thanks.jsp


2. 소스다운로드

	```
	git clone https://github.com/p2plab/NXT

	```

3. 인텔리제이 빈 프로젝트 생성

	```
	Menu->File->New...
	```
4. 소스 & 라이브러리 추가
	
	```
	Menu->File->Project Structure...
	Project SDK: 자바 1.8 이상
	Project Language Level: 8 - Lambdas,type annotations etc
	${NXT}/src
	${NXT}/lib
	```
5. 실행 & 디버깅 

	```
	Menu->Run->Edit Configuration... 다음 파라메터 추가
	VM Options: -cp classes:lib/*:conf -Dnxt.runtime.mode=desktop nxt.Nxt
	```







