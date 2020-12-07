/*
@ Adam Hereth
CSC 201
Final Project
12/05/2017

This class passes and manipulates car data which is
entered by the user in the RentalDemo class (driver).
*/
public class Car
{
   private String carMake;
   private int vin;
   //default constructor 
   public Car()
   {
      carMake = null;
      vin = 0;
   }
   //constructor that passes 2 arguements 
   public Car(String carMake, int vin)
   {
      this.carMake = carMake;
      this.vin = vin;
   }

   public String getCarMake()
   {
      return carMake;
   }

   public void setCarMake(String carMake)
   {
      this.carMake = carMake;
   }

   public int getVin()
   {
      return vin;
   }

   public void setVin(int vin)
   {
      this.vin = vin;
   }
}