
# 이름을 명확히 쓰는 것만으로 가독성을 늘릴 수 있다.
<br>

## 통일성 있는 단어 사용하기
<HR><BR>
비슷한 맥락의 이름들  

Member == Customer == User
Service == Manager  
Repository == Dao  
협의를 통해서 비슷한 의미에대해 하나의 변수이름을 정해야한다.


## 의도를 분명히
<HR><BR>
다음의 함수의 기능을 보면 의아한 부분이 많다.

```
getThem() {
    List<int[]> list1 = new ArrayList<int>();
    for(int x : theList)
        if(x[0] == 4)
            list1.add(x);
    return list1;
}
```


list 를 gameBoard로 x 를 cell로 상수이름을 명확히 하여 지뢰 찾기 게임 관련 함수의 기능을 쉽게 파악할 수 있다.

```
getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int>();
    for(int cell : gameBoard)
        if(cell[STATUS_VALUE] == FLAGGED)
            flaggedCells.add(x);
    return flaggedCells;
}

```






## 그릇된 정보를 피하라
<HR><BR>


우리가 익숙히 알고있는 정보들을 피하라 ex ) 약어를 사용할 때 그것이 다른 의미가 아닌지 확인, 변수의 이름이 길어질때

흡사한 이름을 피해야 한다.


## 의미있게 구분하라
<HR><BR>

컴파일만 통과하려는 목적으로 다른 두 개념에 대해서 이름을 살짝만 바꾼다면 이는 나중에 여러 문제를 가져온다.



예를들어 상품에 대한 두개의 다른 클래스들을 productData 와 productInfo 로 지어버리면 두개의 구분이 정말 힘들어진다.

이런식을 의미가 불분명한 변수이름을 피해야 한다.

앞에 붙는다고 해서 차이를 줄 수 없는 단어(불용어)들을 피해야 한다.

ex ) a, an , the , info , String , Object


## 발음하기 쉬운 이름을 사용 
<HR><BR>

Dtr1Rcrd 같은 이름은 소통을 힘들게 한다.


## 검색하기 쉬운 이름을 사용
<HR><BR>

MAX_CLASSES 같은 이름을 사용한다면 쓰이는 부분을 명확히 검색으로 찾기 쉽지만

e, 7 같은 이름은 여러곳에서 쓰이므로 검색도 어려워진다.

또한 상수이름을 사용하지 않을 경우 숫자의 위치가 변경된 경우 검색은 되지만 문제를 일으키는 불상사를 만든다.





## 클래스 , 인터페이스 이름은 명사나 명사구가 적합 : Customer , WikiPage, Account
<HR><BR>


## 메서드 이름은 동사나 동사구가 적합 : postPayment, deletePage, save , 접근자나 변경자에 get 이나 set을 붙여서 사용하는 것도 좋은 예
<HR><BR>


## 기발한 이름은 피하라 : 이름을 지을 때는 유머와 창의력은 적절하지 않다.
<HR><BR>


## 한 개념에 한 단어를 사용하라 : fetch , retriece , get과 같은 비슷한 개념을 여러 클래스에서 사용하면 어떤 클래스에서 어떤 단어를 사용했는지 헷갈린다.
<HR><BR>


## 의미있는 맥락으로 묶기
<HR><BR>

firstName , lastName , street , houseNumber , city , state 변수들을 한번에 본다면 주소를 나타낸다는 것을 쉽게 알 수 있지만

따로 떨어져 있는 state 만을 가지고 해당 변수가 주소를 위해 사용된다는 것을 알기는 어렵다.

이를 위해 클래스 , 함수 , namespace 에 같은 맥락에 변수들을 묶는것이 좋다 address 라는 클래스로 묶는다면 address.state로 주소에 쓰인다는 것을 쉽게 알 수 있기 때문, 그러나 이렇게 묶기 힘들다면 최후의 방법으로 addr 이라는 접두어를 붙이는것 도 가능하다.

addrFirstName, addrLastName, addrState ...


## 불필요한 맥락을 없애라
<HR><BR>

Gas Station Deluxe 라는 앱을 구성한다고 해서 모든 클래스 앞에 GSD 를 붙이는 것은 G로 검색을 할 때 모든 클래스가 나오는 불상사를 야기할 것이다. 이름을 분명히 하는 것은 좋지만 클래스의 이름은 의미가 분명하되 간략한 것이 좋다. accountAddress 와 customerAddress는 인스턴스 이름으로 좋다. 포트주소 , MAC 주소 URI 주소 클래스를 구별해야한다면 PostalAddress , MAC , URI 로 나누는 것도 좋은 방법  
타입 역시 변수이름에 넣기 불필요하다. nameString 은 name으로 itemPriceAmount 는 itemPrice , accoutnArray 는 accounts로 표기한다.

*하지만 list와 map의 경우에는 accountList , accountMap으로 왕왕 쓴다.

​

