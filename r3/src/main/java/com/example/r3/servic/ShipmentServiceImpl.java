package com.example.r3.servic;

import com.example.r3.entity.Shipment;
import com.example.r3.repositories.ShipmentRepository;
import com.example.r3.projection.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepo;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }


    @Override
    public void save(Shipment shipment) {
        shipmentRepo.save(shipment);
    }

    @Override
    public Shipment registerShipment(Shipment shipment) {
        return shipmentRepo.save(shipment);
    }

    @Override
    public Shipment getById(Long id) {
        Optional<Shipment> optional = shipmentRepo.findById(id);
        Shipment shipment = null;
        if (optional.isPresent())
            shipment = optional.get();
        else
            throw new NullPointerException(
                    "Employee not found for id : " + id);
        return shipment;
    }

    @Override
    public void deleteViaId(long id) {
        shipmentRepo.deleteById(id);
    }

    @Override
    public void update(Shipment shipment) {
        shipmentRepo.save(shipment);
    }

    @Override
    public List<Shipment> getAllItem() {
        return shipmentRepo.findAll();
    }

    @Override
    public List<Shipment> findsByName(String recipientName) {
        return shipmentRepo.findsByName(recipientName);
    }

    @Override
    public String getRecipientName(long id) {
        return shipmentRepo.findStatusById(id);
    }

    @Override
    public List<Shipment> getbyName(String recipientName) {
        return shipmentRepo.findsByName(recipientName);
    }

    @Override
    public List<Employee> emplist(String recipientName) {
        return shipmentRepo.findAllByrecipientName(recipientName);


    }

//    @Override
//    public List<Employee> empfulllist(String recipientName) {
//        return shipmentRepo.findAllByrecipientNameAnd(recipientName);
//    }


}

