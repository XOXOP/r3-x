package com.example.r3.repositories;

import com.example.r3.entity.Shipment;
import com.example.r3.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

   // @Query(value = "SELECT status FROM ship WHERE id = :shipId", nativeQuery = true)
   // Status findStatusById(Long shipId);
   //@Query(value = "SELECT c.recipient_name FROM Shipment c WHERE c.id = :id",  nativeQuery = true)
   @Query("SELECT s.recipientName FROM Shipment s WHERE s.id = :id")
   String findStatusById(@Param("id") Long id);
}

//
//    // Чтобы получить статус конкретного ship по его id, используем этот метод
//   } String status = shipRepository.findStatusById(shipId);