import java.util.Scanner;
import java.util.ArrayList;
public class busResv {
    public static void main(String[] args) {
        //creating listobjects for bus class
        ArrayList<Bus> busses = new ArrayList<Bus>();//busses is listoject
        //array list for booking object
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        busses.add(new Bus(1, true, 1));
        busses.add(new Bus(2, false, 50));
        busses.add(new Bus(3, true, 55));
        int opt = 1;
        Scanner sc = new Scanner(System.in);
        for (Bus b : busses) {
            b.displayBusInfo();
        }
        while (opt == 1) {
            System.out.println("Enter 1 to book and 2 to exit");
            opt = sc.nextInt();
            if (opt == 1) {
                Booking booking = new Booking();
                if (booking.isAvailable(bookings, busses)) {
                    bookings.add(booking);
                    System.out.println("your booking is conformed");
                } else {
                    System.out.println("Bus is full,please try another bus.");
                }
            }
        }
    }
}
