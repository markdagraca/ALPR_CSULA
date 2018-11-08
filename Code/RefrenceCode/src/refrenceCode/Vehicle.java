package refrenceCode;

import java.time.Year;
import java.util.Date;

public class Vehicle {
    private String id,
            vin,
            make,
            model,
            ownerName,
            wantedDescription;




    public enum VehicleType{
        AUTO,COMMERCIAL,MOTORCYCLE,OFF_HIGHWAY,TRAILER_COACH;

    }
    private VehicleType vehicleType;



    private Address owner_Address,legal_Owner_Address;
    private Boolean isWanted;
    private Date registrationDateExperation;
    private Year year;



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
