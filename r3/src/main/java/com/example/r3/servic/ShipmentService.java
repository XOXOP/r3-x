package com.example.r3.servic;

import com.example.r3.entity.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    //void registShipment(Shipment shipment);
  //  List<Shipment> getAllShip();

    void save(Shipment shipment);
    Shipment registerShipment( Shipment shipment);
    Shipment getById(Long id);

    void deleteViaId(long id);

    void update(Shipment shipment);

    List<Shipment> getAllItem();
    //Status getStatus(Long id);

    String  getRecipientName(long id);


    //Shipment registerShipment(Shipment shipment);
}
