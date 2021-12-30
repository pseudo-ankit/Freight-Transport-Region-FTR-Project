package com.FTR.Terminals.controller;

import java.util.List;

import javax.validation.Valid;

import com.FTR.Terminals.dto.Message;
import com.FTR.Terminals.dto.TerminalDTO;
import com.FTR.Terminals.exception.ServiceException;
import com.FTR.Terminals.service.TerminalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(value="/ftr/terminals")
public class TerminalController {

    @Autowired
    private TerminalService service;

    @GetMapping()
    ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws ServiceException {
        List<TerminalDTO> response = service.fetchFTRTerminals();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("fetchTerminalByItemType/{itemType}")
    ResponseEntity<List<TerminalDTO>> fetchTerminalByItemType(@PathVariable String itemType) throws ServiceException {
        List<TerminalDTO> response = service.fetchTerminalsByItemType(itemType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value="fetchTerminalByTerminalId/{terminalId}")
    public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable String terminalId) throws ServiceException {
        TerminalDTO response = service.fetchFTRTerminalByTerminalId(terminalId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TerminalDTO> insertNewTerminal(@RequestBody @Valid TerminalDTO terminalDTO) throws ServiceException {
        TerminalDTO response = service.insertNewTerminal(terminalDTO);
        // CALL TO WORKITEMS MS
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<Message> updateTerminal(@PathVariable String terminalId,@PathVariable Integer newCapacity) throws ServiceException{
        Message response = service.updateTerminal(terminalId, newCapacity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{terminalId}")
    ResponseEntity<Message> removeTerminal(@PathVariable("terminalId") String terminalId) throws ServiceException {
        Message response = service.removeTerminal(terminalId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
