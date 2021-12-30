package com.FTR.User.utils;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {
	
	private static int counter=10006;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object)
			throws HibernateException {
		int id = counter++;
		return id;
	}	
}
