package activities;

interface BicycleParts
{
	public int tyres=2;
	public int maxSpeed=209;
	
}
interface BicycleOperations 
{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}

class Bicycle implements BicycleParts , BicycleOperations
{
	public int gears;
    public int currentSpeed;

    //the Bicycle class has one constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
  //Bicycle class has three methods
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Current speed: " + currentSpeed);
    }

    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Current speed: " + currentSpeed);
    }
  //Method to print info of Bicycle
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
    }
    
}
//Derived class
class MountainBike extends Bicycle {

    //The MountainBike subclass adds one more field
    public int seatHeight;

    //The MountainBike subclass has one constructor
    public MountainBike(int gears, int currentSpeed, int HeightInp) {
        //Invoking base-class(Bicycle) constructor
        super(gears, currentSpeed);
        this.seatHeight = HeightInp;
    }
 // the MountainBike subclass adds one more method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }  
}

public class Activity7 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike mb = new MountainBike(1, 2, 3);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
	}

}
