package examples.dom.factories;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Test {

	public static void main(String[] args) throws Exception{
		//factory method DP
		DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
		DocumentBuilder parser=f.newDocumentBuilder();
		f.setIgnoringElementContentWhitespace(true);
		f.setIgnoringComments(true);
		Document doc=parser.parse("http://www.ynet.co.il/Integration/StoryRss3254.xml");
		
		//just for fun:
		NodeList titles=doc.getDocumentElement().getElementsByTagName("title");
		for(int i=0;i<titles.getLength();i++){
			System.out.println(titles.item(i).getTextContent());
		}
		
		//abstract factory with DOM API
		Element newTitle=doc.createElement("title");
		Text data=doc.createTextNode("started Java DP at JBT Collage today...");
		newTitle.appendChild(data);
		doc.getDocumentElement().appendChild(newTitle);

		System.out.println("Adding new title...");
		
		//just for fun:
		titles=doc.getDocumentElement().getElementsByTagName("title");
		for(int i=0;i<titles.getLength();i++){
			System.out.println(titles.item(i).getTextContent());
		}
	}

}
