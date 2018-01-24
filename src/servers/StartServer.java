package servers;

public class StartServer {
	public static void main(String[] args)
	{
		MultiThreadedServer server = new MultiThreadedServer(8888);
		new Thread(server).start();
		System.out.println("Server has started!");
	}
}
