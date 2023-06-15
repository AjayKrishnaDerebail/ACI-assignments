package Assignment1;

public class SchoolInfo {
    private String schoolName;
    private String schoolCode;
    private long schoolPhoneNo;
    private int totalSportseventsperyear;
    private int totalCultureeventsperyear;
    private double averageAnnualFee;
    private int totalTeacherComplaints;
    private int totalTeacherAppreciation;
    public SchoolInfo() {
    }

    public SchoolInfo(String schoolName, String schoolCode, long schoolPhoneNo, int totalSportseventsperyear, int totalCultureeventsperyear, double averageAnnualFee, int totalTeacherComplaints, int totalTeacherAppreciation) {
        this.schoolName = schoolName;
        this.schoolCode = schoolCode;
        this.schoolPhoneNo = schoolPhoneNo;
        this.totalSportseventsperyear = totalSportseventsperyear;
        this.totalCultureeventsperyear = totalCultureeventsperyear;
        this.averageAnnualFee = averageAnnualFee;
        this.totalTeacherComplaints = totalTeacherComplaints;
        this.totalTeacherAppreciation = totalTeacherAppreciation;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public long getSchoolPhoneNo() {
        return schoolPhoneNo;
    }

    public int getTotalSportseventsperyear() {
        return totalSportseventsperyear;
    }

    public int getTotalCultureeventsperyear() {
        return totalCultureeventsperyear;
    }

    public double getAverageAnnualFee() {
        return averageAnnualFee;
    }

    public int getTotalTeacherComplaints() {
        return totalTeacherComplaints;
    }

    public int getTotalTeacherAppreciation() {
        return totalTeacherAppreciation;
    }

}
