package com.FTR.Vehicles.repo;

import java.util.List;

import com.FTR.Vehicles.model.Vehicles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepo extends JpaRepository<Vehicles, String> {
    public List<Vehicles> findByVehicleName(String vehicleName);
	
	public List<Vehicles> findByHarborLocationAndVehicleStatus(String harborLocation, String status);
}
