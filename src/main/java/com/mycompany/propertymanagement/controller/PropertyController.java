package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;


    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello Spring Boot";
    }

    //InsertData
    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }


    //GetAllData
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        // System.out.println(dummy);
        // System.out.println(dbUrl);
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    //GetAllDataForUserId
    @GetMapping("/properties/users/{userId}")
    public ResponseEntity<List<PropertyDTO>> getAllPropertiesForUser(@PathVariable("userId") Long userId){
        List<PropertyDTO> propertyList = propertyService.getAllPropertiesForUser(userId);
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    //UpdateData
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    //UpdateProperttyDescription
    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    //UpdateProperttyPrice
    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    //Deleted
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }




}
