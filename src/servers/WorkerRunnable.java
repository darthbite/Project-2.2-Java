package servers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**

 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
		try {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String inline = "";
		while ((inline = inputReader.readLine()) != null) {
		  sb.append(inline);
		}

		SAXBuilder builder = new SAXBuilder();

		Document document = (Document) builder.build(new ByteArrayInputStream(sb.toString().getBytes()));
	    Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("MEASUREMENT");
		for (int i = 0; i < list.size(); i++) {
			Element node = (Element) list.get(i);
			//hier komt de code om de data in het database te zetten
		}

		} catch(Exception ex) {

		}
    }
}