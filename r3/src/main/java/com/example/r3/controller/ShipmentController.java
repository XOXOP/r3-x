package com.example.r3.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.r3.entity.Shipment;
import com.example.r3.servic.ShipmentService;

import java.util.List;


@Tag(name = "main_metod")
@Controller
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/")//1
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", shipmentService.getAllItem());
        return "index";
    }

        @GetMapping("/loop")
        public @ResponseBody List<Shipment> getAllItem() {
            return shipmentService.getAllItem();
        }




    //@GetMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE))

//    public String viewHomePage2() {
//       // List <user> users = userService.getAllUsers();
//        ResponseEntity.status(201).body(userService.getAllUsers());
//        String jsonData ;
////        try {
////
////            jsonData = objectMapper.writeValueAsString(userService.getAllUsers());
////        } catch (JsonProcessingException e) {
////            throw new RuntimeException(e);
////        }
//        return jsonData;



//    @GetMapping("/shipment")
//    public  String viewHomePage1() {
//        //  userService.getAllHistory(String id);
//        Shipment shipment = new Shipment(2L, "lola", "verb", "20125",
//                "jkgkg", "recivad");
//        String jsonData ;
//        try {
//            jsonData = objectMapper.writeValueAsString(shipment);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return jsonData;
//    }
//    @PostMapping("/shipmen")
//    public ResponseEntity<HttpStatus> addUser(@RequestBody Shipment shipment) {//UsDTO usrDt
//        //userService.addUser(userService.convertToUser(userDto));
//        shipmentService.registShipment(shipment);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    //User user = findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("User" + username + "not found"));
//        }
    @GetMapping("/addnew")//2
    public String addNewEmployee(Model model) {
        Shipment shipment = new Shipment();
        model.addAttribute("employee", shipment);
        return "newemployee";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Shipment shipment) {
        shipmentService.save(shipment);
        return "redirect:/";
    }


    @PostMapping("/shipment")//2a
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Shipment addnewShipment(@RequestBody Shipment shipment) {
     //   return  shipmentService.save(shipment);
        return  shipmentService.registerShipment(shipment);

    }

    @GetMapping("/shipment/{id}")
    public ResponseEntity<Shipment> getOneUser(@PathVariable("id") Long id) {
        Shipment shipment= shipmentService.getById(id);
        return  ResponseEntity.ok(shipment);
    }

    @GetMapping("/shipments/{id}")
    public ResponseEntity<String> getOnestatus(@PathVariable("id") Long id) {
        String status= String.valueOf(shipmentService.getById(id).getStatus());
        return  ResponseEntity.ok(status);
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Shipment shipment = shipmentService.getById(id);
        model.addAttribute("employee", shipment);
        return "update";
    }



    @PatchMapping (value = "/updateShipment/{id}")
    public ResponseEntity<HttpStatus> updateShipment(@RequestBody Shipment shipment, @PathVariable("id") Long id) {
        shipmentService.update(shipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/{id}/events")
//    public ResponseEntity<?> addShipmentEvent(@PathVariable String id, @RequestBody ShipmentEvent event) {
//        // Логика добавления события в историю отправления
//    }
//@PatchMapping ("/{id}")
//public ResponseEntity<?> getShipmentStatus(@PathVariable String id) {
//    // Логика получения статуса отправления
//}

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        shipmentService.deleteViaId(id);
        return "redirect:/";
    }
//    @GetMapping(value  ="/status/{id}")
//    public ResponseEntity<Status> getShipStatusById(@RequestBody Status status,@RequestParam("id") Long id) {
//        status = shipmentService.getStatus(id);
//       // return new ResponseEntity<>(HttpStatus.OK);
//        return ResponseEntity.ok(status);
//
//
//        }
@GetMapping("/{id}/status")// лишнее !!!!!1
public ResponseEntity<String> getRecipientName(@PathVariable("id") long id) {
    String recipientName = String.valueOf(shipmentService.getRecipientName(id));
    return ResponseEntity.ok(recipientName);
}
//   @GetMapping
//    public ResponseEntity<ShipmentHistory> getShipmentHistory(@PathVariable String id) {
//        ShipmentHistory history = shipmentService.getShipmentHistory(id);
//        return ResponseEntity.ok(history);
//    }

//    @GetMapping("/{id}/history")
//    public ResponseEntity<?> getShipmentHistory(@PathVariable String id) {
//        // Логика получения истории передвижения отправления
//    }
}


/*   @GetMapping("/users/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {//UsDTO usrDt
        //userService.addUser(userService.convertToUser(userDto));
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

*/

