package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crime {
	private boolean sexoffender;
	private boolean felonyconviction;
	private boolean dvcharge;
	private boolean dvconviction;
	private boolean ncicwant;
	private boolean weaponpermit;
	private int penalCode;
	private String descriptiontext;
	private String commenttext;
	private String date_Of_Occurance;
	private String trial_Date;
	private String conviction_Date;
	private String location_Of_Occurance;
	private String outcome;
	private int booleanBridge = 0;
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/licensedata";
    
    private static final String USER = "root";
    private static final String PASS = "a931019555";
    
	public Crime() {}
	
	public Crime(String licenseNum) {
		Connection conn = null;
        Statement stmt = null;
    	
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM crime WHERE license_number = '" + licenseNum + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {           	
            	booleanBridge = rs.getInt("sexoffender");
            	if(booleanBridge == 1) {
            		this.sexoffender = true;
            	}
            	booleanBridge = rs.getInt("felonyconviction");
            	if(booleanBridge == 1) {
            		this.felonyconviction = true;
            	}
            	booleanBridge = rs.getInt("dvcharge");
            	if(booleanBridge == 1) {
            		this.dvcharge = true;
            	}
            	booleanBridge = rs.getInt("dvconviction");
            	if(booleanBridge == 1) {
            		this.dvconviction = true;
            	}
            	booleanBridge = rs.getInt("ncicwant");
            	if(booleanBridge == 1) {
            		this.ncicwant = true;
            	}
            	booleanBridge = rs.getInt("weaponpermit");
            	if(booleanBridge == 1) {
            		this.weaponpermit = true;
            	}
            	
            	this.penalCode = rs.getInt("penalCode");
            	this.descriptiontext = rs.getString("descriptiontext");
            	this.commenttext = rs.getString("commenttext");
            	this.date_Of_Occurance = rs.getString("date_Of_Occurance");
            	this.trial_Date = rs.getString("trial_Date");
            	this.conviction_Date = rs.getString("conviction_Date");
            	this.location_Of_Occurance = rs.getString("location_Of_Occurance");
            	this.outcome = rs.getString("outcome");           	
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
	public boolean isSexoffender() {
		return sexoffender;
	}

	public void setSexoffender(boolean sexoffender) {
		this.sexoffender = sexoffender;
	}

	public boolean isFelonyconviction() {
		return felonyconviction;
	}

	public void setFelonyconviction(boolean felonyconviction) {
		this.felonyconviction = felonyconviction;
	}

	public boolean isDvcharge() {
		return dvcharge;
	}

	public void setDvcharge(boolean dvcharge) {
		this.dvcharge = dvcharge;
	}

	public boolean isDvconviction() {
		return dvconviction;
	}

	public void setDvconviction(boolean dvconviction) {
		this.dvconviction = dvconviction;
	}

	public boolean isNcicwant() {
		return ncicwant;
	}

	public void setNcicwant(boolean ncicwant) {
		this.ncicwant = ncicwant;
	}

	public boolean isWeaponpermit() {
		return weaponpermit;
	}

	public void setWeaponpermit(boolean weaponpermit) {
		this.weaponpermit = weaponpermit;
	}

	public int getPenalCode() {
		return penalCode;
	}

	public void setPenalCode(int penalCode) {
		this.penalCode = penalCode;
	}

	public String getDescriptiontext() {
		return descriptiontext;
	}

	public void setDescriptiontext(String descriptiontext) {
		this.descriptiontext = descriptiontext;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	public String getDate_Of_Occurance() {
		return date_Of_Occurance;
	}

	public void setDate_Of_Occurance(String date_Of_Occurance) {
		this.date_Of_Occurance = date_Of_Occurance;
	}

	public String getTrial_Date() {
		return trial_Date;
	}

	public void setTrial_Date(String trial_Date) {
		this.trial_Date = trial_Date;
	}

	public String getConviction_Date() {
		return conviction_Date;
	}

	public void setConviction_Date(String conviction_Date) {
		this.conviction_Date = conviction_Date;
	}

	public String getLocation_Of_Occurance() {
		return location_Of_Occurance;
	}

	public void setLocation_Of_Occurance(String location_Of_Occurance) {
		this.location_Of_Occurance = location_Of_Occurance;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	};
	
	@Override
    public String toString() {
        String crimeText = "";
        if(sexoffender == true) {
        	crimeText = "Sexoffender Warning\n";
        }
        if(felonyconviction == true) {
        	crimeText = crimeText + "Felonyconviction Warning\n"; 
        }
        if(dvcharge == true) {
        	crimeText = crimeText + "Dvcharge Warning\n"; 
        }
        if(dvconviction == true) {
        	crimeText = crimeText + "Dvconviction Warning\n"; 
        }
        if(ncicwant == true) {
        	crimeText = crimeText + "Ncicwant Warning\n"; 
        }
        
        crimeText = crimeText + "Criminal Code: " + penalCode + "\n"
        					  + "Description: " + descriptiontext + "\n"
        					  + "Comment: " + commenttext + "\n"
        					  + "Date Of Occurance: " + date_Of_Occurance + "\n";
        if(trial_Date != null) {
        	crimeText = crimeText + "Trial Date: " + trial_Date + "\n";
        	if(conviction_Date != null) {
        		crimeText = crimeText + "Conviction Date: " + conviction_Date + "\n";
        	}
        }
        
        crimeText = crimeText + "Location Of Occurance: " + location_Of_Occurance + "\n"
        					  + "Case Status: " + outcome;
        return crimeText;
    }
}
