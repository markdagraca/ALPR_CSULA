package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseSearch implements DataBaseSearchModule{
	
	public DataBaseSearch() {}
	
	@Override
	public Profile searchByName(String firstName, String middleName, String lastName, Address address ) {
		PersonalInformation personInf = new PersonalInformation(firstName,middleName,lastName);
		Address addressInf = new Address(address);
		if(addressInf.isCompare() == true && personInf.isCompare() == true) {
			String licenseeNum = personInf.getLicenseNumber();
			Profile allInf = new Profile(new PersonalInformation(licenseeNum),new OwnerInformation(licenseeNum),new Vehicle(licenseeNum),new Address(licenseeNum), new Crime(licenseeNum));
			return allInf;
		}
		return null;
	 }
	
	@Override
	public Profile searchByPlate(String plateNumber, String state) {
		Vehicle vehicleInf = new Vehicle(plateNumber, state);
		if(vehicleInf.isCompare() == true) {
			String licenseeNum = vehicleInf.getLicenseNumber();
			Profile allInf = new Profile(new PersonalInformation(licenseeNum),new OwnerInformation(licenseeNum),new Vehicle(licenseeNum),new Address(licenseeNum), new Crime(licenseeNum));
			return allInf;
		}
		return null;
	}
	
	@Override
	 public boolean isConnected() {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/licensedata","root","a931019555");
            
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM plateinformation WHERE plate_number = SCRWOIL";
            ResultSet rs = stmt.executeQuery(sql);
            String test = null;
            
            while(rs.next()) {           	           	
            	test = rs.getString(0);
            }
            rs.close();
            stmt.close();
            conn.close();
            if(test != null) {
            	return true;
            }else {
            	return false;
            }
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
	}
	
	@Override
	public Profile searchByID(String id) {
		PersonalInformation personInf = new PersonalInformation(id);
		if(personInf.isCompare() == true) {
			String licenseeNum = personInf.getLicenseNumber();
			Profile allInf = new Profile(new PersonalInformation(licenseeNum),new OwnerInformation(licenseeNum),new Vehicle(licenseeNum),new Address(licenseeNum), new Crime(licenseeNum));

			return allInf;
		}
		return null;
	}
}
