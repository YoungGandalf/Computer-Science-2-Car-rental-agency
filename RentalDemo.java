/*
@ Adam Hereth
CSC 201
Final Project
12/05/2017

Accept the following as input:
Contract number
Customer first and last name
Automobile's vehicle identification number
Starting date for the rental agreement stored as three separate variables – month, day, and year
Length, in days, of the rental agreement
Indicator of whether the customer bought the optional insurance policy
Display output as follows:
If the contract number is not between 10000 and 99999 inclusive, issue an error message and end the program
If the customer ID number is not between 100 and 999 inclusive, issue an error message and end the program
If the starting date for the rental agreement is invalid, issue an error message and end the program. (In other words, make sure the month is between 1 and 12, inclusive. If the month is 1, 3, 5, 7, 8, 10, and 12, the day must be between 1 and 31, inclusive. If the month is 2, the day must be between 1 and 28 inclusive. You do not need to check for leap years. If the month is 4, 6, 9, or 11, the day must be between 1 and 30, inclusive).
If the length of the rental agreement is not between 1 and 30 days inclusive, issue an error message and end the program. Otherwise, calculate the ending month, day, and year based on the starting date and length of the agreement.
The insurance indicator must be "Y" or "N" (for "Yes" or "No"); otherwise, display an error message;
If all the entered data is valid, display it along with the fee for the rental, which is calculated as follows:
$25 per day for 10 days or fewer
$18 per day, for each day over 10 days
$2.5 per day for insurance, regardless of the number of days in the contract.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class RentalDemo
{
    static int daysOfRental;
    static ArrayList<Car> carsOnLeaseList = new ArrayList<>();
    
    public static void main(String[] args)
    {
    //an array that stores car names and vin
        Car[] carsOnLot = new Car[10];
        carsOnLot[0] = new Car("Ferrari", 123);
        carsOnLot[1] = new Car("Lamborghini", 125);
        carsOnLot[2] = new Car("Maserati", 127);
        carsOnLot[3] = new Car("Alfa", 129);
        carsOnLot[4] = new Car("Mercedes", 131);
        carsOnLot[5] = new Car("BMW", 133);
        carsOnLot[6] = new Car("Porche", 135);
        carsOnLot[7] = new Car("Maybach", 137);
        carsOnLot[8] = new Car("Bently", 139);
        carsOnLot[9] = new Car("Rollsroyce", 141);
        ArrayList<Car> carsOnLotList = new ArrayList<>(10);
        // fills cars on lot list
        for (int i = 0; i < carsOnLot.length; i++)
        {
            carsOnLotList.add(i, carsOnLot[i]);
        }

        int creditScore, drivingRecord, month, day, year, option;
        String carWant;
        System.out.println("Welcome to Cost Is No Object Luxury car rental.\n");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("To confirm that you are eligible to rent a car from us we need\n\nto be sure your credit score and driving record are acceptable.\n");
        // loop executes while there are cars available for rental
        while (carsOnLotList != null)
        {
            System.out.println("Please enter your credit score.\nIt must 650 or more to rent from us.");
            creditScore = keyboard.nextInt();
            System.out.println("Please enter your driving record points.\nIt must be positive to rent from us.");
            drivingRecord = keyboard.nextInt();
            Customer customer = new Customer();
            System.out.println("Please enter your first name.");
            String first = keyboard.next();
            customer.setFirst(first);
            System.out.println("Please enter your last name.");
            String last = keyboard.next();
            customer.setLast(last);
            System.out.println("Please enter your ID number which must be between 100 and 999 inclusively.");
            int idNum = keyboard.nextInt();
            try
            {
                customer.setIdNum(idNum);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            
            System.out.println("How many days would you like to rent the car?");
            daysOfRental = keyboard.nextInt();
            try
              {
                  if(daysOfRental < 1 || daysOfRental > 30) 
                  {
                     throw new Exception("Rental period must be between 1 and 30 inclusively!");
                  }                
              }
            catch(Exception e)
            {
               System.out.println(e.getMessage() + " Goodbye!");
               System.exit(0); 
            }
            Contract contract = new Contract();
            if (creditScore < 650 || drivingRecord < 0)
            {
                System.out.println("Your credit score or driving record is too low to rent a car from us. " + "\nGoodbye!");
                System.exit(0);
            }
            do
            {     // prints option menu
                System.out.println("\nPress 1 to view and rent an available car.");
                System.out.println("Press 2 to view contract.");
                System.out.println("Press 3 to end the program");
                option = keyboard.nextInt();
                keyboard.nextLine();

                if (option == 1)
                {  
                    System.out.println("\nType the car that you want to rent then press enter.\n");
                    for (Car car : carsOnLotList)
                    {
                        System.out.println(car.getCarMake());
                    }
                    carWant = keyboard.nextLine();
                    boolean found = false;
                    // checks if car customer wants is available and moves it to lease list
                    for (Car car : carsOnLotList)
                    {
                        if (car.getCarMake().equalsIgnoreCase(carWant))
                        {
                            System.out.println("We found your car!");
                            carsOnLeaseList.add(car);
                            found = true;
                        }
                    }
                     // removes car chosen by user                    
                    carsOnLotList.removeAll(carsOnLeaseList);

                    if (!found)
                    { 
                        System.out.println("The car is not there or rented.");
                    }
                   // has user try to enter proper contract information
                   try
                   {
                        System.out.println("Enter a contract number between 10000 and 99999 inclusively.");
                        contract.setContractNumber(keyboard.nextInt());
                        System.out.println("Enter the date of the contract, month first, then day, then a 4 digit year.\n\n");
                        System.out.println("For example December 20 2017 would be entered \n12 enter \n20 enter \n2017 enter\n");
                        System.out.println("Month: "); 
                        month = keyboard.nextInt();
                        keyboard.nextLine();
                        
                        System.out.println("Day: ");
                        day = keyboard.nextInt();
                        keyboard.nextLine();
                        
                        System.out.println("Year: ");
                        year = keyboard.nextInt();
                        keyboard.nextLine();
                        
                        contract.setDate(day, month, year);                        
                        System.out.println("Press 1 (for yes) if you want insurance, press 2 (for no) if you decline insurance.");
                        int insurance = keyboard.nextInt();
                        if (insurance == 1)
                        {
                            contract.setInsuranceIndicator("Y");
                        }
                        else if (insurance == 2)
                        {
                            contract.setInsuranceIndicator("N");
                        }
                        else
                        {
                            throw new Exception("Invalid input.");
                        }
                        boolean goOn = true;
                        int option2;
                        // prints updated menu to view contract or exit program.
                        while(goOn)
                        {
                           System.out.println("Press 1 to view the contract.\nPress 2 to end the program.");
                           option2 = keyboard.nextInt();
                           keyboard.nextLine();
                           if(option2 == 1)
                           {
                              printContract(customer, contract);
                              goOn = false;
                           }
                           else if(option2 == 2)
                           {
                              System.out.println("Thank you for visiting Cost is no Object, have a nice day!");
                              System.exit(0);
                           }
                           else
                           {
                              System.out.println("Invalid input!\nPress 1 to view the contract.\nPress 2 to end the program."); 
                           }
                        }                                                
                   }
                    
                   catch (Exception e)
                   {
                       System.out.println(e.getMessage());
                   }                               
                }
                // option to print contract to console
                else if (option == 2)
                {
                     printContract(customer, contract);
                }
                // option to exit program
                else if (option == 3)
                {
                    System.out.println("Thank you for visiting Cost is no Object, have a nice day!");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Invalid input. Try again.");
                }
            }
            // asks if a customer would like to rent another car
            while (option != 3);
            {
                System.out.println("Would you like to rent another car? Please enter yes or no.");
                String answer = keyboard.next();
                if (answer.equalsIgnoreCase("Yes"))
                {
                    System.out.println("Please enter another customers information.");
                }
                else
                {
                    System.out.println("Thank you for visiting Cost is no Object, have a nice day!");
                    break;
                }
            }
        }
    }
            //method that prints the contract to the console 
             public static void printContract(Customer customer, Contract contract) 
             {
					  double	price;
					  String	insurance =	contract.getInsuranceIndicator();
					  if (daysOfRental <= 10) 
					  {
							price	= 25;
					  } 
					  else 
					  {
							price	= 18;
					  }
					  if (insurance.equalsIgnoreCase("Y"))  
					  {
							price	+=	2.5;
					  }
					  System.out.printf("The total price is for your rental is: $%4.2f", price);
					  System.out.println();
					  System.out.println("First name: "	+ customer.getFirst());
					  System.out.println("Last name: " + customer.getLast());
					  System.out.println("ID num: " + customer.getIdNum());
					  
                 
					  for	(Car car	: carsOnLeaseList)
					  {
							System.out.println("The car that you rented: " + car.getCarMake());
					  }
					  System.out.println("Contract number: " + contract.getContractNumber());
					  System.out.println("Contract start date: "	+ contract.getDate());
					  System.out.println("Insurance: " + contract.getInsuranceIndicator());
                 System.out.println("Please return the car in " +  daysOfRental + " day/s.");
             }    
}
