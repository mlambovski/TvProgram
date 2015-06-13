package tvprogram;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadFromXML {

    public static String getShows(String channel, String day) throws ParserConfigurationException, SAXException, IOException {
        StringBuilder sb = new StringBuilder();
        File program = new File("TvProgram.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbFactory.newDocumentBuilder();
        Document doc = db.parse(program);
        doc.getDocumentElement().normalize();
        NodeList tvChannel = doc.getElementsByTagName("Channel");

        for (int i = 0; i < tvChannel.getLength(); i++) {
            Node node = tvChannel.item(i);
            Element elementChannel = (Element) node;
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && elementChannel.getAttribute("Name").equals(channel)) {

                NodeList days = elementChannel.getElementsByTagName("Day");

                for (int j = 0; j < days.getLength(); j++) {
                    Node tvDay = days.item(j);
                    Element elementDay = (Element) tvDay;
                    if (tvDay.getNodeType() == Node.ELEMENT_NODE
                            && elementDay.getAttribute("day").equals(day)) {

                        NodeList shows = elementDay.getElementsByTagName("Show");

                        for (int k = 0; k < shows.getLength(); k++) {
                            Node tvShow = shows.item(k);
                            if (tvShow.getNodeType() == Node.ELEMENT_NODE) {
                                Element elementShow = (Element) tvShow;
                                sb.append(String.format("%-10s%-40s%s\n",
                                        elementShow.getAttribute("StartsAt"),
                                        elementShow.getAttribute("Title"),
                                        elementShow.getAttribute("Format")));
                            }
                        }
                    }
                }
            }
        }
        return new String(sb);
    }
}
