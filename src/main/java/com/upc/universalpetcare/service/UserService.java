package com.upc.universalpetcare.service;

import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public void add(User user) {
        userRepository.save(user);
    }
}
