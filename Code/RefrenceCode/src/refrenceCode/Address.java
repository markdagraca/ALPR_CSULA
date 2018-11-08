package refrenceCode;

public class Address {
	private String street,
    city;
    private String zipcode;
    private States state;
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";

    public Address(String id) {
    	Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM address WHERE license_number = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	this.street = rs.getString("address");
            	this.city = rs.getString("city");
            	String states = rs.getString("region");
            	this.state  = state.valueOf(states);
            	this.zipcode = rs.getString("postalcode");
            	
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
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
