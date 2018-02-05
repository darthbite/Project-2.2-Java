package servers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class newparser implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;
    public float avrTemp;
    public String temp = "";
    public List list;
    
    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public synchronized void run() {
		try {
			inputParser();
//			for (int i = 0; i < list.size(); i++) {
//				Element node = (Element) list.get(i);
//				createGeorgië(node.getChildText("TEMP"),node.getChildText("DEWP"),node.getChildText("STN"),node.getChildText("TIME"),node.getChildText("STP"),node.getChildText("SLP"),node.getChildText("VISIB"),node.getChildText("PRCP"),node.getChildText("WDSP"),node.getChildText("SNDP"),node.getChildText("FRSHTT"),node.getChildText("CLDC"),node.getChildText("DATE"),node.getChildText("WNDDIR"), i);
//			System.out.println(node.getChildText("TEMP"));
//			if (node.getChildText("STN") == "330001" ||
//					node.getChildText("STN") == "330002" ||
//					node.getChildText("STN") == "330003" ||
//					node.getChildText("STN") == "330004" ||
//					node.getChildText("STN") == "330005" ||
//					node.getChildText("STN") == "330490" ||
//					node.getChildText("STN") == "330880" ||
//					node.getChildText("STN") == "331350" ||
//					node.getChildText("STN") == "331770" ||
//					node.getChildText("STN") == "332460" ||
//					node.getChildText("STN") == "332610" ||
//					node.getChildText("STN") == "332750" ||
//					node.getChildText("STN") == "333010" ||
//					node.getChildText("STN") == "333011" ||
//					node.getChildText("STN") == "333012" ||
//					node.getChildText("STN") == "333170" ||
//					node.getChildText("STN") == "333250" ||
//					node.getChildText("STN") == "333450" ||
//					node.getChildText("STN") == "333451" ||
//					node.getChildText("STN") == "333460" ||
//					node.getChildText("STN") == "333470" ||
//					node.getChildText("STN") == "333560" ||
//					node.getChildText("STN") == "333770" ||
//					node.getChildText("STN") == "333930" ||
//					node.getChildText("STN") == "333931") {
	    	
//	    	System.out.println("Ukraine data written!");}
//		}
//	    for (Element curEle : rootNode.getChildren("MEASUREMENT")) {
//	    	int version = 1;
//	    	createGeorgië(curEle.getChildText("TEMP"),curEle.getChildText("DEWP"), version);
//	    	version++;
//			}
		} catch(Exception ex) {
//			System.out.println(ex);
		}

    }
    public synchronized void inputParser() {
    	try {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String inline = inputReader.readLine();
		while ((inline = inputReader.readLine()) != null){
//			if(inline.endsWith("	</MEASUREMENT>") || inline.endsWith("    <MEASUREMENT>") || inline.endsWith("<WEATHERDATA>") || inline.endsWith("</WEATHERDATA>") || inline.endsWith("<?xml version=\"1.0\"?>")) {	
			if(inline.endsWith("    <MEASUREMENT>") || inline.endsWith("<?xml version=\"1.0\"?>")) {
			}
			else {
				sb.append(inline);
			}
//			if (inline.endsWith("	</MEASUREMENT>")) {
//				sb.append("	</MEASUREMENT>");
//				sb.append("</WEATHERDATA>");
//				sb.append("<?xml version=\"1.0\"?>");
//				sb.append("<WEATHERDATA>");
//				sb.append("	<MEASUREMENT>");
//			}
			System.out.println(sb.toString());
			break;
		}

		SAXBuilder builder = new SAXBuilder();
		Document document = (Document) builder.build(new ByteArrayInputStream(sb.toString().getBytes()));
	    Element rootNode = document.getRootElement();
		list = rootNode.getChildren("MEASUREMENT");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
	public void createGeorgië(String temp, String dew, String station, String time, String stp, String slp, String visibility, String prcp, String wdsp, String sndp, String frshtt, String cldc, String date, String wnddir, int number) {
		try {
			Document newDocument = new Document();
			Element rootElement = new Element("WEATHERDATA");
			Element measurements = new Element("MEASUREMENT");
			newDocument.setRootElement(rootElement);
			Element	TEMP = new Element("TEMP");
			Element	DEWP = new Element("DEWP");
			Element	STN = new Element("STN");
			Element	TIME = new Element("TIME");
			Element	STP = new Element("STP");
			Element	SLP = new Element("SLP");
			Element	VISIB = new Element("VISIB");
			Element	PRCP = new Element("PRCP");
			Element	WDSP = new Element("WDSP");
			Element	SNDP = new Element("SNDP");
			Element	FRSHTT = new Element("FRSHTT");
			Element	CLDC = new Element("CLDC");
			Element	DATE = new Element("DATE");
			Element	WNDDIR = new Element("WNDDIR");
			rootElement.addContent(measurements);
			measurements.addContent(TEMP);
			measurements.addContent(DEWP);
			measurements.addContent(STN);
			measurements.addContent(TIME);
			measurements.addContent(STP);
			measurements.addContent(SLP);
			measurements.addContent(VISIB);
			measurements.addContent(PRCP);
			measurements.addContent(WDSP);
			measurements.addContent(SNDP);
			measurements.addContent(FRSHTT);
			measurements.addContent(CLDC);
			measurements.addContent(DATE);
			measurements.addContent(WNDDIR);
			TEMP.addContent(temp);
			DEWP.addContent(dew);
			STN.addContent(station);
			TIME.addContent(time);
			STP.addContent(stp);
			SLP.addContent(slp);
			VISIB.addContent(visibility);
			PRCP.addContent(prcp);
			WDSP.addContent(wdsp);
			SNDP.addContent(sndp);
			FRSHTT.addContent(frshtt);
			CLDC.addContent(cldc);
			DATE.addContent(date);
			WNDDIR.addContent(wnddir);
			XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
			xmlOutput.output(newDocument, new FileOutputStream(new File("D:/data/dataUKRAINE"+ number +".xml")));
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}