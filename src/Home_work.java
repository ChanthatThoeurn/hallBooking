import java.util.Scanner;
public class Home_work {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double KHreil = 4100;
        int option;
        //int choose;
        enum DAY {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
            SATURDAY, SUNDAY
        }
        do {
            System.out.println("1. Wage Calculator");
            System.out.println("2. Money Exchange Program");
            // USD-> KHR
            // KHR -> USD -> RATE=4100
            System.out.println("5. Exit ");

            System.out.println("Choose (1 - 5) : ");
            option = input.nextInt();
            switch (option) {
                case 1: {
                    float hour;
                    float wage;
                    String day;
                    float result;
                    DAY enumDay;
                    // wages -> 10
                    // hours -> 2 , 3, 4,
                    // SAT, SUN -> result * 2
                    System.out.println("--------------<<<Wage Calculator>>>-------------");
                    System.out.println("Enter hour(hrs): ");
                    hour = input.nextFloat();
                    System.out.println("Enter wage($): ");
                    wage = input.nextFloat();
                    System.out.println("Enter day (ex. MONDAY,...,SUNDAY): ");
                    day = input.next().toUpperCase();
                    result = wage * hour;
                    // convert normal string to enum
                    enumDay = DAY.valueOf(day);
                    float finalResult= switch (enumDay){
                        case DAY.SATURDAY, DAY.SUNDAY -> result*2;
                        default -> result;
                    };

                    System.out.println("=======================");
                    System.out.println("Hour is : " + hour + "hrs");
                    System.out.println("Wage is : " + wage + "$/1hrs");
                    System.out.println("Day of work : " + day);
//                    System.out.println("Result is : " + (switch (enumDay) {
//                        case DAY.SATURDAY, DAY.SUNDAY -> result * 2;
//                        default -> result;
//                    }) + "$");
                    System.out.println("Result is : "+finalResult);
                    System.out.println("=======================");

                }
                break;
                case 2 :
                    int choose = 2;
                    Scanner chose = new Scanner(System.in);

                    System.out.println("Please input choose!");
                    System.out.println("1.Riel to USD");
                    System.out.println("2.USD to Riel");
                    int cho = chose.nextInt();
                   //
                    switch (cho){
                        case 1: {
                            Scanner money = new Scanner(System.in);
                            System.out.println("Pleas input your money ");
                            double mony = money.nextDouble();

                           double ex = mony / KHreil;
                            System.out.println("Your money is :" + ex + "USD");
                            break;
                        }
                        case 2:
                            Scanner money = new Scanner(System.in);
                            System.out.print("Pleas input your money ");
                            double mony = money.nextFloat();
                            double ex = KHreil * mony;
                            System.out.print("Your money is :"+ex +"Riel");
                            break;
                        default:
                            System.out.println("Invalid option!! Try again!");
                            break;
                    }
                    // this is where you write the money exchange code !!
                    break;
                default:
                    System.out.println("Invalid option!! Try again!");
                    break;
            }
        } while (option != 5);
    }
}
