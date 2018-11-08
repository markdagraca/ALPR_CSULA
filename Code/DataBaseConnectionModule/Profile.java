package refrenceCode;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Profile {
	private Image photo;
    private String
            iD,
            firstName,
            middleName,
            lastName,
            suffix,
            sex,
            race,
            gender,
            ethnicity,
            eyeColor,
            restrictions,
            hairColor;

    private int height,
            weight,
            SSN;
    private Address place_Of_Residence;

    private boolean
            sex_offender,
            felonyConviction,
            dvCharge,
            dvConviction,
            ncic_want,
            weapon_permit;
    private Citizen citizenship;
    private Date date_of_birth,date_of_experation;
    private ArrayList<Crime> criminalHistory = new ArrayList<Crime>();

    public Profile()
    {
        iD="";
        firstName="";
        middleName="";
        lastName="";
        suffix="";
        sex="";
        race="";
        gender="";
        ethnicity="";
        eyeColor="";
        restrictions="";
        hairColor="";
        sex_offender=felonyConviction=dvCharge=ncic_want=weapon_permit;
        citizenship=Citizen.NA;
        date_of_birth=date_of_experation=null;
        criminalHistory=new ArrayList<Crime>();
        photo=null;
    }
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
    public Profile(String plateNum) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM ownerinformation a INNER JOIN personalinformation b ON a.license_number = b.license_number"
            		+ " WHERE plate_number = '" + plateNum + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
            	this.iD = rs.getString("license_number");
            	this.firstName = rs.getString("firstname");
            	this.middleName = rs.getString("middlename");
            	if(middleName.equals("null")) {
            		middleName = "";
            	}
            	
            	this.lastName = rs.getString("lastname");
            	this.suffix = "";
            	this.gender = rs.getString("gender");
            	this.date_of_birth = rs.getDate("birthday");
            	String citizen = rs.getString("citizen");
            	citizenship = citizenship.valueOf(citizen.toUpperCase());
            	this.race = rs.getString("race");
            	this.ethnicity = rs.getString("ethnicity");
            	this.eyeColor = rs.getString("eyecolor");
            	this.hairColor = rs.getString("hairColor");
            	this.height = rs.getInt("height");
            	this.weight = rs.getInt("weight");
            	this.SSN = rs.getInt("ssn");  
            	this.restrictions = "No";
            	
            	this.place_Of_Residence = new Address(iD);
            	
            	int booleanBridge = rs.getInt("crime");
            	if(booleanBridge == 1) {
            		sql = "SELECT * FROM crime WHERE license_number = '" + iD + "'";
            		rs = stmt.executeQuery(sql);
            		while(rs.next()) {
            			booleanBridge = rs.getInt("sexoffender");
                    	if(booleanBridge == 1) {
                    		this.sex_offender = true;
                    	}
                    	booleanBridge = rs.getInt("felonyconviction");
                    	if(booleanBridge == 1) {
                    		this.felonyConviction = true;
                    	}
                    	booleanBridge = rs.getInt("dvcharge");
                    	if(booleanBridge == 1) {
                    		this.dvCharge = true;
                    	}
                    	booleanBridge = rs.getInt("dvconviction");
                    	if(booleanBridge == 1) {
                    		this.dvConviction = true;
                    	}
                    	booleanBridge = rs.getInt("ncicwant");
                    	if(booleanBridge == 1) {
                    		this.ncic_want = true;
                    	}
                    	booleanBridge = rs.getInt("weaponpermit");
                    	if(booleanBridge == 1) {
                    		this.weapon_permit = true;
                    	}                                 	
            		}
                    this.criminalHistory.add(new Crime(iD));
            	}
            	
            }
            rs.close();
            stmt.close();
            conn.close();
            
//            if(this.licenseNumber != null) {
//            	this.compare = true;
//            }
//            else {
//            	this.compare = false;
//            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }	
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

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
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

    public Address getPlace_Of_Residence() {
        return place_Of_Residence;
    }

    public void setPlace_Of_Residence(Address place_Of_Residence) {
        this.place_Of_Residence = place_Of_Residence;
    }

    public ArrayList<Crime> getCriminalHistory() {
        return criminalHistory;
    }

    public void setCriminalHistory(ArrayList<Crime> criminalHistory) {
        this.criminalHistory = criminalHistory;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Citizen getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizen citizenship) {
        this.citizenship = citizenship;
    }
}
