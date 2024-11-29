
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gender;


//            System.out.print("Enter your gender (M/F): ");
//            gender = scanner.nextLine();
//
//            if(gender.equals("f")  || ((gender.equals("F")))){
//                System.out.println("You are is female"+" Hello madam");
//            } else if(gender.equals("m")  || (gender.equals("M") )){
//                System.out.println("you are is male"+" Hello boy");
//            }else {
//                System.out.println(" No option pleas try again");
//            }
//         Ternary operator
//        char sx;
//        System.out.println(" Pls Input ur gender: ");
//        sx = scanner.next().charAt(0);
//        String gender = (sx == 'f')? " Female" :
//                (sx == 'm')? " Meal " : "Non";
//        System.out.println("your are   "+gender + " Hello " + ((sx=='m')? "Men": (sx=='f')?"Madam" : "Hello there"));


        int option =3;
        int choose =3;
        int two = 3;
        double money ;
        double Kh = 4100;
        do {
            System.out.println("Pleas input option");
            System.out.println("1.Buy something ");
            System.out.println("2.Exchange money");
                option = scanner.nextInt();
                switch (option){
                    case 1:{


                            System.out.println("1.Rice with shop");
                            System.out.println("2.Rice with chicken");
                            choose = scanner.nextInt();
                                switch (choose){
                                    case 1:{
                                        System.out.println("You Buy Rice with shop! Tanks");
                                        break;
                                    }
                                    case 2:{
                                        System.out.println("You buy Rice with chicken");
                                        break;
                                    }
                                    default:
                                        System.out.println("Sorry is not try again!");
                                        break;
                                }
                        break;
                    }
                    case 2:{
                        System.out.println("1.Khmer -> USD");
                        System.out.println("2.USD -> Khmer");
                        two = scanner.nextInt();
                        switch (two){
                            case 1:{

                                System.out.print("Please input your money (KH): ");
                                money =scanner.nextInt();
                                Kh = money / Kh;
                                System.out.println("your money is :"+ Kh +" USD");
                            }
                            case 2:{
                                System.out.print("Please input your money (USD): ");
                                money =scanner.nextInt();
                                Kh = money * Kh;
                                System.out.println("Your money is :"+ Kh +" Riel");
                            }
                            default:
                                System.out.println("Sorry not option pleas try again");
                        }
                    }

                }
        }while(option != 5);


        
    }
}
