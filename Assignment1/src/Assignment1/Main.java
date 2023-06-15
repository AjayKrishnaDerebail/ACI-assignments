package Assignment1;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//The custom exception in this class is triggered when the sorting direction is not specified by the user.
class SchoolSortByCriteriaNotMetException extends Exception{
    public SchoolSortByCriteriaNotMetException(String direction){
        super(direction);
    }
}
//code to create the csv file
class CsvWriter {
    public static void writeSchoolsToCsv(List<SchoolInfo> schoolList) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\ajayk\\IdeaProjects\\ACI\\src\\Assignment1\\schoolsorted.csv"))) {
            // Write the headers
            String[] header = {"School Name", "School Code", "School Phone No", "Total Sports Events per Year",
                    "Total Culture Events per Year", "Average Annual Fee", "Total Teacher Complaints",
                    "Total Teacher Appreciation"};
            writer.writeNext(header);
            // Write the data
            for (SchoolInfo school : schoolList) {
                String[] data = {school.getSchoolName(), school.getSchoolCode(), String.valueOf(school.getSchoolPhoneNo()),
                        String.valueOf(school.getTotalSportseventsperyear()),
                        String.valueOf(school.getTotalCultureeventsperyear()),
                        String.valueOf(school.getAverageAnnualFee()),
                        String.valueOf(school.getTotalTeacherComplaints()),
                        String.valueOf(school.getTotalTeacherAppreciation())};
                writer.writeNext(data);
            }
            System.out.println("data added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Main {
        public static void main(String[] args) {
            //System.out.println("Hello world!");
            SchoolInfo school1 = new SchoolInfo("St. Aloysius High School", "SAHS001", 123456789, 10, 20, 17240.0, 5, 8);
            SchoolInfo school2 = new SchoolInfo("Canara High School", "CHS002", 987654321, 15, 25, 30000.0, 3, 10);
            SchoolInfo school3 = new SchoolInfo("Cambridge International School", "CIS003", 567890123, 8, 18, 49000.0, 7, 6);
            SchoolInfo school4 = new SchoolInfo("Little Rock Indian School", "LRIS004", 907654321, 12, 22, 50000.0, 4, 9);
            SchoolInfo school5 = new SchoolInfo("Lourdes Central School", "LCS005", 234568901, 9, 15, 37800.0, 6, 5);
            SchoolInfo school6 = new SchoolInfo("Bharatiya Vidya Bhavan's School", "BVBS006", 754321098, 11, 21, 33800.0, 5, 7);
            SchoolInfo school7 = new SchoolInfo("Sacred Heart School", "SHS007", 543210986, 13, 23, 21000.0, 2, 9);
            SchoolInfo school8 = new SchoolInfo("St. Theresa's School", "STS008", 678901345, 7, 16, 52000.0, 8, 4);
            SchoolInfo school9 = new SchoolInfo("Canara Girls' High School", "CGHS009", 876543210, 10, 19, 25000.0, 6, 6);
            SchoolInfo school10 = new SchoolInfo("St. Joseph's Central School", "SJCS010", 356789012, 12, 24, 26000.0, 4, 8);
            SchoolInfo school11 = new SchoolInfo("Loyola School", "LS011", 890123467, 8, 17, 35000.0, 7, 5);
            SchoolInfo school12 = new SchoolInfo("Rosario School", "RS012", 567891234, 11, 20, 33400.0, 3, 7);
            SchoolInfo school13 = new SchoolInfo("BGS National Public School", "BGSNPS013", 912345678, 9, 18, 78000.0, 5, 5);
            SchoolInfo school14 = new SchoolInfo("Sadvidya High School", "SHS014", 432109875, 14, 25, 45500.0, 2, 10);
            SchoolInfo school15 = new SchoolInfo("Sharadha Vidalaya", "SHV015", 790123456, 13, 22, 55900.0, 3, 9);
            SchoolInfo school16 = new SchoolInfo("Nalanda English Medium School", "NEMS016", 210976543, 7, 15, 34800.0, 6, 4);
            SchoolInfo school17 = new SchoolInfo("Kendriya Vidyalaya", "KV017", 654321097, 10, 21, 66300.0, 4, 6);
            SchoolInfo school18 = new SchoolInfo("St. Sebastian's School", "SSS018", 986543210, 11, 19, 65500.0, 5, 7);
            SchoolInfo school19 = new SchoolInfo("St. Mary's School", "SMS019", 321098654, 9, 16, 45000.0, 7, 5);
            SchoolInfo school20 = new SchoolInfo("City Central School", "CCS020", 876432109, 12, 23, 35600.0, 4, 8);

            SchoolInfo[] schools = {school1, school2, school3, school4, school5, school6, school7, school8, school9, school10, school11, school12, school13, school14, school15, school16, school17, school18, school19, school20};

            ArrayList<SchoolInfo> schoolList = new ArrayList<>(Arrays.asList(schools));

            System.out.println("Set sorting direction ascending or descending");
            Scanner scanner = new Scanner(System.in);
            String direction=scanner.nextLine();
            scanner.close();

            if (direction.equals("ascending") || direction.equals("descending"))
            {
                // Sort the ArrayList based on multiple attributes
                schoolList.sort(new Comparator<SchoolInfo>() {
                    public int compare(SchoolInfo s1, SchoolInfo s2) {
                        int result = Integer.compare(s1.getTotalSportseventsperyear(), s2.getTotalSportseventsperyear());
                        if (result == 0) {
                            result = Integer.compare(s1.getTotalCultureeventsperyear(), s2.getTotalCultureeventsperyear());
                        }
                        if (result == 0) {
                            result = Double.compare(s1.getAverageAnnualFee(), s2.getAverageAnnualFee());
                        }
                        if (result == 0) {
                            result = Integer.compare(s1.getTotalTeacherComplaints(), s2.getTotalTeacherComplaints());
                        }
                        if (result == 0) {
                            result = Integer.compare(s1.getTotalTeacherAppreciation(), s2.getTotalTeacherAppreciation());
                        }
                        if (direction.equals("ascending"))
                            return result;

                        return result * -1;
                    }
                });
                CsvWriter.writeSchoolsToCsv(schoolList);
            }
            else
            {
                try{
                    throw new SchoolSortByCriteriaNotMetException("Direction not set");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("size of the arrayList is "+schoolList.size());
            // Print the ArrayList regardless of it being sorted or not
            int i=1;
            for (SchoolInfo school : schoolList) {
                System.out.print("School No "+i+" ");
                System.out.println(school.getSchoolName()+ " " +school.getTotalSportseventsperyear()+ " " +school.getTotalCultureeventsperyear()
                        + " " +school.getAverageAnnualFee()+ " " +school.getTotalTeacherComplaints()+ " " +school.getTotalTeacherAppreciation());
                i++;
            }

        }
    }
