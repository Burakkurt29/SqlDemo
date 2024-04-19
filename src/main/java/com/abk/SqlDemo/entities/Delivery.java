package com.abk.SqlDemo.entities;

import java.time.LocalDate;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="delivery")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Delivery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
   
    @Column(name="destination")
    private String destination;
    
    @Column(name="destination_address")
    private String destinationAddress;
    
    @Column(name="sender")
    private String sender;
    
    @Column(name="sender_address")
    private String senderAddress;
    
    @Column(name="recipient")
    private String recipient;
    
    @Column(name="recipient_address")
    private String recipientAddress;
    
    @Column(name="delivery_date")
    private LocalDate deliveryDate;
    
    @Column(name="status")
    private String status;
    
    @Column(name="current_location")
    private String currentLocation;

}

