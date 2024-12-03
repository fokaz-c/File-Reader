# File Processing Application.

This project is a simple file processing application written in Java. It reads numbers from a text file, calculates their sum and average, and writes the result to an output file.

## Features

- **File Handling**: Opens and reads from a specified text file containing numbers.
- **Data Processing**: Extracts a list of numbers from the file and computes their sum and average.
- **Result Writing**: Outputs the calculated sum and average to a specified output file.

## Project Structure

The project consists of the following main services:

- `FileHandlerService`: Handles file operations such as opening, reading, and writing files.
- `FileProcessingService`: Processes the content of files, converting data into usable formats.
- `MathService`: Performs mathematical operations, including calculating the sum and average of a list of numbers.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- A basic understanding of Java and its file I/O operations.

## Usage

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/fokaz-c/File-Reader.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd File-Reader
   ```

3. **Compile the Project**:
   ```bash
   javac -d bin -sourcepath src src/Main.java
   ```

4. **Run the Application**:
   ```bash
   java -cp bin Main
   ```

   By default, the application reads numbers from `src/txt files/nums.txt` and writes the result to `src/txt files/answer.txt`.

## Error Handling

- The application catches and handles `FileNotFoundException` if the input file is not found.
- Handles `IOException` during file reading and writing processes.

## Customization

- **Input File**: Change the `path` variable in the `Main` class to point to a different input file.
- **Output File**: Change the `outputFilePath` variable in the `Main` class to specify a different output location.
