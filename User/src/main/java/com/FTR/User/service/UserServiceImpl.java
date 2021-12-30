package com.FTR.User.service;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.FTR.User.dto.Message;
import com.FTR.User.dto.UserDTO;
import com.FTR.User.exception.ServiceException;
import com.FTR.User.model.User;
import com.FTR.User.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public UserDTO createUser(UserDTO dto) {
//		System.out.println("-------Incoming DTO--------");
		System.out.println(dto);
		User entity = UserDTO.createEntity(dto);
//		System.out.println("-------Entity--------");
		System.out.println(entity);
		userRepo.save(entity);
		dto = User.createDTO(entity);
//		System.out.println("-------Outgoing DTO--------");
		System.out.println(dto);
		return dto;
	}

	@Override
	public Message updateUser(int userId, UserDTO userDto) throws ServiceException {
		
		Optional<User> userOpt = userRepo.findById(userId);
		
		if(userOpt.isPresent()) {
			Message mssg = new Message();
			User user = userOpt.get();
			user.setMobileNumber(userDto.getMobileNumber());
			user.setPermanentAddress(userDto.getPermanentAddress());
			user.setOfficeAddress(userDto.getOfficeAddress());
			userRepo.save(user);
			mssg.setMessage(messageSource.getMessage("user.update.success", null, Locale.ENGLISH)+userId);
			return mssg;
		}else {
			throw new ServiceException("user.notFound");
		}
	}

	@Override
	public Message deleteUser(int userId) throws ServiceException {
		Optional<User> userOpt = userRepo.findById(userId);
		
		if(userOpt.isPresent()) {
			Message mssg = new Message();
			userRepo.delete(userOpt.get());
			mssg.setMessage(messageSource.getMessage("user.delete.success", null, Locale.ENGLISH)+userId);
			return mssg;
		}else {
			throw new ServiceException("user.notFound");
		}
	}

	@Override
	public UserDTO getUser(int userId) throws ServiceException {
		Optional<User> userOpt = userRepo.findById(userId);
		
		if(userOpt.isPresent()) {
			return User.createDTO(userOpt.get());
		}else {
			throw new ServiceException("user.notFound");
		}
	}

	@Override
	public Message login(int userId, String password) throws ServiceException {
		Optional<User> userOpt = userRepo.findById(userId);
		System.out.println(userId+"---"+password);
		
		if( userOpt.isPresent() 
				&&
			password.equals(userOpt.get().getPassword())) {
			
			return new Message(messageSource.getMessage("user.login.success", null, Locale.ENGLISH));
		}
		else {
			return new Message(messageSource.getMessage("user.login.failure", null, Locale.ENGLISH));
		}
	}

}
