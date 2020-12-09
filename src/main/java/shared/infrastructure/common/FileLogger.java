package shared.infrastructure.common;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class FileLogger {
  

    
      public  void log(String log ) {
        //crear archivo
        try {
          File myObj = new File("src\\main\\java\\application\\log.txt");
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    //escribir en archivo
        try {
            FileWriter myWriter = new FileWriter("src\\main\\java\\application\\log.txt");
            myWriter.write(log);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
      
   
   
        }
    }
      
        

      //crear carpeta de logs(si no existe)
      //crear archivo log(es el que recibe el string de console log) al crearlo le ponemos de nombrela fecha
      //crear el archivo en java, escribir el contenido y cerrar archivo
      //