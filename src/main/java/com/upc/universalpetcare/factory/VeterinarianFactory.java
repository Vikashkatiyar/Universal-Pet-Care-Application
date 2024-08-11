package com.upc.universalpetcare.factory;

import org.springframework.stereotype.Service;

import com.upc.universalpetcare.model.Veterinarian;
import com.upc.universalpetcare.repository.VeterinarianRepository;
import com.upc.universalpetcare.request.RegistrationRequest;
import com.upc.universalpetcare.service.user.UserAttributesMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeterinarianFactory {
	
	private final VeterinarianRepository veterinarianRepository;
	private final UserAttributesMapper userAttributesMapper;
	

	public Veterinarian createVeterinarian(RegistrationRequest registrationRequest) {
		Veterinarian veterinarian = new Veterinarian();
		userAttributesMapper.setCommonAttributes(registrationRequest, veterinarian);
		veterinarian.setSpecialization(registrationRequest.getSpecialization());
		return veterinarianRepository.save(veterinarian);
	}
}
