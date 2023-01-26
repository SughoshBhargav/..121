import java.util.Scanner;
public class BellmanFord
{
	private int nv;
	private int distances[];
	public static int MAX_VALUE = 999;
	public BellmanFord(int nv)
	{
		this.nv = nv;
		distances = new int[nv + 1];
	}
	public void BellmanFordEvaluation(int source, int adm[][])
	{
		for(int node = 1; node <= nv; node++)
		{
			distances[node] = MAX_VALUE;
		}
		distances[source] = 0;
		for(int node = 1; node <= nv; node++)
		{
			for(int sn = 1; sn <= nv; sn++)
			{
				for(int dn = 1; dn <= nv; dn++)
				{
					if(adm[sn][dn] != MAX_VALUE)
					{
						if(distances[dn] > distances[sn] + adm[sn][dn])
							distances[dn] = distances[sn] + adm[sn][dn];
					}
				}
			}
		}
		for(int sn = 1; sn <= nv; sn++)
		{
			for(int dn = 1; dn <= nv; dn++)
			{
				if(adm[sn][dn] != MAX_VALUE)
				{
					if(distances[dn] > distances[sn] + adm[sn][dn])
						System.out.println("The graph contains negative cycles");
				}
			}
		}
		for(int vertex = 1; vertex <= nv; vertex++)
			System.out.println("Distance from source " + source + " to " + vertex + " is " + distances[vertex]);
	}
	public static void main(String args[])
	{
		int nv;
		int source;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		nv = sc.nextInt();
		int adm[][] = new int[nv + 1][nv + 1];
		System.out.println("Enter the adjacency matrix: ");
		for(int sn = 1; sn <= nv; sn++)
		{
			for(int dn = 1; dn <= nv; dn++)
			{
				adm[sn][dn] = sc.nextInt();
				if(sn == dn)
				{
					adm[sn][dn] = 0;
					continue;
				}
				if(adm[sn][dn] == 0)
				{
					adm[sn][dn] = MAX_VALUE;
				}
			}
		}
		System.out.println("Enter the source vertex: ");
		source = sc.nextInt();
		BellmanFord bellmanford = new BellmanFord(nv);
		bellmanford.BellmanFordEvaluation(source, adm);
	}
} 
