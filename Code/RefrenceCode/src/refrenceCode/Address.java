package refrenceCode;

public class Address {
    private String street,
    city;
    /**
     * Zip Code -1 means no ZipCode present
     */
    private int zipcode;
    private States state;

    public Address() {
        street=city="";
        zipcode=-1;
        state=null;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return street +", "+city+", "+state+", "+zipcode;
    }

}
