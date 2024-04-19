package com.abk.SqlDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abk.SqlDemo.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer>{

}
