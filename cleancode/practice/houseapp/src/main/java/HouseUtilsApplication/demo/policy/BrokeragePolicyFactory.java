package HouseUtilsApplication.demo.policy;

import HouseUtilsApplication.demo.constants.ActionType;
import HouseUtilsApplication.demo.exception.ErrorCode;
import HouseUtilsApplication.demo.exception.HouseUtilsException;

public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType 에 대한 정책이 존재하지 않습니다.");
        }
    }
}
