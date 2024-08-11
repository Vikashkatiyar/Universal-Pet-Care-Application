package com.upc.universalpetcare.factory;

import org.springframework.stereotype.Service;

import com.upc.universalpetcare.model.Patient;
import com.upc.universalpetcare.repository.PatientRepository;
import com.upc.universalpetcare.request.RegistrationRequest;
import com.upc.universalpetcare.service.user.UserAttributesMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientFactory {
	
	private final PatientRepository patientRepository;
	private final UserAttributesMapper userAttributesMapper;

	public Patient createPatient(RegistrationRequest registrationRequest) {
		Patient patient = new Patient();
		userAttributesMapper.setCommonAttributes(registrationRequest, patient);
		
		return patientRepository.save(patient);
	}
}
