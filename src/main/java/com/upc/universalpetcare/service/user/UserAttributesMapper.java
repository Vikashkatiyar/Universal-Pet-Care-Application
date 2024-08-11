package com.upc.universalpetcare.service.user;

import org.springframework.stereotype.Component;

import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.request.RegistrationRequest;

@Component
public class UserAttributesMapper {

    public void setCommonAttributes(RegistrationRequest source, User target){
    	target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setEnabled(source.isEnabled());
        target.setUserType(source.getUserType());
            
    }
}
