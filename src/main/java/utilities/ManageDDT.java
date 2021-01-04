package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps
{
    /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: getDataObject
    Method description: This method send path for the CSV file and return a list, Every line in the list is a line in the CSV file
    Method parameters: null
    Method return: Object
    */
    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject()
    {
        return getDataFromCSV(getData("DDTFiles"));
    }
    public static List<String> readCSV(String csvFile)
    {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            System.out.println("Some errors, see details - "+e);
        }
        return lines;
    }

        /*
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Method name: getDataFromCSV
    Method description: This method get the file path and return list from "readCsv" method
    Method parameters: null
    Method return: Object
    */
    public static Object[][] getDataFromCSV(String filePath)
    {
        Object[][] data = new Object[3][2]; // for this project its hard coded
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i<csvData.size();i++)
        {
            data[i][0]=csvData.get(i).split(",")[0];//get the FIRST word
            data[i][1]=csvData.get(i).split(",")[1];//get the SECOND word
        }
        return data;
    }
}
