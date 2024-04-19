package com.abk.SqlDemo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import com.abk.SqlDemo.entities.Delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import lombok.AllArgsConstructor;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;  
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/api/delivery")
@AllArgsConstructor
public class DeliveryController {
    
    final String DB_URL = "jdbc:h2:~/test";  
    final String USER = "sa"; 
    final String PASS = ""; 
    
    @GetMapping("/{id}")
    public String getDelivery(ModelMap mapper,@PathVariable String id) {
        
 
        Connection conn = null; 
        Statement stmt = null;
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM DELIVERY WHERE DELIVERYID = "+id+";");
            System.out.println(rs.getMetaData());
            while(rs.next()){
                Delivery tmp = new Delivery();
                tmp.setId(rs.getInt("deliveryid"));
                tmp.setDestination(rs.getString("destination"));
                tmp.setDestinationAddress(rs.getString("destinationaddress"));
                tmp.setSender(rs.getString("sender"));
                tmp.setSenderAddress(rs.getString("senderaddress"));
                tmp.setRecipient(rs.getString("recipient"));
                tmp.setRecipientAddress(rs.getString("recipientaddress"));
                tmp.setDeliveryDate(rs.getDate("deliverydate").toLocalDate());
                tmp.setStatus(rs.getString("status"));
                tmp.setCurrentLocation(rs.getString("currentlocation"));
                System.out.println(tmp.getId());
                deliveries.add(tmp);               
            }
            stmt.close(); 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        mapper.put("data", deliveries);
        if (deliveries.size()==0) {
            return "notFound";
        }
        return "showDelivery";
    }

    @GetMapping("/secure/{id}")
    public String getDeliverySecure(ModelMap mapper,@PathVariable String id) {
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        Connection conn = null; 
        System.out.println(id);
        try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String query = "SELECT * FROM DELIVERY WHERE DELIVERYID = ?";
            PreparedStatement pstmt = conn.prepareStatement( query );
            pstmt.setString( 1, id);
            ResultSet rs = pstmt.executeQuery();
            try {
                
                while(rs.next()){
                    Delivery tmp = new Delivery();
                    tmp.setId(rs.getInt("deliveryid"));
                    tmp.setDestination(rs.getString("destination"));
                    tmp.setDestinationAddress(rs.getString("destinationaddress"));
                    tmp.setSender(rs.getString("sender"));
                    tmp.setSenderAddress(rs.getString("senderaddress"));
                    tmp.setRecipient(rs.getString("recipient"));
                    tmp.setRecipientAddress(rs.getString("recipientaddress"));
                    tmp.setDeliveryDate(rs.getDate("deliverydate").toLocalDate());
                    tmp.setStatus(rs.getString("status"));
                    tmp.setCurrentLocation(rs.getString("currentlocation"));
                    System.out.println(tmp.getId());
                    deliveries.add(tmp);               
                }
                pstmt.close(); 
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }  
        }catch(Exception e){

        }

        mapper.put("data", deliveries);
        if (deliveries.size()==0) {
            return "notFound";
        }
        return "showDelivery";

    }   
    @PostMapping("/")
    public String getIDbyPost(@ModelAttribute int id,Model model){
        model.addAttribute("id",id);
        return "redirect:/"+id;        
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
}
