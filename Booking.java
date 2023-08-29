import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
    String passengerName;
    int busno;
    Date date;

    Booking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        passengerName = scanner.next();
        System.out.println("Enter busno:");
        busno = scanner.nextInt();
        System.out.println("Enter date dd-mm-yyyy:");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> busses) {
        int capacity = 0;
        for (Bus bus : busses) {
            if (bus.getBusno() == busno) {
                capacity = bus.getCapacity();
            }
        }
        if(capacity==0){
            System.out.println("there is no busno" + busno);
            return false;
        }
        int booked = 0;
        for (Booking b : bookings) {
            if(b.busno == busno && b.date.equals(date)) {
                booked++;
            }

        } return booked<capacity?true:false;
    }
}



