package HouseUtilsApplication.demo.repository;

import HouseUtilsApplication.demo.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {


}
