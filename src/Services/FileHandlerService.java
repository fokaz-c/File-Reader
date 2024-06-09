package Services;

import java.io.*;

public class FileHandlerService
{


  private FileHandlerService() {}

  private static FileHandlerService _instance;

  /**
   * Returns an instance of the FileHandlerService class following the Singleton design pattern.
   * This method ensures that only one instance of the FileHandlerService class is created
   * throughout the application's lifecycle. If no instance exists, it creates a new instance;
   * otherwise, it returns the existing instance.
   *
   * @return The singleton instance of the FileHandlerService class.
   */
  public static FileHandlerService GetInstance()
  {
    if (_instance == null){
      _instance = new FileHandlerService();
    }
    return _instance;
  }

  /**
   * Opens a file located at the specified path for reading.
   * This method attempts to open the file located at the specified path for reading.
   * If the file exists, it creates a FileReader object to read from the file and returns it.
   * If the file does not exist or cannot be opened for reading, a FileNotFoundException is thrown.
   *
   * @param path The path to the file to be opened.
   * @return A FileReader object representing the opened file for reading.
   * @throws FileNotFoundException If the file does not exist or cannot be opened for reading.
   */
  public FileReader OpenFile(String path) throws FileNotFoundException
  {
    //Try-Catch in main for controlling the flow
    final File _file = new File(path);
    final FileReader fileReader = new FileReader(_file);
    return fileReader;
  }

  /**
   * Writes content to a file located at the specified path.
   * This method attempts to write the specified content to a file located at the specified path.
   * If the file does not exist, it creates a new file. If the file exists, its previous content
   * will be overwritten. The method returns true if the write operation is successful; otherwise,
   * it returns false.
   *
   * @param path    The path to the file where the content will be written.
   * @param content The content to be written to the file.
   * @return true if the content is successfully written to the file; otherwise, false.
   */

  public boolean WriteToDisk(String path, String content)
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
      writer.write(content);
    } catch (IOException e){
      return false;
    }
    return true;
  }

}