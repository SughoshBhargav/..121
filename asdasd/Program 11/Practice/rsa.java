import java.util.*;
import java.io.*;
public class rsa
{
	static int mult(int x, int y, int n)
	{
		int k = 1;
		for(int j = 1; j <= y; j++)
			k = (k * x) % n;
		return (int)k;
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int a, b, n, d, e, Z, p, q, i, temp, et;
		String msg1;
		int pt[] = new int[100];
		int ct[] = new int[100];
		System.out.println("Enter the prime numbers p, q: ");
		p = sc.nextInt();
		q = sc.nextInt();
		n = p * q;
		Z = (p - 1) * (q - 1);
		System.out.println("\nSelect e value: ");
		e = sc.nextInt();
		System.out.println("Enter the message: ");
		msg1 = br.readLine();
		char msg[] = msg1.toCharArray();
		for(i = 0; i < msg.length; i++)
			pt[i] = msg[i];
		for(d = 1; d < Z; ++d)
			if(((e * d) % Z) == 1)
				break;
		System.out.println("p = " + p + "q = " + q + "n = " + n + "z = " + Z + "e = " + e + "d = " + d);
		System.out.println("\nCipherText: ");
		for(i = 0; i < msg.length; i++)
			ct[i] = mult(pt[i], e, n);
		for(i = 0; i < msg.length; i++)
		{
			System.out.print("\t" + ct[i]);
			System.out.println("\n");
		}
	}
	
}
