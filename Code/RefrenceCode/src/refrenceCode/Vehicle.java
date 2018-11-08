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

private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";

private static final String USER = "root";
private static final String PASS = "a931019555";

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

public Vehicle(String plateNumber) {
Connection conn = null;
Statement stmt = null;

try{
Class.forName(JDBC_DRIVER);

conn = DriverManager.getConnection(DB_URL,USER,PASS);

stmt = conn.createStatement();
String sql;
sql = "SELECT * FROM plateinformation a INNER JOIN personalinformation b ON a.license_number = b.license_number"
		+ " WHERE plate_number = '" + plateNumber + "'";
ResultSet rs = stmt.executeQuery(sql);

String firstN = rs.getString("firstname");
String middleN = rs.getString("middlename");
if(middleN.equals("null")) {
	middleN = "";
}
String lastN = rs.getString("lastname");

this.ownerName = firstN + " " + middleN + " " + lastN;

while(rs.next()) {           	
//	this.plateNumber = rs.getString("plate_number");
	this.id = rs.getString("license_number");
	this.vin = rs.getString("vin");
	this.make = rs.getString("make");
	this.model = rs.getString("model");
//	this.state = rs.getString("state");
	this.registrationDateExperation = rs.getDate("expirationdate");
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

//if(this.state != null && this.plateNumber != null) {
//	this.compare = true;
//}
//else {
//	this.compare = false;
//}
}catch(SQLException se){
se.printStackTrace();
}catch(Exception e){
e.printStackTrace();
}
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