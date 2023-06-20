<div align="left">
Consider you are a company who are helping parents choose the right school for their kids. Find the best schools based on sports events, cultural events, fees, and teacher feedback. In
order to achieve this we need to perform the following.
  
  
1.Create a POJO object in which represents parents or any person who is trying to search for a good school .Name, phoneno, email

  
    public class Parent {
    private String name;
    private long phone_no;
    private String email;

    public Parent(String name, long phone_no, String email) {
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public String getEmail() {
        return email;
    }
}

  
  
2.Create a POJO object which has the following information. 
  Schoolname, schoolcode, schoolphoneno, totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, totalteacherappreciation
  Also have an excel file and .arff file which can have the above data for testing purpose



    public class SchoolInfo {
    private String schoolName;
    private String schoolCode;
    private long schoolPhoneNo;
    private int totalSportseventsperyear;
    private int totalCultureeventsperyear;
    private double averageAnnualFee;
    private int totalTeacherComplaints;
    private int totalTeacherAppreciation;

    public SchoolInfo(String schoolName, String schoolCode, long schoolPhoneNo, int totalSportseventsperyear, int totalCultureeventsperyear, double     averageAnnualFee, int totalTeacherComplaints, int totalTeacherAppreciation) {
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
  
3.Create an JAVA program which takes the sort by - totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, 
  totalteacherappreciation And sort direction -ascending or descending. If the user does not provide one of the sort by then throw a custom exception
  SchoolSortByCriteriaNotMetException




  //The SchoolSortByCriteriaNotMetException class is triggered when the sorting criteria isn't met.

        class SchoolSortByCriteriaNotMetException extends Exception{
            public SchoolSortByCriteriaNotMetException(String direction){
            super(direction);
            }
      }

        public class Main {
            public static void main(String[] args) {
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

            SchoolInfo[] schools = {school1, school2, school3, school4, school5, school6, school7, school8, school9, school10, school11, school12, school13,                  school14, school15, school16, school17, school18, school19, school20};

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

4.Create a JAVA program to group the schools into
 Good
 Medium
 OK
 This grouping must be based on the parameters totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, 
 totalteacherappreciation

/*First we load the ARFF file and use the Kmeans Clustering algorithm to perform classification. Three clusters are generated and the schools belonging to the same clusters are grouped and put together into their respective arraylists, for instance the arraylist variable a0 contains school names present in cluster 0*/





        import weka.clusterers.SimpleKMeans;
        import weka.core.Attribute;
        import weka.core.Instances;
        import weka.core.converters.ConverterUtils;

        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.ArrayList;

        public class Classification {
        public static void main(String[] args) throws Exception {
        // Load the ARFF file
        Instances data = ConverterUtils.DataSource.read("C:\\Users\\ajayk" +
                "\\IdeaProjects\\ACI\\src\\Assignment1\\schoolssorted.arff");

        //select only from column 3 to the end
        Instances subsetData = new Instances(data, 3, data.numInstances() - 3);

        // Create the K-means clustering algorithm
        SimpleKMeans kMeans = new SimpleKMeans();
        kMeans.setNumClusters(3); // Set the number of clusters

        // Build the clusters
        kMeans.buildClusterer(subsetData);

        //Build an arrayList of 3 clusters

        //for cluster with label 0
        ArrayList<String> a0 = new ArrayList<>();

        //for cluster with label 1
        ArrayList<String> a1 = new ArrayList<>();

        //for cluster with label 2
        ArrayList<String> a2 = new ArrayList<>();

        // Assign instances to clusters
        for (int i = 0; i < data.numInstances(); i++) {
            int cluster = kMeans.clusterInstance(data.instance(i));
            Attribute firstAttribute = data.attribute(0);
            String name = firstAttribute.value(i);

            if (cluster == 0) {
                a0.add(name);
            }
            if (cluster == 1) {
                a1.add(name);
            }
            if (cluster == 2) {
                a2.add(name);
            }
        }
      }
    }
 
 5.Create a program which generates 3 PDFs, 1 PDF containing Good Schools, 2nd PDF containing Medium Schools and 3rd PDF containing OK schools. 
   During generation of PDF make sure there are 3 threads used should not be a single thread 

// The PDFCreationThread class extends Thread and is responsible for creating a PDF document from an ArrayList of strings, using the provided filename.
   It overrides the run() method to initialize a Document object, add paragraphs to it, and save it as a PDF file.






   
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.nio.file.Path;
    import java.nio.file.Paths;

    import com.itextpdf.text.Document;
    Import com.itextpdf.text.DocumentException;
    import com.itextpdf.text.Paragraph;
    import com.itextpdf.text.pdf.PdfWriter;

    class PDFCreationThread extends Thread {
    private ArrayList<String> arrayList;
    private String filename;
    public PDFCreationThread(ArrayList<String> arrayList, String filename) {
        this.arrayList = arrayList;
        this.filename = filename;
    }
    @Override
    public void run() {
        Document document = new Document();
        try {
            Path outputPath = Paths.get("C:\\Users\\ajayk\\IdeaProjects\\ACI\\src\\Assignment1\\" + filename);
            PdfWriter.getInstance(document, new FileOutputStream(outputPath.toFile()));
            document.open();
            for (String element : arrayList) {
                document.add(new Paragraph(element));
            }
            document.close();
            } catch (DocumentException | FileNotFoundException e) {
                  e.printStackTrace();
            }
        }
    }
// The objects of PDFCreationThread class has to be created in the "Classification " class's main method


        PDFCreationThread thread1 = new PDFCreationThread(a0, "okSchools.pdf");
        PDFCreationThread thread2 = new PDFCreationThread(a1, "mediumSchools.pdf");
        PDFCreationThread thread3 = new PDFCreationThread(a2, "goodSchools.pdf");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("PDF files created successfully.");
</div>
