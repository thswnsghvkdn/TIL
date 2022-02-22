package houseUtilsApplication.demo.controller;



import houseUtilsApplication.demo.constants.ActionType;
import houseUtilsApplication.demo.policy.BrokeragePolicy;
import houseUtilsApplication.demo.policy.BrokeragePolicyFactory;
import houseUtilsApplication.demo.policy.PurchaseBrokeragePolicy;
import houseUtilsApplication.demo.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {

        // 사용자가 넘긴 type 에 대한 분기처리 후 정책을 반환 받는 것은 factory에서 담당하도록 한다.
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
