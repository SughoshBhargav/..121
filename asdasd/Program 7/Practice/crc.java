import java.util.*;
import java.net.*;
public class crc
{
	public static void main(String args[])
	{
		int i, j, n, g, check, flag, s, a;
		int arr[] = new int[30], gen[] = new int[20], b[] = new int[20], q[] = new int[20], x[] = new int[20];
		check = 0;
		flag = 0;
		System.out.println("*****CYCLIC REDUNDANCY CHECK*****");
		System.out.println("Transmitter side: ");
		System.out.println("Enter the number of data bits: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Enter the data to be sent: ");
		for(i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println("Enter the divisor bits: ");
		g = sc.nextInt();	
		do
		{
			System.out.println("Enter the generator data: ");
			for(j = 0; j < g; j++)
				gen[j] = sc.nextInt();
		}while(gen[0] != 1);
		System.out.println("The divisor is ");
		for(j = 0; j < g; j++)
			System.out.println(gen[j]);
		a = n + (g - 1);
		System.out.println("The transmitter side data is ");
		for(i = 0; i < j; i++)
			arr[n + i] = 0;
		for(i = 0; i < a; i++)
			System.out.print(arr[i]);
		System.out.println();
		for(i = 0; i < n; i++)
			q[i] = arr[i];
		for(i = 0; i < n; i++)
		{
			if(arr[i] == 0)
			{
				for(j = i; j < g; j++)
					arr[j] = arr[j] ^ 0;
			}
			else
			{
				for(int k = 0; k < 17; k++)
					arr[i + k] = arr[i + k] ^ gen[k];
			}
		}
		System.out.println("The CRC at the sender is ");
		for(i = n; i < a; i++)
			System.out.println(arr[i]);
		for(i = n; i < a; i++)
			q[i] = arr[i];
		System.out.println();
		System.out.println("Receiver side: ");
		System.out.println("Enter the number of data bits received: ");
		n = sc.nextInt();
		System.out.println("Enter the data received: ");
		for(i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for(i = n; i < a; i++)
			for(j = g - 1; j < 0; j--)
				arr[i] = q[j];
		System.out.println("The receiver side data is ");
		for(i = 0; i < a; i++)
			System.out.print(arr[i]);
		System.out.println();
		for(i = 0; i < n; i++)
		{
			if(arr[i] == 0)
			{
				for(j = 1; j < g + i; j++)
					arr[j] = arr[j] ^ 0;
			}
			else
			{
				for(int k = 0; k < 17; k++)
					arr[i + k] = arr[i + k] ^ gen[k];
			}
		}
		System.out.println("The CRC at the receiver is ");
		for(i = n; i < a; i++)
			System.out.print(arr[i]);
		System.out.println();
		for(i = n; i < a; i++)
		{
			if(arr[i] == 1)
			{
				flag = 1;
				break;
			}
			else
				check = 0;
		}
		System.out.println("Result of error detection is ");
		if(flag == 0 && check == 0)
			System.out.println("Data is accepted successfully");
		else
			System.out.println("Resend the data again");
	}
}
