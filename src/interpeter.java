import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class interpeter {

	public static void main(String[] args) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();	//Instantiate SAX-based parser
		SAXParser saxParser = null;									//Create Object for SAX-based parser
		try {
			saxParser = factory.newSAXParser();						//Placing the instance into the object 
		} catch (ParserConfigurationException e1) {																					
			e1.printStackTrace();									// TODO Auto-generated catch block
		} catch (SAXException e1) {									
			e1.printStackTrace();									// TODO Auto-generated catch block
		}
		DefaultHandler handler = new DefaultHandler() {				//Everything SAX related needs to be inside the DefaultHandler
			
			boolean bSTN = false;									
			boolean bTEMP = false;
			boolean bTIME = false;
			boolean bDEWP = false;
			boolean bSTP = false;
			boolean bSLP = false;
			boolean bVISIB = false;
			boolean bPRCP = false;
			boolean bWDSP = false;
			boolean bSNDP = false;
			boolean bFRSHTT = false;
			boolean bCLDC = false;
			boolean bDATE = false;
			boolean bWNDDIR = false;
			
			public void startElement(String nameSpaceURI, String localName, String qname, Attributes atts) throws SAXException{		//This is run everytime the reader finds a .xml element
				if(qname.equalsIgnoreCase("STN")) {
					bSTN = true;
				}
				if(qname.equalsIgnoreCase("TEMP")) {
					bTEMP = true;
				}
				if(qname.equalsIgnoreCase("TIME")) {
					bTIME = true;
				}
				if(qname.equalsIgnoreCase("DEWP")) {
					bDEWP = true;
				}
				if(qname.equalsIgnoreCase("STP")) {
					bSTP = true;
				}
				if(qname.equalsIgnoreCase("SLP")) {
					bSLP = true;
				}
				if(qname.equalsIgnoreCase("VISIB")) {
					bVISIB = true;
				}
				if(qname.equalsIgnoreCase("PRCP")) {
					bPRCP = true;
				}
				if(qname.equalsIgnoreCase("WDSP")) {
					bWDSP = true;
				}
				if(qname.equalsIgnoreCase("SNDP")) {
					bSNDP = true;
				}
				if(qname.equalsIgnoreCase("FRSHTT")) {
					bFRSHTT = true;
				}
				if(qname.equalsIgnoreCase("CLDC")) {
					bCLDC = true;
				}
				if(qname.equalsIgnoreCase("DATE")) {
					bDATE = true;
				}
				if(qname.equalsIgnoreCase("WNDDIR")) {
					bWNDDIR = true;
				}
			}
			public void endElement(String nameSpaceURI, String localName, String qname) throws SAXException{	//Run at the end of the .xml file
				
			}
			
			public void characters(char[] ch, int start, int length) throws SAXException {
				if(bSTN) {
					System.out.println("Station: " + new String(ch, start, length));		//Prints data from the .xml file that is between the <> <>
					bSTN = false;
				}
				if(bTEMP) {
					System.out.println("Temperature: " + new String(ch, start, length));
					bSTN = false;
				}
				if(bTIME) {
					System.out.println("Station: " + new String(ch, start, length));
					bTIME = false;
				}
				if(bDATE) {
					System.out.println("Date: " + new String(ch, start, length));
					bDATE = false;
				}
				if(bDEWP) {
					System.out.println("Dew point: " + new String(ch, start, length));
					bDEWP = false;
				}
				if(bSTP) {
					System.out.println("Airpressure at station: " + new String(ch, start, length));
					bSTP = false;
				}
				if(bSLP) {
					System.out.println("Airpressure at sea level " + new String(ch, start, length));
					bSLP = false;
				}
				if(bVISIB) {
					System.out.println("Visibility: " + new String(ch, start, length));
					bVISIB = false;
				}
				if(bPRCP) {
					System.out.println("Rainfall: " + new String(ch, start, length));
					bPRCP = false;
				}
				if(bWDSP) {
					System.out.println("Wind speed: " + new String(ch, start, length));
					bWDSP = false;
				}
				if(bCLDC) {
					System.out.println("Cloudiness: " + new String(ch, start, length));
					bCLDC = false;
				}
				if(bSNDP) {
					System.out.println("Snowfall: " + new String(ch, start, length));
					bSNDP = false;
				}
				if(bFRSHTT) {
					System.out.println("Events: " + new String(ch, start, length));
					bFRSHTT = false;
				}
				if(bWNDDIR) {
					System.out.println("Wind direction: " + new String(ch, start, length));
					bWNDDIR = false;
				}
			} 
			
		};
		
		try {
			saxParser.parse("output.xml", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
