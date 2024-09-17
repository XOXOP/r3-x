package com.example.r3.projection;

import com.example.r3.entity.Shipment;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public interface Employee {
    @Value("#{target.recipientName}")
   String getRecipientName();

    @Value("#{target.recipientIndex}")
     Long getRecipientIndex();

//    @Value("#{target.recipientAddress + '& ' + target.recipientName}")
//    String getFullName();



}
