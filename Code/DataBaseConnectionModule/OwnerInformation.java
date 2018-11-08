package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerInformation {
	private String licenseNumber;
	private String race;
	private String ethnicity;
	private String eyecolor;
	private String hairColor;
	private int height;
	private int weight;
	private int ssn;
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
	public OwnerInformation() {}

	public OwnerInformation(String plateNumber) {
		super();
		
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM ownerinformation WHERE plate_number = '" + plateNumber + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.licenseNumber = rs.getString("license_number");
            	this.race = rs.getString("race");
            	this.ethnicity = rs.getString("ethnicity");
            	this.eyecolor = rs.getString("eyecolor");
            	this.hairColor = rs.getString("hairColor");
            	this.height = rs.getInt("height");
            	this.weight = rs.getInt("weight");
            	this.ssn = rs.getInt("ssn");        
            	
            }
            rs.close();
            stmt.close();
            conn.close();
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

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getEyecolor() {
		return eyecolor;
	}

	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	};
	
	@Override
    public String toString() {
        String ownerpersonText = "";
        
        ownerpersonText = "License Number: " + licenseNumber + "\n"
        				  + "Race: " + race + "\n"
        				  + "Ethnicity: " + ethnicity + "\n"
        				  + "Eyecolor: " + eyecolor + "\n"
        				  + "HairColor: " + hairColor + "\n"
        				  + "Height: " + height + "cm\n"
        				  + "Weight: " + height + "lb\n"
        				  + "SSN: " + ssn + "\n";
        
        return ownerpersonText;
    }
}
