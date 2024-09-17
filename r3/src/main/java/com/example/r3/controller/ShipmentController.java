package com.example.r3.controller;
import com.example.r3.projection.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.r3.entity.Shipment;
import com.example.r3.servic.ShipmentService;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


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
        return shipmentService.registerShipment(shipment);

    }

    @GetMapping("/shipment/{id}")
    public ResponseEntity<Shipment> getOneUser(@PathVariable("id") Long id) {
        Shipment shipment = shipmentService.getById(id);
        return ResponseEntity.ok(shipment);
    }

    @GetMapping("/shipments/{id}")
    public ResponseEntity<String> getOnestatus(@PathVariable("id") Long id) {
        String status = String.valueOf(shipmentService.getById(id).getStatus());
        return ResponseEntity.ok(status);
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Shipment shipment = shipmentService.getById(id);
        model.addAttribute("employee", shipment);
        return "update";
    }


    @PatchMapping(value = "/updateShipment/{id}")
    public ResponseEntity<HttpStatus> updateShipment(@RequestBody Shipment shipment, @PathVariable("id") Long id) {
        shipmentService.update(shipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        shipmentService.deleteViaId(id);
        return "redirect:/";
    }


    @GetMapping("/{id}/status")// лишнее !!!!!1
    public ResponseEntity<String> getStatus(@PathVariable("id") long id) {
        String status = String.valueOf(shipmentService.getRecipientName(id));
        return ResponseEntity.ok(status);
    }

    @GetMapping("/{recipientName}/loop")
    public @ResponseBody List<Shipment> getbyName(@PathVariable("recipientName") String recipientName) {
        List<Shipment> shipmentList = shipmentService.findsByName(recipientName);
        return ResponseEntity.ok(shipmentList).getBody();
    }

    @GetMapping("/employe/{recipientName}")
    public ResponseEntity<?> getEmployee(@PathVariable("recipientName") String recipientName){

        List<Employee> emplist= shipmentService.emplist( recipientName);

        Map<String, Long> shipmentMap = new HashMap<>();
        for (Employee emp: emplist
             ) {shipmentMap.put(emp.getRecipientName(), emp.getRecipientIndex() );

        }
        Map<String, Long> filteredAndSortedMap = shipmentMap.entrySet().stream().filter(e ->
                e.getValue() > 30000).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())
        ).collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry ::getValue, (a, b) -> a,
                LinkedHashMap :: new));


       return ResponseEntity.ok(filteredAndSortedMap);

       // public Map<String, Integer> parseJsonToMap(String json) throws Exception {
//            Function<String, Integer > keyMapper = v -> Integer.valueOf((v instanceof String) ? "even" : "odd");
//        Function<Integer, List<Integer>> valueMapper = v -> List.of(v);
//        BinaryOperator<List<Integer>> mergeFunction = (v, y) -> {
//            List<Integer> rezult = new ArrayList<>(v);
//            rezult.addAll(y);
//            return rezult;
//        };



   }
}