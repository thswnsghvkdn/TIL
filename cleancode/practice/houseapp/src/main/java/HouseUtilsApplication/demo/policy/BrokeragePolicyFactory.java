package houseUtilsApplication.demo.policy;

import houseUtilsApplication.demo.constants.ActionType;

public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new IllegalArgumentException("해당 actionType이 정의되지 않았습니다.");
        }
    }
}
