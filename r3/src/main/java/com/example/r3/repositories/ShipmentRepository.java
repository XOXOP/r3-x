package com.example.r3.repositories;

import com.example.r3.entity.Shipment;
import com.example.r3.projection.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

    @Query(value = "SELECT s.status FROM Shipment  s WHERE s.id = :id")
    String findStatusById(@Param("id") Long id);
   //@Query(value = "SELECT c.recipient_name FROM Shipment c WHERE c.id = :id",  nativeQuery = true)
   @Query("SELECT  s FROM Shipment s WHERE s.recipientName = :recipientName")
   List<Shipment> findsByName(@Param("recipientName") String recipientName);


  List<Employee> findAllByrecipientName(@Param("recipientName")String recipientName);

  // List<Employee> findAllByrecipientNameAnd(@Param("recipientName")String recipientName);


}



//
//    // Чтобы получить статус конкретного ship по его id, используем этот метод
//   } String status = shipRepository.findStatusById(shipId);