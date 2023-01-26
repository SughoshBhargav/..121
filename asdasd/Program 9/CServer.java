import java.net.*;
import java.io.*;
public class CServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket sersock = new ServerSocket();
		System.out.println("Server is ready for connection");
		Socket sock = new Socket();
		System.out.println("Connection is successful and waiting for chatting");
		InputStream istream = sock.getInputStream();
		BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
		String fname = fileRead.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		try(BufferedReader contentRead = new BufferedReader(new FileReader(fname)))
		{
			String str;
			while((str = contentRead.readLine()) != null)
			{
				pwrite.println(str);
			}
		}
		catch(FileNotFoundException e)
		{
			pwrite.println("File not found");
			sock.close();
			sersock.close();
			pwrite.close();
			fileRead.close();
		}
	}
}
