package com.FTR.Vehicles.exception;

public enum ExceptionConstants {

    VEHICLE_NOT_FOUND("vehicle.notFound"),
	VEHICLE_ALREADY_EXISTS("vehicle.alreadyexists"),
	VEHICLE_UPDATE_ALREADY_EXISTS("vehicle.update.alreadyexists"),
	VEHICLE_STATUS_INVALID("vehicle.vehicleStatus.invalid"),
	SERVER_ERROR("general.exception");
	
    private final String type;
	
	
	private ExceptionConstants(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
