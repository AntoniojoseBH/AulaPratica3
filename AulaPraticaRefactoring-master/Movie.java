import java.util.Enumeration;
import java.util.Vector;

public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;
  
    private String _title;
    private Price _price;
    private int _daysRented;
    private Movie _movie;
    private Vector _rentals = new Vector();
  
    public Movie(String name, int priceCode) {
        _title = name;
        setPriceCode(priceCode);
     }
  
     public int getPriceCode() {
        return _price.getPriceCode();
     }
  
     public void setPriceCode(int arg) {
        switch (arg) {
           case REGULAR:
              _price = new RegularPrice();
              break;
           case CHILDRENS:
              _price = new ChildrensPrice();
              break;
           case NEW_RELEASE:
              _price = new NewReleasePrice();
              break;
           default:
              throw new IllegalArgumentException("Incorrect Price Code");
        }
     }    
  
    public String getTitle (){
        return _title;
    }

    public double getCharge(int daysRented){
        double thisAmount = 0.0;
     switch (this.getMovie().getPriceCode()) {
         case Movie.REGULAR:
           thisAmount += 2;
            if (this.getDaysRented() > 2)
               thisAmount += (this.getDaysRented() - 2) * 1.5;
            break;
         case Movie.NEW_RELEASE:
            thisAmount += this.getDaysRented() * 3;
            break;
         case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (this.getDaysRented() > 3)
               thisAmount += (this.getDaysRented() - 3) * 1.5;
             break;
      }
     return thisAmount;
 
    }

    private int getDaysRented() {
        return _daysRented;
    }

    private Movie getMovie() {
        return _movie;
    }

    public int getFrequentRenterPoints(int daysRented) { 
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
     }
  }