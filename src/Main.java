import Services.FileHandlerService;
import Services.FileProcessingService;
import Services.MathService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args)
  {
    String path = "src/txt files/nums.txt";
    String outputFilePath = "src/txt files/answer.txt";

    FileHandlerService fileHandler = FileHandlerService.GetInstance();

    try
    {
      var file = fileHandler.OpenFile(path);

      FileProcessingService fileProcessingService = FileProcessingService.GetInstance();
      var numsList = fileProcessingService.GetListFromBufferedReader(file);

      MathService mathService = MathService.GetInstance();
      String result = mathService.GetSumAndAverageAsString(numsList);

      if (fileHandler.WriteToDisk(outputFilePath, result)) {
        System.out.println("Successfully written to: " + outputFilePath);
      } else {
        System.out.println("Failed to write file to disk.");
      }

    } catch (FileNotFoundException e){
      System.out.println("File not found: " + e.getMessage());
    } catch (IOException e){
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}
