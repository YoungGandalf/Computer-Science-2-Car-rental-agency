/*
@ Adam Hereth
CSC 201
Final Project
12/05/2017

This class passes and manipulates customer data which is
entered by the user in the RentalDemo class (driver).
*/
import java.util.Scanner;
public class Customer
{
   private String first;
   private String last; 
   private int idNum;
   
   public Customer()
   {
      first = "no first name";
      last = "no last name";
      idNum = 0;
   }  
   //constructor that passes 3 arguements and throws an exception when ID number is out of range 
   public Customer(String first, String last, int idNum) throws Exception
   {
      this.first = first;
      this.last = last;
      
      if((idNum < 000) || (idNum > 999))
      {
         throw new Exception("ID number out of range. This program will exit now.");
      }
      else
          this.idNum = idNum;
   }
   // sets first name
   public void setFirst(String first) 
   {
      this.first = first;
   }
   // sets last name
   public void setLast(String last) 
   {
      this.last = last;
   }
   //sets the ID number and throws an exception when out of range
   public void setIdNum(int idNum) throws Exception
   {
      if((idNum < 000) || (idNum > 999))
      {
         throw new Exception("ID number out of range. This program will exit now.");
      }
      else
         this.idNum = idNum;
   }
   // returns first name
   public String getFirst()
   {
      return first;
   }
   // returns last name
   public String getLast()
   {
      return last;
   }
   // returns id number
   public int getIdNum()
   {
      return idNum;
   }
}
