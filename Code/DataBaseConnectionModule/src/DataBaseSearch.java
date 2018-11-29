import refrenceCode.*;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;


public class DataBaseSearch implements dataBaseSearchModule{
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://cs3.calstatela.edu:3306/cs3220stu74";
    
    private static final String USER = "cs3220stu74";
    private static final String PASS = "NfOE8kOQ";
    private Profile allInf = new Profile();
    private Vehicle vechicleInf = new Vehicle();
    private String idNumber;
    private Address newAddress;

    public static void main(String args[])
	{

		java.util.Date date=new java.util.Date();

		DataBaseSearch test=new DataBaseSearch();
		long start=0,end=0;
		start=date.getTime();
		System.out.println("Start "+start);
		System.out.println(test.searchByPlate("6HCM166",States.CA));
		end=date.getTime();
		System.out.println("End "+end);
		System.out.println("Diff "+(end-start));


	}
    @Override
	public Profile searchByName(String firstName, String middleName, String lastName, Address address) {
		Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT firstname, middlename, lastname, license_number FROM personalinformation WHERE firstname = '" + firstName + "' AND"
            											  + " middlename = '" + middleName + "' AND "
            											  + " lastname = '" + lastName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            String first = null;
            String middle = null;
            String last = null;
            String id = null;
            while(rs.next()) {           	
            	first = rs.getString("firstname");
            	middle = rs.getString("middlename");
            	last = rs.getString("lastname"); 
            	id = rs.getString("license_number");
            }

            String street = null;
            String city = null;
            String state = null;
            int zipCode = 0;
            if(id != null) {
            	sql = "SELECT address, city, region, postalcode FROM personalinformation WHERE address = '" + address.getStreet() + "' AND "
            										+ "city = '" + address.getCity() + "' AND "
            										+ "region = '" + address.getState() + "' AND "
            										+ "postalcode = '" + address.getZipcode() + "'";
            	rs = stmt.executeQuery(sql);
            	while(rs.next()) {           	
            		street = rs.getString("address");
            		city = rs.getString("city");
            		state = rs.getString("region"); 
            		zipCode = rs.getInt("postalcode");
                }
            }
            
            if(id == null) {
            	return null;
            }
            
            States stateInf = States.valueOf(state);
            if(first.equals(firstName) && middle.equals(middleName) && last.equals(lastName) && street.equals(address.getStreet())  && city.equals(address.getCity()) && stateInf.equals(address.getState()) && zipCode == address.getZipcode())                        	
            {
            	this.idNumber = id;
            	this.newAddress = address;
            	searchMethod();
            }
            rs.close();
            stmt.close();
            conn.close();
            return allInf;
        }catch(SQLException se){
            se.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
//		return null;
	}

	@Override
	public Vehicle searchByPlate(String plateNumber, States state) {
		Connection conn = null;
        Statement stmt = null;
        
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT license_number,plate_number, state FROM plateinformation WHERE plate_number = '" + plateNumber + "' AND"
            											  + " state = '" + state + "'";
            ResultSet rs = stmt.executeQuery(sql);
            String plate = null;
            String sta = null;
            String id = null;
            while(rs.next()) {
            	id = rs.getString("license_number");
            	plate = rs.getString("plate_number");
            	sta = rs.getString("state");           	
            }
            
            if(plate == null) {
            	return null;
            }

            if(plate.equals(plateNumber) && sta.equals(state + ""))             
            {
            	sql = "SELECT * FROM plateinformation a INNER JOIN personalinformation b ON a.license_number  = b.license_number WHERE a.license_number = '" + id + "'";
            	rs = stmt.executeQuery(sql);
            	while(rs.next()) {           	
            		vechicleInf.setVin(rs.getString("vin"));
            		if(rs.getInt("isWanted") == 1) {
            			vechicleInf.setWanted(true);
            		}
            		vechicleInf.setDriverLicence_ID(rs.getString("license_number"));
            		vechicleInf.setVehicleType(Vehicle.VehicleType.valueOf("AUTO"));
            		String date = rs.getString("expirationdate");
            		vechicleInf.setYear(Year.parse(date.substring(0, 4)));
            		vechicleInf.setRegistrationDateExperation(rs.getDate("expirationdate"));
            		Address address = new Address();
            		address.setStreet(rs.getString("address"));
            		address.setCity(rs.getString("city"));
            		address.setState(state);
            		address.setZipcode(rs.getInt("postalcode"));
            		vechicleInf.setOwner_Address(address);
            		vechicleInf.setLegal_Owner_Address(address);            		
                }
            	 rs.close();
                 stmt.close();
                 conn.close();
            }
            
            rs.close();
            stmt.close();
            conn.close();
            return vechicleInf;
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public boolean isConnected() {
		 try{
	            Class.forName(JDBC_DRIVER);
	            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            Statement stmt = conn.createStatement();
	            String sql;
	            sql = "SELECT license_number FROM personalinformation WHERE license_number = 'G2519949'";
	            ResultSet rs = stmt.executeQuery(sql);
	            String id = null;
	            while(rs.next()) {
	            	id = rs.getString("license_number");
	            }
	            
	            if(id == null) {
	            	return false;
	            }else {
	            	return true;
	            }
		 }catch(Exception e){
	            e.printStackTrace();
	        }
		return false;
	}

	@Override
	public Profile searchByID(String id, States state) {
		Connection conn = null;
        Statement stmt = null;
        
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
           
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT license_number, region FROM personalinformation WHERE license_number = '" + id + "' AND"
            											  + " region = '" + state + "'";
            ResultSet rs = stmt.executeQuery(sql);
            String sta = null;
            String idnum = null;
            while(rs.next()) {           	
            	sta = rs.getString("region");
            	idnum = rs.getString("license_number");
            }
            
            if(idnum == null) {
            	return null;
            }
            
            if(idnum.equals(id) && sta.equals(state + "")) {
            	this.idNumber = id;
            	searchMethod();
            }
            rs.close();
            stmt.close();
            conn.close();
            return allInf;
        }catch(Exception e){
            e.printStackTrace();
        }
		return null;
	}
	
