import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;

public class Crime {

    private String penalCode,Description,comment;
    private Date date_Of_Occurance,trial_Date,Conviction_Date;
    private Address location_Of_Occurance;
    private CaseStatus outcome;


    public String getPenalCode() {
        return penalCode;
    }

    public void setPenalCode(String penalCode) {
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

    public Address getLocation_Of_Occurance() {
        return location_Of_Occurance;
    }

    public void setLocation_Of_Occurance(Address location_Of_Occurance) {
        this.location_Of_Occurance = location_Of_Occurance;
    }




}
