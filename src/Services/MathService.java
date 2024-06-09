package Services;

import java.util.ArrayList;

public class MathService {

  private static MathService _instance;

  /**
   * Returns an instance of the MathService class following the Singleton design pattern.
   * This method ensures that only one instance of the MathService class is created
   * throughout the application's lifecycle. If no instance exists, it creates a new instance;
   * otherwise, it returns the existing instance.
   *
   * @return The singleton instance of the MathService class.
   */
  public static MathService GetInstance()
  {
    if (_instance == null) {
      _instance = new MathService();
    }
    return _instance;
  }

  public int CalculateSum(ArrayList<Integer> numsList)
  {
    int sum = 0;
    for (Integer currentNo : numsList) {
      sum += currentNo;
    }
    return sum;
  }

  public double CalculateAverage(int sum, int quantity) {return (double) sum / quantity;}

  /**
   * Generates a string representation of the sum and average of integers in the given ArrayList.
   * This method calculates the sum of the integers in the ArrayList, then calculates the average.
   * It returns a string containing the sum and average values formatted for display.
   * If an exception occurs during the calculation (e.g., division by zero), it returns "Invalid or Empty".
   *
   * @param numsList The ArrayList containing integers.
   * @return A string representation of the sum and average of the integers in the ArrayList.
   */
  public String GetSumAndAverageAsString(ArrayList<Integer> numsList)
  {
    int sum = CalculateSum(numsList);
    try
    {
      double average = CalculateAverage(sum, numsList.size());
      return "Sum: " + sum + "\nAverage: " + average;
    } catch (Exception e){
      return "Invalid or Empty";
    }
  }


}
