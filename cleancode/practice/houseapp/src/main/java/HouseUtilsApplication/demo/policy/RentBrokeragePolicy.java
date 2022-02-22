package houseUtilsApplication.demo.policy;


// 임대차 때 중계 수수료를 계산해 주는 클래스
// type에 따라 인터페이스를 구현하여 의존성 역전원칙을 지키도록 한다.

public class RentBrokeragePolicy implements BrokeragePolicy{

    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price <50_000_000) {
            rule = new BrokerageRule(0.5 , 200_000L);
        } else if (price < 100_000_000) {
            rule = new BrokerageRule(0.4 , 300_000L);
        } else if (price < 300_000_000){
            rule = new BrokerageRule(0.3 , null);
        } else if (price <600_000_000) {
            rule = new BrokerageRule(0.4 , null);
        } else {
            rule = new BrokerageRule(0.8 , null);
        }
        return rule;
    }
}
