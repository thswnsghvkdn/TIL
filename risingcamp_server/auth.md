### api 설계를 할 때 비회원용과 회원용을 나누어서 구별을 두어야 한다. 
http method 는 stateless 하기 때문에 로그인 정보를 따로 저장해야 한다. 

  
### 세션, 캐시와 쿠키 차이 : 쿠키,세션은 보안 인증 , 캐시는 성능과 효율관련 
한번 다운 하였던 정보는 캐시에 저장 
세션은 보안, 인증정보를 서버에서 저장하는 저장소 
쿠키는 세션 아이디를 저장하는 저장소 


### jwt 방식
로그인 인증 정보를 쿠키방식으로 저장할 경우 , DB의 역할이 늘어난다는 것과 탈취의 위험성이 존재한다. 
Jwt의 방식은 인코딩된 문자열을 저장하여 토큰보다는 조금 더 예측이 어려운 안전한 방식을 취한다. 하지만 마찬가지로 탈취당할 경우 아무 문제가 생기지 않는 것은 아니다.
또한 서버에서는 특정한 값을 가지는 것이 아닌 디코딩 방식만 알면 되기 때문에 DB에 중요정보를 저장하고 있어야 할 위험성이 없어진다.

### 소셜 로그인 
요즘은 로그인시에 카카오나 네이버 같은 다른 사이트에서 로그인 인증을 대신해주는 방법이 많다. OAuth

### Transaction 
송금과 같은 행위에서 DB 통신이 이루어질 때 하나라도 문제가 있을 경우 롤백이 발생하여 상태를 원상복귀 시켜야 한다. Transaction 은 여기서 모든 작업이 이루어져야 하는 하나의 단위이다
