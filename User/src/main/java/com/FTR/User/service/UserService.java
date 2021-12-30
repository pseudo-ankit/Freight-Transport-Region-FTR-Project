package com.FTR.User.service;

import com.FTR.User.dto.Message;
import com.FTR.User.dto.UserDTO;
import com.FTR.User.exception.ServiceException;

public interface UserService {

	public UserDTO createUser( UserDTO dto);
	public Message updateUser(int userId,  UserDTO userDto) throws ServiceException;
	public Message deleteUser( int userId) throws ServiceException;
	public UserDTO getUser(int userId) throws ServiceException ;
	public Message login( int userId,  String password) throws ServiceException ;
}
