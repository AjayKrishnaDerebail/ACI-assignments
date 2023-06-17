package Assignment1;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;
import java.io.File;

public class CsvToArff {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\ajayk\\IdeaProjects\\ACI\\src\\Assignment1\\schoolsorted.csv"; 
        String arffFile = "C:\\Users\\ajayk\\IdeaProjects\\ACI\\src\\Assignment1\\schoolssorted.arff"; 
        try {
            // Load the CSV file using Weka's CSVLoader
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(csvFile));
            Instances data = loader.getDataSet();

            // Save the data to ARFF file
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(arffFile));
            saver.writeBatch();

            System.out.println("CSV to ARFF conversion completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
