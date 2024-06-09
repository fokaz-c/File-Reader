package Services;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileProcessingService
{
  private static FileProcessingService _instance;

  private FileProcessingService() {}

  /**
   * Returns an instance of the FileProcessingService class following the Singleton design pattern.
   * This method ensures that only one instance of the FileProcessingService class is created
   * throughout the application's lifecycle. If no instance exists, it creates a new instance;
   * otherwise, it returns the existing instance.
   *
   * @return The singleton instance of the FileProcessingService class.
   */
  public static FileProcessingService GetInstance()
  {
    if (_instance == null){
      _instance = new FileProcessingService();
    }
    return _instance;
  }

  /**
   * Extracts a list of integers from the text content of a file provided by a FileReader.
   * This method reads the text content line by line using a BufferedReader and extracts
   * integer numbers from the lines. It then returns an ArrayList containing all the
   * extracted integer numbers.
   *
   * @param fileReader A FileReader object providing access to the file to be read.
   * @return An ArrayList containing the integer numbers extracted from the file.
   */
  public ArrayList<Integer> GetListFromBufferedReader(FileReader fileReader) throws IOException
  {
    ArrayList<Integer> numsList = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    StringBuilder textContent = new StringBuilder();
    String line;

    while ((line = bufferedReader.readLine()) != null){
      textContent.append(line).append("\n");
    }

    String wholeText = textContent.toString();

    String currentNum = "";
    for (char c : wholeText.toCharArray()){
      if (Character.isDigit(c) || c == '-'){
        currentNum = currentNum + c;
      } else if (!currentNum.isEmpty()){
        try{
          numsList.add(Integer.parseInt(currentNum));
        }catch (Exception e){
          //ignore
        }
        currentNum = "";
      }
    }

    if (!currentNum.isEmpty()){
      numsList.add(Integer.parseInt(currentNum));
    }

    bufferedReader.close();
    return numsList;
  }
}
