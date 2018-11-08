package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonalInformation {
	private String licenseNumber;
	private String firstname;
	private String middlename;
    private String lastname;
	private String phone;
    private String gender;
    private String birthday;
	private String citizen;
	private boolean crime;
	private boolean compare;
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
	public PersonalInformation() {}
	
	public PersonalInformation(String id) {
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM personalinformation WHERE license_number = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
            	this.licenseNumber = rs.getString("license_number");
            	this.firstname = rs.getString("firstname");
            	this.middlename = rs.getString("middlename");
            	if(middlename.equals("null")) {
            		middlename = "";
            	}
            	
            	this.lastname = rs.getString("lastname");
            	this.phone = rs.getString("phone");
            	this.gender = rs.getString("gender");
            	this.birthday = rs.getString("birthday");
            	this.citizen = rs.getString("citizen");
            	
            	int booleanBridge = rs.getInt("crime");
            	if(booleanBridge == 1) {
            		this.crime = true;
            	}
            	
            }
            rs.close();
            stmt.close();
            conn.close();
            
            if(this.licenseNumber != null) {
            	this.compare = true;
            }
            else {
            	this.compare = false;
            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }	
	}
	
	public PersonalInformation(String firstName, String middleName, String lastName){
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM personalinformation WHERE firstname = '" + firstName + "' AND middlename = '" 
            									+ middleName + "' AND lastname = '" + lastName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
            	this.licenseNumber = rs.getString("license_number");
            	this.firstname = rs.getString("firstname");
            	this.middlename = rs.getString("middlename");           	
            	if(middlename.equals("null")) {
            		this.middlename = "";
            	}
            	
            	this.lastname = rs.getString("lastname");            
            	
            	this.phone = rs.getString("phone");
            	this.gender = rs.getString("gender");
            	this.birthday = rs.getString("birthday");
            	this.citizen = rs.getString("citizen");
            	
            	int booleanBridge = rs.getInt("crime");
            	if(booleanBridge == 1) {
            		this.crime = true;
            	}
            	
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
            if(this.firstname != null && this.middlename != null && this.lastname != null) {
            	this.compare = true;
            }
            else {
            	this.compare = false;
            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }	
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public boolean isCrime() {
		return crime;
	}

	public void setCrime(boolean crime) {
		this.crime = crime;
	}
	
	public boolean isCompare() {
		return compare;
	}

	public void setCompare(boolean compare) {
		this.compare = compare;
	}

	@Override
    public String toString() {
        String personText = "";
        
        personText = "First Name: " + firstname + "\n";
        if(middlename != "") {
        	personText = personText + "Middle Name: " + middlename + "\n";
        }
        personText = personText + "Last Name: " + lastname + "\n"
        						+ "Phone: " + phone + "\n"
        						+ "Gender: " + gender + "\n"
        						+ "Birth Date: " + birthday + "\n";
        if(citizen.equals("Yes")) {
        	personText = personText + "Citizen: U.S Citizen\n";
        }
        else if(citizen.equals("Visa")){
        	personText = personText + "Citizen: Visa\n";
        }
        else {
        	personText = personText + "Citizen: Not Citizen\n";
        }
        return personText;
    }
}
