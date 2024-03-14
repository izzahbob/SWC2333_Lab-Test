
/**
 * Description : make a list of emplory salaries for top performing and least service.
 *
 * Programmer : Ezzah
 * Date : 14 March 2024
 */

//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
//driver class
public class employeeSalary
{
    public static void main (String[]args) throws IOException
    {
        //instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");
        
        //try block
        try
        {
            //input file
            BufferedReader inputFile = new BufferedReader (new FileReader("employeeSalaries.txt"));
            //2 outputs file
            PrintWriter topPerform = new PrintWriter (new FileWriter ("topPerformingEmployee.txt"));
            PrintWriter leastService = new PrintWriter (new FileWriter ("leastServiceEmployee.txt"));
            PrintWriter empData = new PrintWriter (new FileWriter ("employeeData.txt"));
            
            //write the title of employee details to the topPerformingEmployee.txt
            topPerform.println("Top-Performing Employee");
            topPerform.println("\nName\t\t\tHighest Annual Salary");
            topPerform.println("*******************************************************");
            //write the title of employee details to the leastServiceEmployee.txt
            leastService.println("Employee with The Least Years of Service");
            leastService.println("\nName\t\t\tYears Service");
            leastService.println("*****************************************************");
            
            //declare the variables
            String inputData = null;
            String empName = "";
            double salary, annual = 0, highestSalary = 0;
            double lowestServiceYears = Double.MAX_VALUE;
            int yearService = 0;
            
            //while loop
            while ((inputData = inputFile.readLine())!=null)
            {
                //instantiate the object reference to the StringTokenizer class
                StringTokenizer sT = new StringTokenizer(inputData,"|");
                
                //break into tokens assign to the appropriate variables
                empName = sT.nextToken();
                salary = Double.parseDouble(sT.nextToken());
                yearService = Integer.parseInt(sT.nextToken());
                
                //calculate the annual salary a yearly
                annual = salary + (salary * 0.05);
                //top-performing employee based on the highest annual salary
                if (annual > highestSalary)
                {
                    highestSalary = annual;
                    topPerform.println(empName + "\t\t\t" + highestSalary);
                }
                //employee with the least years of service
                if (yearService < lowestServiceYears)
                {
                    lowestServiceYears = yearService;
                    leastService.println(empName + "\t\t\t" + lowestServiceYears);
                }  
                //display all employee data to the employeeData.txt
                empData.println("\nEmployee Datails - Salaries");
                empData.println("*****************************************************");
                empData.println("Name : " + empName);
                empData.println("Annual Salary : " + annual);
                empData.println("Years Service : " +yearService);
            }//end of while loop
            
            //close all input/output file
            inputFile.close();
            topPerform.close();
            leastService.close();
            empData.close();
            }//end of try block
        
        catch (FileNotFoundException ex){
            String output = "File not found!!";
            JOptionPane.showMessageDialog(null,output);
        }//end of catch
        catch (IllegalArgumentException ex) {
            String output = "Incorrect data format";
            JOptionPane.showMessageDialog(null,output);
        }//end of catch
    
    }//end of main class
}//end of driver class

