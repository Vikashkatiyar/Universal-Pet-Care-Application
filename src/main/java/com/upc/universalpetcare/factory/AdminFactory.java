package com.upc.universalpetcare.factory;

import org.springframework.stereotype.Service;

import com.upc.universalpetcare.model.Admin;
import com.upc.universalpetcare.repository.AdminRepository;
import com.upc.universalpetcare.request.RegistrationRequest;
import com.upc.universalpetcare.service.user.UserAttributesMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminFactory {
	
	private final AdminRepository adminRepository;
	private final UserAttributesMapper userAttributesMapper;

	public Admin createAdmin(RegistrationRequest registrationRequest) {
		Admin admin = new Admin();
		userAttributesMapper.setCommonAttributes(registrationRequest, admin);
		return adminRepository.save(admin);
	}
}
