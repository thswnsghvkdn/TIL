package HouseUtilsApplication.demo.policy;


// 매매일 때 중계 수수료를 계산해 주는 클래스
// type에 따라 인터페이스를 구현하여 의존성 역전원칙을 지키도록 한다.

public class PurchaseBrokeragePolicy implements BrokeragePolicy {
    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price <50_000_000) {
            rule = new BrokerageRule(0.6 , 250_000L);
        } else if (price < 200_000_000) {
            rule = new BrokerageRule(0.5 , 800_000L);
        } else if (price < 600_000_000){
            rule = new BrokerageRule(0.4 , null);
        } else if (price <900_000_000) {
            rule = new BrokerageRule(0.5 , null);
        } else {
            rule = new BrokerageRule(0.9 , null);
        }
        return rule;
    }
}
