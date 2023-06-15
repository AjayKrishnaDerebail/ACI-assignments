package Assignment1;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    }
}