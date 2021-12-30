package com.FTR.User.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.FTR.User.dto.LoginDTO;
import com.FTR.User.dto.Message;
import com.FTR.User.dto.UserDTO;
import com.FTR.User.exception.ServiceException;
import com.FTR.User.service.UserService;

@RestController
@RequestMapping("/ftr/userProfile")
public class UserController {
	
	@Autowired
	private UserService userService; 

	@GetMapping("/test")
	public ResponseEntity<String> testWorking() {
		return new ResponseEntity<>("Ok working fine!", HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable int userId) throws ServiceException {
		return new ResponseEntity<>(
							userService.getUser(userId), HttpStatus.OK);
	}

	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO dto){
		UserDTO userDTO = userService.createUser(dto);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Message> updateUserProfile(@PathVariable int userId,  
													 @RequestBody @Valid UserDTO userDto)
														throws ServiceException{
		Message message = userService.updateUser(userId, userDto);
		
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Message> deleteUser(@PathVariable int userId) throws ServiceException {
	
		return new ResponseEntity<>(userService.deleteUser(userId), 
									HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Message> login(@RequestBody @Valid LoginDTO logindto) throws ServiceException {
		System.out.println(logindto.getUserId()+"-----"+logindto.getPassword());
		return new ResponseEntity<>(userService.login(logindto.getUserId(), logindto.getPassword()),
				HttpStatus.OK);
	}
	
}
