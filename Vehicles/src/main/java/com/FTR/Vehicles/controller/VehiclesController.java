package com.FTR.Vehicles.controller;


import java.util.List;

import javax.validation.Valid;

import com.FTR.Vehicles.dto.Message;
import com.FTR.Vehicles.dto.VehiclesDTO;
import com.FTR.Vehicles.exception.ServiceException;
import com.FTR.Vehicles.service.VehiclesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/ftr/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService service;

    @PostMapping(value = "")
    ResponseEntity<Message> insertNewVehicle(@RequestBody @Valid VehiclesDTO dto) throws ServiceException{
        Message message = service.insertNewVehicle(dto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value="")
    ResponseEntity<List<VehiclesDTO>> fetchAvailableVehicles() throws ServiceException {
        return new ResponseEntity<List<VehiclesDTO>>(service.fetchAvailableVehicles(), HttpStatus.OK);
    }

    @PutMapping(value = "/{vehicleNum}")
    ResponseEntity<Message> updateVehicleStatus(@PathVariable String vehicleNum, @RequestBody VehiclesDTO dto) throws ServiceException{
        return new ResponseEntity<>(service.updateVehicleStatus(vehicleNum, dto), HttpStatus.OK);
    }

    @GetMapping(value = "managed-name/{vehicleName}")
    ResponseEntity<List<VehiclesDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName) throws ServiceException{
        return new ResponseEntity<>(service.fetchVehicleDetailsByVehicleName(vehicleName), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{vehicleNumber}")
    ResponseEntity<Message> removeVehicle(@PathVariable("vehicleNumber") String vehicleNum)throws ServiceException, Exception{
        return new ResponseEntity<>(service.removeVehicle(vehicleNum), HttpStatus.OK);
    }

    @GetMapping(value = "managed-number/{vehicleNumber}")
    ResponseEntity<VehiclesDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws ServiceException{
        return new ResponseEntity<>(service.fetchVehicleDetailsByVehicleNumber(vehicleNumber), HttpStatus.OK);
    }
    
}
