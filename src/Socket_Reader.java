import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import org.xml.sax.SAXException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Socket_Reader {

	public static void main(String[] args) throws SAXException, Exception{
		System.out.println("The server has been booted up!");
		ServerSocket ss = new ServerSocket(8888);
		
		System.out.println("Waiting for client request...");
		Socket s = ss.accept();
		
		System.out.println("A Client has connected!");

		try {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String inline = "";
		while ((inline = inputReader.readLine()) != null) {
		  sb.append(inline);
		}

		System.out.println(sb.toString());
		SAXBuilder builder = new SAXBuilder();

		Document document = (Document) builder.build(new ByteArrayInputStream(sb.toString().getBytes()));
	    Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("MEASUREMENT");
		for (int i = 0; i < list.size(); i++) {
			Element node = (Element) list.get(i);
		    System.out.println("Element data ==>" + node.getChildText("STN"));
		    System.out.println("Element data ==>" + node.getChildText("TEMP"));
		}
		s.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

