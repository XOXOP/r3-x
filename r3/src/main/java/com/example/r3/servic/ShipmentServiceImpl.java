package com.example.r3.servic;

import com.example.r3.entity.Shipment;
import com.example.r3.repositories.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }

    //private Map<Long, Shipment> shipments = new HashMap<>();

    // private Map<String, ShipmentHistory> shipmentHistories = new HashMap<>();

    // Регистрация почтового отправления

//    @Override
//    public List<Shipment> getAllUsers() {
//        return shipmentRepo.findAll();
//    }

    @Override
    public void save(Shipment shipment) {shipmentRepo.save(shipment);}

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
    public String getRecipientName(long id) {
        return shipmentRepo.findStatusById(id);
    }




//    @Override
//    public String getStatus(Long id) {
//        shipmentRepo.findStatusById(id);
//
//        return ;
//        //return Status.valueOf(status);
//    }



}
//    @Override
//    public List<Shipment> getAllUsers() {
//        return shipmentRepo.findAll();
//    }


    // shipmentHistories.put(shipment.getId(), new ShipmentHistory(shipment.getId(), new ArrayList<>()));


/*
    // Прибытие в промежуточное почтовое отделение
    public ShipmentEvent arriveInIntermediatePostOffice(String shipmentId, String location) {
        ShipmentEvent event = new ShipmentEvent(new Date(), location, "arrived");
        ShipmentHistory history = shipmentHistories.get(shipmentId);
        history.getEvents().add(event);
        return event;
    }

    // Убытие из почтового отделения
    public ShipmentEvent departFromPostOffice(String shipmentId, String location) {
        ShipmentEvent event = new ShipmentEvent(new Date(), location, "departed");
        ShipmentHistory history = shipmentHistories.get(shipmentId);
        history.getEvents().add(event);
        return event;
    }

    // Получение адресатом
    public ShipmentEvent receiveByRecipient(String shipmentId) {
        ShipmentEvent event = new ShipmentEvent(new Date(), "Final Destination", "delivered");
        ShipmentHistory history = shipmentHistories.get(shipmentId);
        history.getEvents().add(event);
        return event;
    }

    // Просмотр статуса и полной истории движения почтового отправления
    public ShipmentHistory getShipmentHistory(String shipmentId) {
        return shipmentHistories.get(shipmentId);
    }
}
*/