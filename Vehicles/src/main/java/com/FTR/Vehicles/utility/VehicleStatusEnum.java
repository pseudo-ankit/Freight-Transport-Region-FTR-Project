package com.FTR.Vehicles.utility;

public enum VehicleStatusEnum {
    
	ACTIVE("Active"),
	RETIRED("Retired"),
	INPROGRESS("InProgress");
	
	private final String value;

	VehicleStatusEnum(String string) {
		// TODO Auto-generated constructor stub
		this.value = string;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
