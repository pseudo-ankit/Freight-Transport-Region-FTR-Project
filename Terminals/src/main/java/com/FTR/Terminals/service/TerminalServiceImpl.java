package com.FTR.Terminals.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import com.FTR.Terminals.dto.Message;
import com.FTR.Terminals.dto.TerminalDTO;
import com.FTR.Terminals.exception.ExceptionConstants;
import com.FTR.Terminals.exception.ServiceException;
import com.FTR.Terminals.model.Terminal;
import com.FTR.Terminals.repo.TerminalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalRepo repo;

    @Autowired
    MessageSource messageSource;

    @Override
    public List<TerminalDTO> fetchFTRTerminals() throws ServiceException {
        List<Terminal> entityList = repo.findAll();

        if(entityList.isEmpty())
            throw new ServiceException(messageSource.getMessage(ExceptionConstants.TERMINAL_NOTFOUND.toString(), null, Locale.ENGLISH));
        
        return entityList.stream()
                            .map(TerminalDTO::prepareDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws ServiceException {
        List<Terminal> entityList = repo.findByItemType(itemType);
        if(entityList.isEmpty())
            throw new ServiceException(messageSource.getMessage(ExceptionConstants.TERMINAL_ITEMTYPE_NOTFOUND.toString(), null, Locale.ENGLISH));
        return entityList.stream()
                        .map(TerminalDTO::prepareDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO) throws ServiceException {
        
        Optional<Terminal> entityOpt = repo.findById(terminalDTO.getTerminalId());
        if(entityOpt.isPresent())
            throw new ServiceException(messageSource.getMessage(ExceptionConstants.TERMINAL_ALREADY_EXISTS.toString(), null, Locale.ENGLISH));

        Terminal entity = repo.save(TerminalDTO.prepareEntity(terminalDTO));
        return TerminalDTO.prepareDTO(entity);
    }

    @Override
    public Message updateTerminal(String terminalId, Integer newCapacity) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws ServiceException {
        Optional<Terminal> entityOpt = repo.findById(terminalId);
        
        if(entityOpt.isEmpty())
        throw new ServiceException(messageSource.getMessage(ExceptionConstants.TERMINAL_NOTFOUND.toString(), null, Locale.ENGLISH)+" "+terminalId);

        return TerminalDTO.prepareDTO(entityOpt.get());
    }

    @Override
    public Message removeTerminal(String terminalId) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
