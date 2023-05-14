package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOEntity(PropertyDTO propertyDTO){

        PropertyEntity pe=new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }
    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){
            PropertyDTO propertyDTO=new PropertyDTO();
            propertyDTO.setId(propertyDTO.getId());
            propertyDTO.setTitle(propertyDTO.getTitle());
            propertyDTO.setDescription(propertyDTO.getDescription());
            propertyDTO.setAddress(propertyDTO.getAddress());
            propertyDTO.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyDTO.setOwnerName(propertyDTO.getOwnerName());
            propertyDTO.setPrice(propertyDTO.getPrice());

            return propertyDTO;
    }
}
