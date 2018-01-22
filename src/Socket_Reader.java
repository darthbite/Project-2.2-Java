import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_Reader {

	public static void main(String[] args) throws Exception{
		System.out.println("The server has been booted up!");
		ServerSocket ss = new ServerSocket(8888);
		
		System.out.println("Waiting for client request...");
		Socket s = ss.accept();
		
		System.out.println("A Client has connected!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine()+br.readLine();


		System.out.println(str);

		
	}

}
