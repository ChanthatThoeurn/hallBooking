import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.awt.*;
public class Home_work_hall_Booking {
    public static void list(){
            System.out.println("[1].Setup hall !");
            System.out.println("[2].Hall booking ");
            System.out.println("[3].Cancel booking");
            System.out.println("[4].Show seat of hall !");
            System.out.println("[5].Exit of hall ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("======>| Welcome to my Cinema |<========");
        System.out.println("========================================");
        int option ;
        int row = 0;
        int col = 0;
        String[][] seatSetup = null;
        LocalDate today = LocalDate.now();
        String bookingDate = today.toString();
        String cancelDate = today.toString();
        do {
                list();
            while (true){
                System.out.println(" [+] Please input option:");
                if (scanner.hasNextInt()){
                    option = scanner.nextInt();
                    if (option>=1 && option<=5){
                        break;
                    }else {
                        System.out.println("not option");
                    }
                }else {
                    System.out.println("[+] Pleas input positive number ");
                    scanner.nextLine();
                }
            }

            switch (option){
                case 1:{
                    System.out.println("============================");
                    System.out.println("|| ==== [+] Setup hall === ||");
                    System.out.println("============================");
                    while (true){
                        System.out.println("[+] Please input row seat : ");
                        if (scanner.hasNextInt()){
                            row = scanner.nextInt();
                            if (row>=1 && row<=5){
                                break;
                            }else {
                                System.out.println("no row");
                            }
                        }else {
                            System.out.println("[+] Pleas input positive number ");
                            scanner.nextLine();

                        }
                    }
                  //1  System.out.println("[+] Please input col seat : ");
                    while (true){
                        System.out.println("[+] Please input col seat : ");
                        if (scanner.hasNextInt()){
                            col = scanner.nextInt();
                            if (col>=1 && col<=5){
                                break;
                            }else {
                                System.out.println("no col");
                            }
                        }else {
                            System.out.println("[+] Pleas input positive number ");
                            scanner.nextLine();
                        }
                    }
                    char letter = 'A';
                    seatSetup = new String[row][col];
                    for (int i =0; i<row; i++){
                        for (int j = 0; j<col; j++){
                            seatSetup[i][j] = letter + "-"+ (j+1) + ": AV";
                        }
                        letter++;
                    }
                    break;
                }
                case 2: {
                    while (true) {
                        if (seatSetup == null) {
                            System.out.println("Please setup hall firs ! ");
                            break;
                        }
                        for (String[] rows : seatSetup) {
                            System.out.print("[");
                            for (int j = 0; j < rows.length; j++) {
                                System.out.print("\u001B[92m" + rows[j] + "\u001B[0m");
                                if (j < rows.length - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println("]");
                        }
                        System.out.println("||===============================================================||");
                        System.out.println("||== [+] Input seat you want to booking [A-1] or Type (back)   ==||");
                        System.out.println("||===============================================================||");
                        String bookSeat = scanner.next();
                        bookSeat = bookSeat.toUpperCase();
                        if (bookSeat.equalsIgnoreCase("back")) {
                            System.out.println("return to menu");
                            break;
                        }
                        boolean booking = false;
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < row; j++) {
                                if (seatSetup[i][j].startsWith(bookSeat) && seatSetup[i][j].endsWith("AV")) {
                                    seatSetup[i][j] =  "\u001B[31m" + bookSeat +": BO "  + bookingDate + "\u001B[0m";
                                    System.out.println("The seat " + bookSeat + "has been booked successfully");
                                    booking = true;
                                    break;
                                }
                            }
                            if (booking) break;
                        }
                        if (!booking) {
                            System.out.println("This seat " + bookSeat + " is invalid or ready book! ");
                            continue;
                        }
                        String choice;
                        System.out.println("Do you want to book more? (Y/N)");
                        choice = scanner.next();
                        if (choice.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                }
                case 3:
                    while (true) {
                        System.out.println("||=========================||");
                        System.out.println("||===  [+] Cancel Seat  ===||");
                        System.out.println("||=========================||");
                        assert seatSetup != null;
                        for (String[] rows : seatSetup) {
                            System.out.print("[");
                            for (int j = 0; j < rows.length; j++) {
                                System.out.print("\u001B[92m" + rows[j] + "\u001B[0m");
                                if (j < rows.length - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println("]");
                        }
                        System.out.println("||=====================================================================||");
                        System.out.println("||======  [+] Cancel seat you want to  [A-1] type (back) to return =======||");
                        System.out.println("||======================================================================||");
                        String bookSeat = scanner.next();
                        bookSeat = bookSeat.toUpperCase();
                        if (bookSeat.equalsIgnoreCase("back")){
                            System.out.println("return manu");
                            break;
                        }
                        boolean cancel = false;
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < row; j++) {
                                if (seatSetup[i][j].startsWith("\u001B[31m"+bookSeat) && seatSetup[i][j].endsWith("BO " + bookingDate+ "\u001B[0m")) {
                                    seatSetup[i][j] =bookSeat + ": AV";
                                    System.out.println("The seat " + bookSeat + "has been cancel successfully");
                                    cancel = true;
                                    break;
                                }
                            }
                            if (cancel) break;
                        }
                        if (!cancel) {
                            System.out.println("This seat " + cancel + " is cancel already or invalid ! ");
                            continue;
                        }
                        String choice;
                        System.out.println("Do you want to cancel more? (Y/N)");
                        choice = scanner.next();
                        if (choice.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                case 4: {
                    assert seatSetup != null;
                    for (String[] rows: seatSetup ){
                        System.out.print("[");
                        for (int j = 0; j<rows.length; j++){
                            System.out.print("\u001B[92m" + rows[j] + "\u001B[0m");
                            if (j< rows.length -1){
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                    }
                    int totalBooking = 0;
                    for (String[] rows: seatSetup){
                        for (String seats: rows) {
                            if (seats.contains("BO")) {
                                totalBooking++;
                                System.out.println("||=====================================||");
                                System.out.println("||======= [+] Seat: " + seats + "  ====||");
                                System.out.println("||=====================================||");
                            }
                        }
                    }
                    if (totalBooking==0){
                        System.out.println("No seat BO: ");
                    }else{
                        System.out.println("Total seat BO = "+ totalBooking);
                    }
                    System.out.println("Total: AV =" + ((row*col)-totalBooking));
                }
                default:
                    System.out.println("Tanks for checking my hall !");
            }
        }while (option != 5);
    }
}
