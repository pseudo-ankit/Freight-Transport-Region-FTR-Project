package com.FTR.Vehicles.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.FTR.Vehicles.dto.VehiclesDTO;

import org.modelmapper.ModelMapper;

@Entity
@Table(name = " ftr_vehicles")
public class Vehicles {
    
    @Id
    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "max_lifting_capacity")
    private double maxLiftingCapacity;

    @Column(name = "retire_date")
    private Date retireDate;

    @Column(name = "vehicle_status")
    private String vehicleStatus;

    @Column()
    private String harborLocation;

    @Column(name = "country")
    private String country;


    public Vehicles() {
    }

    public Vehicles(String vehicleNumber, String vehicleName, long maxLiftingCapacity, Date retireDate, String vehicleStatus, String harborLocation, String country) {
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

    public Vehicles vehicleNumber(String vehicleNumber) {
        setVehicleNumber(vehicleNumber);
        return this;
    }

    public Vehicles vehicleName(String vehicleName) {
        setVehicleName(vehicleName);
        return this;
    }

    public Vehicles maxLiftingCapacity(long maxLiftingCapacity) {
        setMaxLiftingCapacity(maxLiftingCapacity);
        return this;
    }

    public Vehicles retireDate(Date retireDate) {
        setRetireDate(retireDate);
        return this;
    }

    public Vehicles vehicleStatus(String vehicleStatus) {
        setVehicleStatus(vehicleStatus);
        return this;
    }

    public Vehicles harborLocation(String harborLocation) {
        setHarborLocation(harborLocation);
        return this;
    }

    public Vehicles country(String country) {
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
    
    public static VehiclesDTO createDTO(Vehicles entity){
        ModelMapper mapper = new ModelMapper();
        VehiclesDTO dto = mapper.map(entity, VehiclesDTO.class);
        return dto;
    }
}
