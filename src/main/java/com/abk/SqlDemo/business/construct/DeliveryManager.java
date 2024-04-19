package com.abk.SqlDemo.business.construct;

import com.abk.SqlDemo.entities.Delivery;

import com.abk.SqlDemo.dataAccess.abstracts.DeliveryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryManager {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryManager(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getByID(int id){
        return deliveryRepository.findById(id).orElse(null);
    }
    
}
