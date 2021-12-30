package com.FTR.Vehicles.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.FTR.Vehicles.model.Vehicles;
import com.FTR.Vehicles.utility.DoubleIntegerValidation;
import com.FTR.Vehicles.utility.EnumValidator;
import com.FTR.Vehicles.utility.VehicleStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.modelmapper.ModelMapper;

public class VehiclesDTO {

    @NotNull(message = "{vehicle.vehicleNumber.must}")
    @Pattern(regexp = "(([A-Za-z]{2})[0-9]{4})", message = "{vehicle.vehicleNumber.invalid}")
    private String vehicleNumber;

    @NotNull(message = "{vehicle.vehicleName.must}")
    @Size(max = 25, message = "{vehicle.vehicleName.invalid}")
    @Pattern(regexp = "(?i)(Tower crane|FirePlace Crane|Double treadwheel Crane|Crawler Crane|Aerial Crane|Deck Crane)", message = "{vehicle.vehicleName.invalid}")
    private String vehicleName;

    @NotNull(message = "{vehicle.maxLiftingCapacity.must}")
    @DoubleIntegerValidation(message = "{vehicle.maxLiftingCapacity.invalid}") // message = "{vehicle.maxLiftingCapacity.invalid}"
    private double maxLiftingCapacity;

    @NotNull(message = "{vehicle.retireDate.must}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date retireDate;

    @NotNull(message = "{vehicle.vehicleStatus.must}")
    @EnumValidator(enumClass = VehicleStatusEnum.class, message = "{vehicle.vehicleStatus.invalid}")
    private String vehicleStatus;
    private String harborLocation;
    private String country;


    public VehiclesDTO() {
    }

    public VehiclesDTO(String vehicleNumber, String vehicleName, long maxLiftingCapacity, Date retireDate, String vehicleStatus, String harborLocation, String country) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.retireDate = retireDate;
        this.vehicleStatus = vehicleStatus;
        this.harborLocation = harborLocation;
        this.country = country;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return this.vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getMaxLiftingCapacity() {
        return this.maxLiftingCapacity;
    }

    public void setMaxLiftingCapacity(double maxLiftingCapacity) {
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    public Date getRetireDate() {
        return this.retireDate;
    }

    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    public String getVehicleStatus() {
        return this.vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getHarborLocation() {
        return this.harborLocation;
    }

    public void setHarborLocation(String harborLocation) {
        this.harborLocation = harborLocation;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public VehiclesDTO vehicleNumber(String vehicleNumber) {
        setVehicleNumber(vehicleNumber);
        return this;
    }

    public VehiclesDTO vehicleName(String vehicleName) {
        setVehicleName(vehicleName);
        return this;
    }

    public VehiclesDTO maxLiftingCapacity(long maxLiftingCapacity) {
        setMaxLiftingCapacity(maxLiftingCapacity);
        return this;
    }

    public VehiclesDTO retireDate(Date retireDate) {
        setRetireDate(retireDate);
        return this;
    }

    public VehiclesDTO vehicleStatus(String vehicleStatus) {
        setVehicleStatus(vehicleStatus);
        return this;
    }

    public VehiclesDTO harborLocation(String harborLocation) {
        setHarborLocation(harborLocation);
        return this;
    }

    public VehiclesDTO country(String country) {
        setCountry(country);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleNumber='" + getVehicleNumber() + "'" +
            ", vehicleName='" + getVehicleName() + "'" +
            ", maxLiftingCapacity='" + getMaxLiftingCapacity() + "'" +
            ", retireDate='" + getRetireDate() + "'" +
            ", vehicleStatus='" + getVehicleStatus() + "'" +
            ", harborLocation='" + getHarborLocation() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }

    public static Vehicles createEntity(VehiclesDTO dto){
        ModelMapper mapper = new ModelMapper();
        Vehicles entity = mapper.map(dto, Vehicles.class);
        return entity;
    }

}
