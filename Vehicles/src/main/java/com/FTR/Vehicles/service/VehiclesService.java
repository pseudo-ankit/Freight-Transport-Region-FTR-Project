package com.FTR.Vehicles.service;

import java.util.List;

import com.FTR.Vehicles.dto.Message;
import com.FTR.Vehicles.dto.VehiclesDTO;
import com.FTR.Vehicles.exception.ServiceException;


public interface VehiclesService {
    public Message insertNewVehicle(VehiclesDTO dto) throws ServiceException;

    public List<VehiclesDTO> fetchAvailableVehicles() throws ServiceException;

    public List<VehiclesDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws ServiceException;
	
	public VehiclesDTO  fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws ServiceException;
	
	public Message updateVehicleStatus(String vehicleNum, VehiclesDTO dto) throws ServiceException;
	
	public Message removeVehicle(String vehicleNum) throws ServiceException, Exception;
	
	public List<VehiclesDTO> fetchVehicleByHarbor(String harborLocation) throws ServiceException;
}