	public void searchMethod() {
		Connection conn = null;
        Statement stmt = null;
		
	try {
		Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        stmt = conn.createStatement();
        String sql;

		sql = "SELECT * FROM personalinformation a INNER JOIN plateinformation b ON a.license_number = b.license_number WHERE a.license_number = '" + idNumber + "'";
		ResultSet rs = stmt.executeQuery(sql);
    	rs = stmt.executeQuery(sql);

    	while(rs.next()) {           	
    		allInf.setFirstName(rs.getString("firstname"));
    		allInf.setMiddleName(rs.getString("middlename"));
    		allInf.setLastName(rs.getString("lastname"));
    		allInf.setiD(rs.getString("license_number"));
    		allInf.setSuffix("");
    		allInf.setGender(rs.getString("gender"));
    		allInf.setDate_of_birth(rs.getDate("birthday"));
    		allInf.setDate_of_experation(rs.getDate("expirationdate"));
    		allInf.setCitizenship(Citizen.valueOf(rs.getString("citizen").toUpperCase()));
    		allInf.setRace(rs.getString("race"));
    		allInf.setEthnicity(rs.getString("ethnicity"));
    		allInf.setEyeColor(rs.getString("eyecolor"));
    		allInf.setHairColor(rs.getString("hairColor"));
    		allInf.setHeight(rs.getInt("height"));
    		allInf.setWeight(rs.getInt("weight"));
    		allInf.setSSN(rs.getInt("ssn"));
    		allInf.setRestrictions("No");
    		allInf.setPlace_Of_Residence(newAddress);
    		
    		if(rs.getInt("crime") == 1) {
    			sql = "SELECT * FROM crime WHERE license_number = '" + idNumber + "'";
        		rs = stmt.executeQuery(sql);
        		ArrayList<Crime> criminalHistory = new ArrayList<Crime>();
        		Crime crime = new Crime();
        		while(rs.next()) {
                	if(rs.getInt("sexoffender") == 1) {
                		allInf.setSex_offender(true);
                	}                       
                	if(rs.getInt("felonyconviction") == 1) {
                		allInf.setFelonyConviction(true);
                	}
                	if(rs.getInt("dvcharge") == 1) {
                		allInf.setDvCharge(true);
                	}
                	if(rs.getInt("dvConviction") == 1) {
                		allInf.setDvConviction(true);
                	}
                	if(rs.getInt("ncicwant") == 1) {
                		allInf.setNcic_want(true);
                	}
                	if(rs.getInt("weaponpermit") == 1) {
                		allInf.setWeapon_permit(true);
                	}
                	
                	crime.setPenalCode(rs.getInt("penalCode") + "");
                	crime.setDescription(rs.getString("descriptiontext"));
                	crime.setComment(rs.getString("commenttext"));
                	crime.setDate_Of_Occurance(rs.getDate("date_Of_Occurance"));
                	crime.setConviction_Date(rs.getDate("trial_Date"));
                	crime.setTrial_Date(rs.getDate("conviction_Date"));
                	String s = rs.getString("location_Of_Occurance");
                	Address crimeAddress = new Address();
                	crimeAddress.setStreet(s.substring(0, s.indexOf(".")));
                	crimeAddress.setCity(s.substring(s.indexOf(".")+2, s.indexOf(",")));
                	States sta = States.valueOf(s.substring(s.indexOf(",")+2, s.indexOf(",")+4));
                	crimeAddress.setState(sta);
                	crimeAddress.setZipcode(s.indexOf(",")+6);
                	crime.setLocation_Of_Occurance(crimeAddress);
                	criminalHistory.add(new Crime());
        		}
    		}
        }
	}catch(SQLException se){
        se.printStackTrace();
    }catch(Exception e){
        e.printStackTrace();
    }
}
	
}
