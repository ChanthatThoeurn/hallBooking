import java.util.Scanner;

public class Array_two {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row , col , option;
        int florNum, roomNum;
        System.out.println("Pleas input floor :");
        row = scanner.nextInt();
        System.out.println("Pleas input room  :");
        col = scanner.nextInt();
        String[][] Horse = new String[row][col];
        do {
            System.out.println("------------------");
            System.out.println("-- 1.BUY HORSE  --");
            System.out.println("-- 2.BUY ROOM   --");
            System.out.println("-- 3.SHOW HORSE --");
            System.out.println("-- 4.Exit      --");


            System.out.println("Please choice option (1-4): ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("===>| Buy horse |<====");
                    System.out.println("Enter the floor number :(1-"+row+")");
                    florNum = scanner.nextInt();
                    System.out.println("Enter the room number :(1-"+col+")");
                    roomNum = scanner.nextInt();

                    System.out.println("Please input name to buy horse :");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    Horse[florNum-1][roomNum-1]  = name;

                    break;

                case 2:
                    System.out.println("===>| Buy room |<======");
                    break;
                case 3:
                    System.out.println("SHOW HORSE: ");

                    for (int i = 0; i < row; i++){
                        for (int j = 0; j < col; j++){
                            System.out.print(Horse[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Exit the horse !");
                    break;
            }



        }while(option!=4);




    }
}
