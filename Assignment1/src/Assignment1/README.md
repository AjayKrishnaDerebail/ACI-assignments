<div align="left">
Consider you are a company who are helping parents choose the right school for their kids. Find the best schools based on sports events, cultural events, fees, and teacher feedback. In
order to achieve this we need to perform the following.
  
  
1.Create a POJO object in which represents parents or any person who is trying to search for a good school .Name, phoneno, email

  
  public class Parent {
    private String name;
    private long phone_no;
    private String email;

    public Parent() {
    }

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
  
3.Create an JAVA program which takes the sort by - totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, 
  totalteacherappreciation And sort direction -ascending or descending. If the user does not provide one of the sort by then throw a custom exception
  SchoolSortByCriteriaNotMetException




  //The SchoolSortByCriteriaNotMetException class is triggered when the sorting criteria isn't met.

        class SchoolSortByCriteriaNotMetException extends Exception{
            public SchoolSortByCriteriaNotMetException(String direction){
            super(direction);
            }
      }

4.Create a JAVA program to group the schools into
 Good
 Medium
 OK
 This grouping must be based on the parameters totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, 
 totalteacherappreciation

/*First we load the ARFF file and use the Kmeans Clustering algorithm to perform classification. Three clusters are generated and the schools belonging to the same clusters are grouped and put together into their respective arraylists, for instance cluster 0 is up into an arraylist variable a0 */





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
