## 단순히 지금까지는 추상화를 통한 방법( 자료를 세세하게 공개하기 보다는 추상적인 개념으로 표현하는 편이 좋다)이 무조건 좋다고 생각되었다. 

하지만 모든 경우에 추상화를 하지 않는 자료구조역시 필요하다.



​

## 그렇다면 절차적인구조와 객체적인 구조는 어떠한 강점이 있을까

예를들어 각 도형에 대해 넓이를 구할 때 Geometry 라는 하나의 클래스안에서  area라는 메소드에서 

절차적인 방법처럼 모든 도형의 넓이를 구하는 방식을 취한다면 새로운 도형이 생길때 마다 계산식을 추가하는 등의 함수변경이 불가피하다.


하지만 만약에 객체적인 방법을 차용하여 각 도형클래스 마다 area를 반환하는 메소드가 있다면 새로운 도형이 나올 경우 클래스를 추가해야 하지만. 기존의 존재하는 함수를 변경시키지는 않는다. 하지만 클래스에 함수를 변경해야 한다면 모든 클래스들에 대해 같은 변화를 주어야 한다.


즉 절차적인 코드는 의존적인만큼 새로운 자료구조를 추가하려면 모든 함수를 변경해야한다.

객체지향 코드는 독립적인만큼 새로운 함수를 추가할 경우 모든 클래스에 같은 변화를 주어야 한다.


​

* 휴대폰 배터리처럼 실제 수치는 중요하지 않고 퍼센트만 중요한 경우 객체를 사용하는 것이 좋다. 

​


​

​

### 객체를 생성한다면 디미터 법칙을 지켜야 한다.

​

* 디미터 법칙 : A - B - C 순으로 의존성을 가질 때 A 에서 C 를 호출하여 변경사항이 발생 한다면 B까지 영향을 주는 것이기 때문에
  
바로 직접적인 친구관계에서만 호출을 해야한다. 

​

​

* 휴리스틱 : 경험에 의해 알게 된 방법



* Active Record
  
Entity 와 Repository 의 기능을 모두 가지고 있음




## 분별있는 프로그래머는 모든 것이 객체라는 생각이 미신임을 잘 안다 떄로는 단순한 자료구조와 절차적인 코드가 가장 적합한 상황도 있다.

​

객체는 추상화 뒤로 자료를 숨긴 채 자료를 다루는 함수만 공개한다.

자료구조는 자료를 그대로 공개하며 별다른 함수는 제공하지 않는다.

객체지향 코드에서 어려운 변경은 절차적인 코드에서 쉬우며, 절차적인 코드에서 어려운 변경은 객체 지향 코드에서 쉽다

시스템에서 새로운 자료 타입이 필요한 경우  클래스와 객체 지향 기법이 적합하고

새로운 함수가 필요한경우 절차적인 코드와 자료구조가 좀 더 적합하다.

​

즉 새로운 자료타입을 추가하는 유연성이 필요하면 객체가 더 작합하고 ㅡ 새로운 동작을 추가하는 유연성이 필요하면 자료구조와 절차적인 코드가 더 적합하다.

​

실습에서 예를들어본다면 policy 와 rule  같은 로직을 담당하는 경우는 객체 지향 코드로 작성이 되었고 Entity 클래스들은 절차지향적으로 작성이 되었다. 

​

### 객체지향 코드

```
@RestController
@AllArgsConstructor
public class BrokerageQueryController {
    private final ApartmentService apartmentService;


    @GetMapping("/api/calc/brokerage")
    public long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {

        // 사용자가 넘긴 type 에 대한 분기처리 후 정책을 반환 받는 것은 factory에서 담당하도록 한다.
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/{apartmentId}")
    public Long calcBrokerageByApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}
''' 
### 절차지향 적인 코드

@Entity
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String address;

    @Column(nullable = false)
    public Long price;

}
​