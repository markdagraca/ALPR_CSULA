import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Date;

public class Vehicle {
    public String id,vin;

    private Address address;
    private Boolean isWanted;
    private Date registrationDateExperation;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getWanted() {
        return isWanted;
    }

    public void setWanted(Boolean wanted) {
        isWanted = wanted;
    }

    public Vehicle() {

        address=null;
        isWanted=false;
        registrationDateExperation=null;
        id=vin="";
    }

    public Date getRegistrationDateExperation() {
        return registrationDateExperation;
    }

    public void setRegistrationDateExperation(Date registrationDateExperation) {
        this.registrationDateExperation = registrationDateExperation;
    }
}
