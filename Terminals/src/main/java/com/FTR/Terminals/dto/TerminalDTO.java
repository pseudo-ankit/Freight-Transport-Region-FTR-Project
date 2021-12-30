package com.FTR.Terminals.dto;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.FTR.Terminals.model.Terminal;

import org.hibernate.validator.constraints.Length;

public class TerminalDTO {
    private String terminalId;

	@NotNull(message = "{terminal.terminalName.must}")
	@Length(min = 3, max = 20, message = "{terminal.terminalName.invalid}")
	private String terminalName;

	@NotNull(message = "{terminal.country.must}")
	@Length(min = 3, max = 20, message = "{terminal.country.invalid}")
	private String country;

	@NotNull(message = "{terminal.itemType.must}")
	@Length(min = 4, max = 30, message = "{terminal.itemType.invalid}")
	private String itemType;

	@NotNull(message = "{terminal.terminalDescription.must}")
	@Pattern(regexp = "^T[0-9]{1,3}[-][a-zA-Z\\s]+$", message = "{terminal.terminalDescription.invalid}")
	@Length(max = 25, message = "{terminal.terminalDescriptionLength.invalid}")
	private String terminalDescription;

	@NotNull(message = "{terminal.capacity.must}")
	@Max(value = 99999, message = "{terminal.capacity.invalid}")
	private Integer capacity;

	@NotNull(message = "{terminal.availableCapacity.must}")
	@Max(value = 99999, message = "{terminal.availableCapacity.invalid}")
	private Integer availableCapacity;

	@NotNull(message = "{terminal.status.must}")
	@Pattern(regexp = "^(Available|NotAvailable)$", message = "{terminal.status.invalid}")
	private String statusCode;

	@NotNull(message = "{terminal.harborLocation.must}")
	@Length(min = 5, max = 25, message = "{terminal.harborLocation.invalid}")
	private String harborLocation;


    public TerminalDTO() {
    }

    public TerminalDTO(String terminalId, String terminalName, String country, String itemType, String terminalDescription, Integer capacity, Integer availableCapacity, String statusCode, String harborLocation) {
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
        if (!(o instanceof TerminalDTO)) {
            return false;
        }
        TerminalDTO terminalDTO = (TerminalDTO) o;
        return Objects.equals(terminalId, terminalDTO.terminalId) && Objects.equals(terminalName, terminalDTO.terminalName) && Objects.equals(country, terminalDTO.country) && Objects.equals(itemType, terminalDTO.itemType) && Objects.equals(terminalDescription, terminalDTO.terminalDescription) && Objects.equals(capacity, terminalDTO.capacity) && Objects.equals(availableCapacity, terminalDTO.availableCapacity) && Objects.equals(statusCode, terminalDTO.statusCode) && Objects.equals(harborLocation, terminalDTO.harborLocation);
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

    public static TerminalDTO prepareDTO(Terminal terminal) {
		TerminalDTO terminalDTO = new TerminalDTO();
		terminalDTO.setTerminalId(terminal.getTerminalId());
		terminalDTO.setTerminalName(terminal.getTerminalName());
		terminalDTO.setCountry(terminal.getCountry());
		terminalDTO.setItemType(terminal.getItemType());
		terminalDTO.setTerminalDescription(terminal.getTerminalDescription());
		terminalDTO.setCapacity(terminal.getCapacity());
		terminalDTO.setAvailableCapacity(terminal.getAvailableCapacity());
		terminalDTO.setStatusCode(terminal.getStatusCode());
		terminalDTO.setHarborLocation(terminal.getHarborLocation());
		return terminalDTO;
	}

	public static Terminal prepareEntity(TerminalDTO terminalDTO) {
		Terminal terminal = new Terminal();
		terminal.setTerminalId(terminalDTO.getTerminalId());
		terminal.setTerminalName(terminalDTO.getTerminalName());
		terminal.setCountry(terminalDTO.getCountry());
		terminal.setItemType(terminalDTO.getItemType());
		terminal.setTerminalDescription(terminalDTO.getTerminalDescription());
		terminal.setCapacity(terminalDTO.getCapacity());
		terminal.setAvailableCapacity(terminalDTO.getAvailableCapacity());
		terminal.setStatusCode(terminalDTO.getStatusCode());
		terminal.setHarborLocation(terminalDTO.getHarborLocation());
		return terminal;
	}

}
