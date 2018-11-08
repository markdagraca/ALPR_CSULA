package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehicle {
	private String plateNumber;
	private String licenseNumber;
    private String vin;
    private String make;
    private String model;
    private String state;
    private String expirationDate;
    private boolean isWanted;
    private String wantedDescription;
    private boolean compare;
    
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
    public Vehicle() {}
    
	public Vehicle(String plateNumber, String state) {
		super();
		
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM plateinformation WHERE plate_number = '" + plateNumber + "' AND state = '" + state + "'" ;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.plateNumber = rs.getString("plate_number");
            	this.licenseNumber = rs.getString("license_number");
            	this.vin = rs.getString("vin");
            	this.make = rs.getString("make");
            	this.model = rs.getString("model");
            	this.state = rs.getString("state");
            	this.expirationDate = rs.getString("expirationdate");
            	int booleanChange = rs.getInt("isWanted");
            	if(booleanChange == 1){
        			this.isWanted = true;
        		}
        		else {
        			this.isWanted = false;
        		}
            	
            	this.wantedDescription = rs.getString("wantedescription");
            	//if description is null, wantedDescription will be empty string
        		if(wantedDescription.equals("null")){
        			this.wantedDescription = "";
        		}
        		else {
        			this.wantedDescription = wantedDescription;
        		}
            	
            }
            rs.close();
            stmt.close();
            conn.close();
            
            if(this.state != null && this.plateNumber != null) {
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
	
	public Vehicle(String plateNumber) {
		super();
		
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM plateinformation WHERE plate_number = '" + plateNumber + "'" ;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.plateNumber = rs.getString("plate_number");
            	this.licenseNumber = rs.getString("license_number");
            	this.vin = rs.getString("vin");
            	this.make = rs.getString("make");
            	this.model = rs.getString("model");
            	this.state = rs.getString("state");
            	this.expirationDate = rs.getString("expirationdate");
            	int booleanChange = rs.getInt("isWanted");
            	if(booleanChange == 1){
        			this.isWanted = true;
        		}
        		else {
        			this.isWanted = false;
        		}
            	
            	this.wantedDescription = rs.getString("wantedescription");
            	//if description is null, wantedDescription will be empty string
        		if(wantedDescription.equals("null")){
        			this.wantedDescription = "";
        		}
        		else {
        			this.wantedDescription = wantedDescription;
        		}
            	
            }
            rs.close();
            stmt.close();
            conn.close();
            
            if(this.plateNumber != null) {
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

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isWanted() {
		return isWanted;
	}

	public void setWanted(boolean isWanted) {
		this.isWanted = isWanted;
	}

	public String getWantedDescription() {
		return wantedDescription;
	}

	public void setWantedDescription(String wantedDescription) {
		this.wantedDescription = wantedDescription;
	};
    
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isCompare() {
		return compare;
	}

	public void setCompare(boolean compare) {
		this.compare = compare;
	}

	@Override
    public String toString() {
        String vehicleText = "";
        
        vehicleText = "Plate Number: " + plateNumber + "\n"
        				+ "Vin: " + vin + "\n"
        				+ "Make: " + make + "\n"
        			    + "Model: " + model + "\n"
        				+ "Registration Expiration Date: " + expirationDate + "\n";
        if(isWanted == true) {
        	vehicleText = vehicleText + "This vehicle is " + wantedDescription + "\n";
        }
        return vehicleText;
    }
}
