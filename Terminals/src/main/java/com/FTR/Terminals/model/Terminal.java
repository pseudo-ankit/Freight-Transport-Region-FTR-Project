package com.FTR.Terminals.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ftr_terminals")
public class Terminal {
    @Id
    @GenericGenerator(strategy = "com.FTR.Terminals.utility.TerminalIDGenerator", name = "terminalIdGenerator")
    @GeneratedValue(generator = "terminalIdGenerator")
    @Column(name = "terminal_id", columnDefinition = "varchar(20)")
    private String terminalId;

    @Column(name = "terminal_name", columnDefinition = "varchar(100)")
    private String terminalName;

    @Column(name = "country", columnDefinition = "varchar(30)")
    private String country;

    @Column(name = "item_type", columnDefinition = "varchar(100)")
    private String itemType;

    @Column(name = "terminal_description", columnDefinition = "varchar(25)")
    private String terminalDescription;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "available_capacity")
    private Integer availableCapacity;

    @Column(name = "status_code", columnDefinition = "varchar(200)")
    private String statusCode;

    @Column(name = "harbor_location", columnDefinition = "varchar(30)")
    private String harborLocation;



    public Terminal() {
    }

    public Terminal(String terminalId, String terminalName, String country, String itemType, 
            String terminalDescription, Integer capacity, Integer availableCapacity, String statusCode, String harborLocation) {
        this.terminalId = terminalId;
        this.terminalName = terminalName;
        this.country = country;
        this.itemType = itemType;
        this.terminalDescription = terminalDescription;
        this.capacity = capacity;
        this.availableCapacity = availableCapacity;
        this.statusCode = statusCode;
        this.harborLocation = harborLocation;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalName() {
        return this.terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTerminalDescription() {
        return this.terminalDescription;
    }

    public void setTerminalDescription(String terminalDescription) {
        this.terminalDescription = terminalDescription;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAvailableCapacity() {
        return this.availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getHarborLocation() {
        return this.harborLocation;
    }

    public void setHarborLocation(String harborLocation) {
        this.harborLocation = harborLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Terminal)) {
            return false;
        }
        Terminal terminal = (Terminal) o;
        return Objects.equals(terminalId, terminal.terminalId) && Objects.equals(terminalName, terminal.terminalName) && Objects.equals(country, terminal.country) && Objects.equals(itemType, terminal.itemType) && Objects.equals(terminalDescription, terminal.terminalDescription) && Objects.equals(capacity, terminal.capacity) && Objects.equals(availableCapacity, terminal.availableCapacity) && Objects.equals(statusCode, terminal.statusCode) && Objects.equals(harborLocation, terminal.harborLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminalId, terminalName, country, itemType, terminalDescription, capacity, availableCapacity, statusCode, harborLocation);
    }

    @Override
    public String toString() {
        return "{" +
            " terminalId='" + getTerminalId() + "'" +
            ", terminalName='" + getTerminalName() + "'" +
            ", country='" + getCountry() + "'" +
            ", itemType='" + getItemType() + "'" +
            ", terminalDescription='" + getTerminalDescription() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", availableCapacity='" + getAvailableCapacity() + "'" +
            ", status='" + getStatusCode() + "'" +
            ", harborLocation='" + getHarborLocation() + "'" +
            "}";
    }

}
