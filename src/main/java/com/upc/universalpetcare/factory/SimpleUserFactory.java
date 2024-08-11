package com.upc.universalpetcare.factory;

import org.springframework.stereotype.Component;

import com.upc.universalpetcare.exception.UserAlreadyExistsException;
import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.repository.UserRepository;
import com.upc.universalpetcare.request.RegistrationRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory {

	private final UserRepository userRepository;

	private final VeterinarianFactory veterinarianFactory;
	private final PatientFactory patientFactory;
	private final AdminFactory adminFactory;

	@Override
	public User createUser(RegistrationRequest registrationRequest) {
		// User Already Exists
		if (userRepository.existsByEmail(registrationRequest.getEmail())) {
			throw new UserAlreadyExistsException("Oops! " + registrationRequest.getEmail() + " already exists!");
		}

		// User Not Exists
		switch (registrationRequest.getUserType()) {
			case "VET" -> {
				return veterinarianFactory.createVeterinarian(registrationRequest);
			}
			case "PATIENT" -> {
				return patientFactory.createPatient(registrationRequest);
			}
			case "ADMIN" -> {
				return adminFactory.createAdmin(registrationRequest);
			}
			default -> {
				return null;
			}
		}

		
	}
}
