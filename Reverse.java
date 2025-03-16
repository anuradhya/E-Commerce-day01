import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        int middle = number/2;
        for (int i = 1; i <= number; i++ ){
        if(i <= middle)
        {
          System.out.print((middle-i+1)+" ");  
        }
        else
        {
           if(i == middle + 1)  
           {
              System.out.print(i+" ");  
           }
           else
           {
              System.out.print((number - i+ middle + 2) +" "); 
           }
        }
        }
        System.out.println();
    }
}
