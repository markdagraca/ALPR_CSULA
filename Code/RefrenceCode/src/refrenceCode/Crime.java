package refrenceCode;

import java.util.Date;

public class Crime {

	private String Description,comment;
	private int penalCode;
    private Date date_Of_Occurance,trial_Date,Conviction_Date;
    private String location_Of_Occurance;
    private CaseStatus outcome;
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";

    public Crime(String id) {
    	Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM crime WHERE license_number = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	          	
            	this.penalCode = rs.getInt("penalCode");
            	this.Description = rs.getString("descriptiontext");
            	this.comment = rs.getString("commenttext");
            	this.date_Of_Occurance = rs.getDate("date_Of_Occurance");
            	this.trial_Date = rs.getDate("trial_Date");
            	this.Conviction_Date = rs.getDate("conviction_Date");
            	this.location_Of_Occurance = rs.getString("location_Of_Occurance");
            	String caseoutcome = rs.getString("outcome");  
            	this.outcome = outcome.valueOf(caseoutcome.toUpperCase());
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

    public int getPenalCode() {
        return penalCode;
    }

    public void setPenalCode(int penalCode) {
        this.penalCode = penalCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate_Of_Occurance() {
        return date_Of_Occurance;
    }

    public void setDate_Of_Occurance(Date date_Of_Occurance) {
        this.date_Of_Occurance = date_Of_Occurance;
    }

    public Date getTrial_Date() {
        return trial_Date;
    }

    public void setTrial_Date(Date trial_Date) {
        this.trial_Date = trial_Date;
    }

    public Date getConviction_Date() {
        return Conviction_Date;
    }

    public void setConviction_Date(Date conviction_Date) {
        Conviction_Date = conviction_Date;
    }

    public String getLocation_Of_Occurance() {
        return location_Of_Occurance;
    }

    public void setLocation_Of_Occurance(String location_Of_Occurance) {
        this.location_Of_Occurance = location_Of_Occurance;
    }
}
