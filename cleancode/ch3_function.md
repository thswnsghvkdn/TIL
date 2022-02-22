## 작게 만들어라 
<br>

if , while, else 문 등에 들어가는 블록은 메소드로 추출한 한 줄 이어야 한다.
따라서 함수내에서 중첩토드가 생기면 안되며 들여쓰기 수준이 1단, 2단을 넘어서면 안된다.

​

## 한가지만 해라
<br>

함수 이름 아래에서 추상화 수준이 하나인 단계만 수행하거나 , 더 이상 다른 의미 있는 이름으로 함수를 추출하지 못한다면 그 함수는 한 가지 작업만 한다고 본다. 

한가지 작업 만을 하는 함수 예


한가지 함수내에서는 같은 수준의 추상화를 두어야 하는데 

맨 위 함수를 확인해보면 get.html()은 추상화 수준이 아주 높고 , PathParser.render(pagepath) 은 중간 정도 이며 , append("\n") 은 추상화 수준이 아주 낮다. 이러한 여러 추상화 수준을 혼재 하여서 작성 할 경우 읽는 사람이 특정 표현에 대해서 근본 개념인지 세부사항인지 구분하기 어렵다. 

내려가기 규칙 함수 내부에서 추상화 수준은 점차 내려가는 방식으로 각 함수는 다음 한수를 소개하는 방식으로 진행해야 한다.


​

*TO 문단이란

*추상화 수준이란

​

## 서술적인 이름을 사용하라

testableHtml -> SetupTeardownIncluder , isTestable -> includesetupAndTeardownPages
또한 일관성이 있어야 하는데 이름만 보더라도 다른 함수의 이름을 예측하기 쉬워야 한다. 

 

## 함수 인수 

인수는 개념을 이해하기 서렵게 만든다. 이상적인 인수 개수는 0개 이며 3개 이상은 피하는 것이 좋다. 

### 많이 쓰는 단항 형식
1개의 인수를 써도 좋은 경우는 인수에 대해 질문을 던지는 경우boolean fileExists("file") , 인수를 변환하여 반환하는 경우이다 inpuStraem fileOpen("file")

### 플래그 인수
플래그 인수를 사용한다는 것은 플래그 값에 따라서 함수가 여러가지 동작을 한다는 의미 이므로 사용하지 않는 것이 좋다.

### 이항 함수 
이항 함수는 단항 함수보다 이해하기 힘들다. 따라서 왠만하면 단항함수로 쓰는 것이 좋다. 
예를들어 writeField(outputStream, name) 에서 outputStream을 writeField 클래스 구성원으로 만들어 outputStream.writeField(name)으로 호출하는 것 이해하기 더 좋다. 다항 함수를 줄이기 위해 클래스 변수와 list 형 인수를 사용하는 것도 좋은 선택지이다. 


## 동사와 키워드 
<br>
함수와 인수간 동사 / 명사 쌍을 맞춰 준다면 훨씬 이해하기 쉬워진다. writeField(name) 은 이름필드에 인수를 작성한다는 뜻이며 assertExpectedEqualsActual(expected , actual) 은 인수의 순서도 명시하여 실수 할 가능성을 낮춰준다.

 

​

## 부수효과를 일으키지 말자 
<br>

명시한 함수 이름에서 유추되는 기능외에 다른 작용을 일으키면 안된다. 
아래 사진에서는 checkPassword 라는 무해한 이름아래 Sessing.initialize() 호출을 하여 세션을 초기화하는 부작용을 숨기고 있다.
이럴때에는 checkPasswordAndSessionIntialize 라는 이름을 붙여준다.


​

## 출력인수 
<br>

appendFooter(s)는 s에 푸터를 추가하는지 푸터에 s를 출력하는 헷갈린다. 
객체지향이 나온 후 부터는 출력 인수를 this로 사용하여 s.appendFooter()로 사용한다. 

​

## 명령과 조회를 분리하라. 
<br>

if( set("username" , "unclebob")) 은 uncle bob 으로 이름을 변경하는데 성공한다면으로 한번에 읽히지 않는다 
이를 if ( attributeExists("username")) { setAttribute("username" , "unclebob")} 으로 변경한다.

​

## 오류처리를 함수로 처리하라 

try/catch 구조는 혼란을 일으키며 정상동작과 오류 처리 동작을 뒤섞는다. 오류 처리도 한 가지 작업이다 오류 처리는 초류 처리만 해야 마땅하다.


​

함수를 짜는 과정 

앞에 서술 했던 과정을 처음부터 지키면서 하는 것이 아닌 처음에 작성한 함수를 점차 가독성이 좋도록 바꿔나가는 것이 중요하다.

 