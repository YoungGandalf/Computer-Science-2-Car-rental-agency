/*
@ Adam Hereth
CSC 201
Final Project
12/05/2017

This class passes and manipulates contract data which is
entered by the user in the RentalDemo class (driver).
*/
public class Contract
{
   private int contractNumber = 0;
   private int month = 0;
   private int day = 0;
   private int year = 0;
   private int rentalLength = 0;
   private String insuranceIndicator;
   // sets contract number
   public void setContractNumber(int contractNumber) throws Exception
   {
      if(contractNumber < 10000 || contractNumber > 99999)
         throw new Exception("You have entered an invalid contract number.");
      else
         this.contractNumber = contractNumber;
   }
   // returns contract number
   public int getContractNumber()
   {
      return contractNumber;
   }
   // sets the contract date and throws exceptions
   public void setDate(int day, int month, int year) throws Exception
   {
      int maxDay;
      if (month == 1 || month == 3 || month == 5 ||
          month == 7 || month == 8 || month == 10 ||
          month == 12)
      {
          maxDay = 31;
      }
      else if (month == 2)
      {
         maxDay = 28;
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
         maxDay = 30;
      }
      else
      {
         throw new Exception("Invalid month.");
      }
      
      if(day < 1 || day > maxDay)
         throw new Exception("Invalid day.");
      else
         this.day = day;
         
      if (month < 1 || month > 12)
         throw new Exception("Invalid month");
      else
         this.month = month;
         
      if(year < 2017)
         throw new Exception("Invalid year.");
      else
         this.year = year;
   }
   // returns the date in string form
   public String getDate()
   {
      return month + "/" + day + "/" + year;
   }
   
   // sets insurance indicator   
   public void setInsuranceIndicator(String insuranceIndicator)
   {
      this.insuranceIndicator = insuranceIndicator;
   }
   
   public String getInsuranceIndicator()
   {
      return insuranceIndicator;
   }
}