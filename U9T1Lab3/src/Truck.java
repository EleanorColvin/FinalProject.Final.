public class Truck extends Vehicle
{
  private int axles;
  private boolean hasTrailer;
  
  public Truck(String licensePlate, double tollFee, int passengers, int axles, boolean hasTrailer)
  {
    super(licensePlate, tollFee, passengers);
    this.axles = axles;
    this.hasTrailer = hasTrailer;
  }

  public void printTruck()
  {
    System.out.println("License Plate:" + getLicensePlate());
    System.out.println("Toll fee: " + getTollFee());
    System.out.println("Passengers: " + getPassengers());
    System.out.println("Number of axles: " + axles);
    System.out.println("Has trailer? " + hasTrailer);
  }

  public boolean validateLicensePlate()
  {
    int length = getLicensePlate().length();
    if (hasTrailer)
    {
      boolean valid = (axles > 4 && getLicensePlate().substring(length - 2).equals("MX") || axles <= 4 && getLicensePlate().substring(length - 2).equals("LX"));
      return valid;
    }
    else
    {
      return true;
    }
  }

}