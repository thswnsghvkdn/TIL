package HouseUtilsApplication.demo.controller;



import HouseUtilsApplication.demo.constants.ActionType;
import HouseUtilsApplication.demo.entity.Apartment;
import HouseUtilsApplication.demo.policy.BrokeragePolicy;
import HouseUtilsApplication.demo.policy.BrokeragePolicyFactory;
import HouseUtilsApplication.demo.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 중계 수수료가 얼마인지 조회하는 컨트롤러
 */

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
