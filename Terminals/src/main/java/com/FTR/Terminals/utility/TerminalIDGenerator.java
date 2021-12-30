package com.FTR.Terminals.utility;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TerminalIDGenerator implements IdentifierGenerator {
    private static int counter = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        int id = counter++;
        return id;
    }

    
    
}
