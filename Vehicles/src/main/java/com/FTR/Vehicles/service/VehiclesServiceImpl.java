package com.FTR.Vehicles.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.FTR.Vehicles.dto.Message;
import com.FTR.Vehicles.dto.VehiclesDTO;
import com.FTR.Vehicles.exception.ExceptionConstants;
import com.FTR.Vehicles.exception.ServiceException;
import com.FTR.Vehicles.model.Vehicles;
import com.FTR.Vehicles.repo.VehiclesRepo;
import com.FTR.Vehicles.utility.VehicleStatusEnum;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service()
public class VehiclesServiceImpl implements VehiclesService {

    @Autowired
    private VehiclesRepo repo;

    @Autowired
    private MessageSource messageSource;

    // private final String VEHICLE_CREATE_SUCCESS = messageSource.getMessage("vehicle.create.success", null, Locale.ENGLISH);

    @Override
    public Message insertNewVehicle(VehiclesDTO dto) throws ServiceException{
        
        // Add WorkItem FeignClient implementation

        Boolean response = repo.findById(dto.getVehicleNumber()).isPresent();
		if(response) {
			throw new ServiceException(ExceptionConstants.VEHICLE_ALREADY_EXISTS.toString());
		}
    
        repo.save(VehiclesDTO.createEntity(dto));
        // return new Message("VEHICLE_CREATE_SUCCESS");
        return new Message(messageSource.getMessage("vehicle.create.success", null, Locale.ENGLISH));
    }

    @Override
    public List<VehiclesDTO> fetchAvailableVehicles() throws ServiceException {
        
        List<Vehicles> entityList = repo.findAll();
        
        if(entityList.isEmpty()){
            throw new ServiceException(ExceptionConstants.VEHICLE_NOT_FOUND.toString());
        }
        List<VehiclesDTO> dtoList = entityList.stream()
                                    .map(Vehicles::createDTO)
                                    .collect(Collectors.toList());
        
        return dtoList;
    }

    @Override
    public List<VehiclesDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws ServiceException {
        List<Vehicles> entityList = repo.findByVehicleName(vehicleName);
        if(entityList.isEmpty())
            throw new ServiceException(ExceptionConstants.VEHICLE_NOT_FOUND.toString());
        List<VehiclesDTO> dtoList = entityList.stream()
                                    .map(Vehicles::createDTO)
                                    .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public VehiclesDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws ServiceException {
        Optional<Vehicles> entityOpt = repo.findById(vehicleNumber);
        if(entityOpt.isEmpty())
            throw new ServiceException(ExceptionConstants.VEHICLE_NOT_FOUND.toString());
        return Vehicles.createDTO(entityOpt.get());
    }

    @Override
    public Message updateVehicleStatus(String vehicleNum, VehiclesDTO dto) throws ServiceException {
        Optional<Vehicles> entityOpt = repo.findById(vehicleNum);
        if(entityOpt.isEmpty())
            throw new ServiceException(ExceptionConstants.VEHICLE_NOT_FOUND.toString());

        if(entityOpt.get().getVehicleStatus().equals(dto.getVehicleStatus()))
            throw new ServiceException(ExceptionConstants.VEHICLE_UPDATE_ALREADY_EXISTS.toString()+" "+dto.getVehicleStatus());

        List<String> allowedStatusValues = Stream.of(VehicleStatusEnum.class.getEnumConstants())
                                    .map(Object::toString)
                                    .collect(Collectors.toList());
        if(!allowedStatusValues.contains(dto.getVehicleStatus()))
            throw new ServiceException(ExceptionConstants.VEHICLE_STATUS_INVALID.toString());

        Vehicles entity = entityOpt.get();
        entity.setVehicleStatus(dto.getVehicleStatus());
        repo.saveAndFlush(entity);
        
        return new Message(messageSource.getMessage("vehicle.update.success", null, Locale.ENGLISH)+" "+dto.getVehicleStatus());
    }

    @Override
    public Message removeVehicle(String vehicleNum) throws ServiceException, Exception {
        Optional<Vehicles> entityOpt = repo.findById(vehicleNum);
        if(entityOpt.isEmpty())
            throw new ServiceException(ExceptionConstants.VEHICLE_NOT_FOUND.toString());
        
        repo.delete(entityOpt.get());
        return new Message(messageSource.getMessage("vehicle.delete.success", null, Locale.ENGLISH));
    }

    @Override
    public List<VehiclesDTO> fetchVehicleByHarbor(String harborLocation) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
