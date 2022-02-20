package HouseUtilsApplication.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // api를 호출하는 restcontroller
public class HealthCheckController {
    @GetMapping("/api/ping")
    public String ping() {
        return "ok";
    }
}
