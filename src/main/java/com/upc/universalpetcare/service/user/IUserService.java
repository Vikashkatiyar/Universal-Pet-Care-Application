package com.upc.universalpetcare.service.user;

import java.util.List;

import com.upc.universalpetcare.dto.UserDto;
import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.request.RegistrationRequest;
import com.upc.universalpetcare.request.UserUpdateRequest;

public interface IUserService {

	User register(RegistrationRequest request);
    User update(Long userId, UserUpdateRequest request);
	User findById(Long userId);
	void delete(Long userId);
	List<UserDto> getAllUsers();
}
