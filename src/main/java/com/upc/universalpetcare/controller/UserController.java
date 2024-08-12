package com.upc.universalpetcare.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upc.universalpetcare.dto.EntityConverter;
import com.upc.universalpetcare.dto.UserDto;
import com.upc.universalpetcare.exception.ResourceNotFoundException;
import com.upc.universalpetcare.exception.UserAlreadyExistsException;
import com.upc.universalpetcare.model.User;
import com.upc.universalpetcare.request.RegistrationRequest;
import com.upc.universalpetcare.request.UserUpdateRequest;
import com.upc.universalpetcare.response.ApiResponse;
import com.upc.universalpetcare.service.user.IUserService;
import com.upc.universalpetcare.service.user.UserService;
import com.upc.universalpetcare.utils.FeedBackMessage;
import com.upc.universalpetcare.utils.UrlMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(UrlMapping.USERS)
@RestController
public class UserController {

    private final UserService userService;
    private final IUserService iUserService;
    private final EntityConverter<User, UserDto> entityConverter;

   @PostMapping(UrlMapping.REGISTER_USER)
   public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request){
       try {
		  User theUser = iUserService.register(request);
		  UserDto registeredUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
		  return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registeredUser));
		  
		} catch (UserAlreadyExistsException e) {
		   return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), null));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
		}
   }
   
   @PutMapping(UrlMapping.UPDATE_USER)
   public ResponseEntity<ApiResponse> update(@PathVariable Long userId,@RequestBody UserUpdateRequest request){
	
	   try {
		   User theUser = iUserService.update(userId, request);
		   UserDto updatedUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
		   return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS, updatedUser));
		   
		} catch (ResourceNotFoundException e) {
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
		}  
   }
   
   @GetMapping(UrlMapping.GET_USER_BY_ID)
   public ResponseEntity<ApiResponse> findById(@PathVariable Long userId) {
	   try {
		     User user = iUserService.findById(userId);
		     UserDto theUser = entityConverter.mapEntityToDto(user, UserDto.class);
		     return ResponseEntity.status(HttpStatus.FOUND).body(new ApiResponse(FeedBackMessage.FOUND, theUser));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
		}
   }
   
   @DeleteMapping(UrlMapping.DELETE_USER_BY_ID)
   public ResponseEntity<ApiResponse> deleteById(@PathVariable Long userId){
	   try {
			iUserService.delete(userId);
			return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DELETE_SUCCESS, userId));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
			
		}
   }
   
   @GetMapping(UrlMapping.GET_ALL_USERS)
   public ResponseEntity<ApiResponse> getAllUsers(){
	   List<UserDto> allUsers = iUserService.getAllUsers();
	   return ResponseEntity.status(HttpStatus.FOUND).body(new ApiResponse(FeedBackMessage.SUCCESS, allUsers));
   }
   
   
   
}
