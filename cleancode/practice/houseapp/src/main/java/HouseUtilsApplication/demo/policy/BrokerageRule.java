package houseUtilsApplication.demo.policy;

import lombok.AllArgsConstructor;

// 가격이 특정 범위일 대 상한 요율과 상한 금액을 가지는 클래스
@AllArgsConstructor
public class BrokerageRule {
    private Double brokeragePercent;
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if(limitAmount == null) {
            // 조건 문 안에 함수로 처리하여 단일 책임 원칙
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price) , limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}

