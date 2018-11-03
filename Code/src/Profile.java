import java.util.ArrayList;
import java.util.Date;

public class Profile {

    private String firstName,
            middleName,
            lastName,
            suffix,
            sex,
            address,
            city,
            state,
            race,
            gender,
            ethnicity,
            eyeColor,
            restrictions,
            hairColor;
    private int height,
            weight,
            zipCode,
            SSN;
    private boolean state_ID,
            sex_offender,
            felonyConviction,
            dvCharge,
            dvConviction,
            ncic_want,
            weapon_permit;
    private enum citizen{FALSE,TRUE,VISA};
    private Date date_of_birth,date_of_experation,date_of_death;
    private ArrayList<Crime> criminalHistory;

    public Profile()
    {
        firstName="";
        middleName="";
        lastName="";
        suffix="";
        sex="";
        address="";
        city="";
        state="";
        race="";
        gender="";
        ethnicity="";
        eyeColor="";
        restrictions="";
        hairColor="";
        sex_offender=false;
        felonyConviction=false;
        dvCharge=false;
        dvConviction=false;
        ncic_want=false;
        weapon_permit=false;
        criminalHistory=null;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public boolean isState_ID() {
        return state_ID;
    }

    public void setState_ID(boolean state_ID) {
        this.state_ID = state_ID;
    }

    public boolean isSex_offender() {
        return sex_offender;
    }

    public void setSex_offender(boolean sex_offender) {
        this.sex_offender = sex_offender;
    }

    public boolean isFelonyConviction() {
        return felonyConviction;
    }

    public void setFelonyConviction(boolean felonyConviction) {
        this.felonyConviction = felonyConviction;
    }

    public boolean isDvCharge() {
        return dvCharge;
    }

    public void setDvCharge(boolean dvCharge) {
        this.dvCharge = dvCharge;
    }

    public boolean isDvConviction() {
        return dvConviction;
    }

    public void setDvConviction(boolean dvConviction) {
        this.dvConviction = dvConviction;
    }

    public boolean isNcic_want() {
        return ncic_want;
    }

    public void setNcic_want(boolean ncic_want) {
        this.ncic_want = ncic_want;
    }

    public boolean isWeapon_permit() {
        return weapon_permit;
    }

    public void setWeapon_permit(boolean weapon_permit) {
        this.weapon_permit = weapon_permit;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_experation() {
        return date_of_experation;
    }

    public void setDate_of_experation(Date date_of_experation) {
        this.date_of_experation = date_of_experation;
    }

    public Date getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_death(Date date_of_death) {
        this.date_of_death = date_of_death;
    }

    public static void main(String args[])
    {
        
        System.out.print("hello");
    }

}
