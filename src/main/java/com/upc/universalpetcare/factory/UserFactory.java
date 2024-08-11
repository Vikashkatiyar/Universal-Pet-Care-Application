package com.upc.universalpetcare.factory;

import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.request.RegistrationRequest;

public interface UserFactory {
    public User createUser(RegistrationRequest registrationRequest);
}
