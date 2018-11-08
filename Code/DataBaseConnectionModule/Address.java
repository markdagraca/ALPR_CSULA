package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
	private String address;
	private String city;
    private String region;
    private String postalcode;
    private String country;
    private boolean compare;
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
    public Address() {}
    
    public Address(String licenseNum) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM address WHERE license_number = '" + licenseNum + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.address = rs.getString("address");
            	this.city = rs.getString("city");
            	this.region = rs.getString("region");
            	this.postalcode = rs.getString("postalcode");
            	this.country = rs.getString("country");
            	
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
    
    public Address(Address address) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM address WHERE address = '" + address.getAddress() + "'"
            									+ "city = '" + address.getCity() +  "'"
            									+ "region = '" + address.getRegion() + "'"
            									+ "postalcode = '" + address.getPostalcode() + "'"
            									+ "country = '" + address.getCountry() + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.address = rs.getString("address");
            	this.city = rs.getString("city");
            	this.region = rs.getString("region");
            	this.postalcode = rs.getString("postalcode");
            	this.country = rs.getString("country");
            	
            }
            rs.close();
            stmt.close();
            conn.close();
            
            if(address != null && city != null && region != null && postalcode != null && country != null) {
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	};
    
	public boolean isCompare() {
		return compare;
	}

	public void setCompare(boolean compare) {
		this.compare = compare;
	}

	@Override
    public String toString() {
        String addressText = "";
        
        addressText = "Address: " + address + "\n"
        			  + "City: " + city + "\n"
        			  + "Region: " + region + "\n"
        			  + "Postal Code: " + postalcode + "\n"
        			  + "Country: " + country + "\n";
        
        return addressText;
    }

}
