package com.example.r3.servic;

import com.example.r3.entity.Shipment;
import com.example.r3.projection.Employee;

import java.util.List;

public interface ShipmentService {
    void save(Shipment shipment);
    Shipment registerShipment( Shipment shipment);
    Shipment getById(Long id);

    void deleteViaId(long id);

    void update(Shipment shipment);

    List<Shipment> getAllItem();




    List<Shipment> findsByName(String recipientName);

    String  getRecipientName(long id);


    List<Shipment> getbyName(String recipientName);


  List <Employee> emplist(String recipientName);
   // List <Employee> empfulllist(String recipientName);
}
