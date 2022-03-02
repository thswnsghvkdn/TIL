package HouseUtilsApplication.demo.service;

import HouseUtilsApplication.demo.entity.Apartment;
import HouseUtilsApplication.demo.exception.ErrorCode;
import HouseUtilsApplication.demo.exception.HouseUtilsException;
import HouseUtilsApplication.demo.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow()
                .getPrice();
    }
}
