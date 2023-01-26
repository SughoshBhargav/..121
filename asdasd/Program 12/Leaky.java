//Write a program for congestion control using leaky bucket algorithm.

import java.io.*;
import java.util.Scanner;
class Leaky
{
     public static int min(int x, int y)
     {
         if(x < y)
            return x;
         else
            return y;
     }
     public static void main(String args[])
     {
         Scanner sc = new Scanner(System.in);
         int drop = 0, mini, n, cap, count = 0, i;
         int inp[] = new int [25];
         int process;
         System.out.println("Enter the bucket size: ");
         cap = sc.nextInt();
         System.out.println("Enter the output rate: ");
         process = sc.nextInt();
         System.out.println("Enter the number of packets: ");
         n = sc.nextInt();
         System.out.println("Enter the size of packets to be sent: ");
         for(i = 0; i < n; i++)
         {
            inp[i] = sc.nextInt();
         }
         System.out.println("\nSecond|Packet Received|Packet Sent|Packet Left|Packet Dropped|\n");
         System.out.println("----------------------------------------------------------------\n");
         for(i = 0; i < n; i++)
         {
            count += inp[i];
            if(count > cap)
            {
               drop = count - cap;
               count = cap;
            }
            System.out.print(i + 1);
            System.out.print("\t" + inp[i]);
            mini = min(count, process);
            System.out.print("\t\t" + mini);
            count = count - mini;
            System.out.print("\t\t" + count);
            System.out.println("\t\t" + drop);
            drop = 0;
         }
         for( ; count != 0; i++)
         {
            if(count > cap)
            {
               drop = count - cap;
               count = cap;
            }
            System.out.print(i + 1);
            System.out.print("\t0");
            mini = min(count, process);
            System.out.print("\t\t" + mini);
            count = count - mini;
            System.out.print("\t\t" + count);
            System.out.println("\t\t" + drop);
         }
    }
}
