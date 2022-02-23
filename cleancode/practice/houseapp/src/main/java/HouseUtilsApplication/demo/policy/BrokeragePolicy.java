package houseUtilsApplication.demo.policy;



public interface BrokeragePolicy {
    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price) {
        BrokerageRule rule = createBrokerageRule(price); // rule을 생성하는 책임에 대하여 또 다른 함수로 추출하여 단일 책임원칙을 지킨다.
        return rule.calcMaxBrokerage(price);
    }
}
