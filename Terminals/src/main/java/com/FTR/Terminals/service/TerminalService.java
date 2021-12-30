package com.FTR.Terminals.service;

import java.util.List;

import com.FTR.Terminals.dto.Message;
import com.FTR.Terminals.dto.TerminalDTO;
import com.FTR.Terminals.exception.ServiceException;

public interface TerminalService {

    List<TerminalDTO> fetchFTRTerminals() throws ServiceException;
    List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws ServiceException;
    TerminalDTO  insertNewTerminal(TerminalDTO terminalDTO) throws ServiceException;
    Message updateTerminal(String terminalId, Integer newCapacity) throws ServiceException;
    TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws ServiceException;
    Message removeTerminal(String terminalId) throws ServiceException;
}
