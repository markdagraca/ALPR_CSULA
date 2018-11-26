package refrenceCode;

import java.time.Year;
import java.util.Date;

public class Vehicle {
    private String id;//license plate
    private String driverLicence_ID;
    //driver license id if nothing is present then use owner name and address
    // for example if it registered to a company then no background search needs to be done
    private String vin;
    private String make;
    private String model;

    private String ownerName,legalOwnerName;
    private String wantedDescription;
    private Boolean isWanted;

    private VehicleType vehicleType;
    private Address owner_Address,legal_Owner_Address;
    private Date registrationDateExperation;
    private Year year;

    public String getDriverLicence_ID() {
        return driverLicence_ID;
    }

    public void setDriverLicence_ID(String driverLicence_ID) {
        this.driverLicence_ID = driverLicence_ID;
    }

    public String getLegalOwnerName() {
        return legalOwnerName;
    }

    public void setLegalOwnerName(String legalOwnerName) {
        this.legalOwnerName = legalOwnerName;
    }


    public enum VehicleType{
        AUTO,COMMERCIAL,MOTORCYCLE,OFF_HIGHWAY,TRAILER_COACH;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getWantedDescription() {
        return wantedDescription;
    }

    public void setWantedDescription(String wantedDescription) {
        this.wantedDescription = wantedDescription;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Boolean getWanted() {
        return isWanted;
    }

    public void setWanted(Boolean wanted) {
        isWanted = wanted;
    }

    public Vehicle() {


        legal_Owner_Address=null;
        owner_Address=null;
        isWanted=false;
        registrationDateExperation=null;
        make=model=ownerName=id=vin=wantedDescription="";
        year=null;

    }

    public Date getRegistrationDateExperation() {
        return registrationDateExperation;
    }

    public void setRegistrationDateExperation(Date registrationDateExperation) {
        this.registrationDateExperation = registrationDateExperation;
    }
    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Address getOwner_Address() {
        return owner_Address;
    }

    public void setOwner_Address(Address owner_Address) {
        this.owner_Address = owner_Address;
    }

    public Address getLegal_Owner_Address() {
        return legal_Owner_Address;
    }

    public void setLegal_Owner_Address(Address legal_Owner_Address) {
        this.legal_Owner_Address = legal_Owner_Address;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
