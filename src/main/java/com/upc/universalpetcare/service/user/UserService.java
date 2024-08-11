package com.upc.universalpetcare.service.user;

import com.upc.universalpetcare.factory.UserFactory;
import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.repository.UserRepository;
import com.upc.universalpetcare.request.RegistrationRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;



    public User add(RegistrationRequest request) {
        return userFactory.createUser(request);
    }
}
