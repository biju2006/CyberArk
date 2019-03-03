package compositePackage2;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.dom.TreeWalkerImpl;
import org.w3c.dom.traversal.*;
import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.NamedNodeMap;

public class DomClient {
	public static void main(String args[]) {

		try {
			// create an object of the Document implementation class
			DOMParser parser = new DOMParser();
			parser.parse("C:\\temp\\xml_file.txt");
			DocumentImpl document = (DocumentImpl) parser.getDocument();

			// get the root of the XML document
			Node root = document.getLastChild();

			// instantiate the filter object
			AllElements allelements = new AllElements();

			// create an object of the TreeWalker implementation class
			TreeWalkerImpl tw = (TreeWalkerImpl) document.createTreeWalker(
					root, NodeFilter.SHOW_ELEMENT, (NodeFilter) allelements,
					true);

			// load the elements to an element tree
			Element rootElement = loadElements(tw);
			rootElement.print();

		} catch (Exception e) {
			System.out.println("error: " + e);
			e.printStackTrace();
			System.exit(0);
		}

	}

	// traverses the tree structure representation
	public static Element loadElements(TreeWalkerImpl tw) {
		Node n = tw.getCurrentNode();
		Element e = new Element(n.getNodeName());
		loadAttributes(e,n);
		for (Node child = tw.firstChild(); child != null; child = tw
				.nextSibling()) {
			tw.setCurrentNode(child);
			Element c = loadElements(tw);
			e.addChild(c);
		}

		return e;
	}

	public static void loadAttributes(Element e, Node n) {
		NamedNodeMap attributes = n.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Attr attr = (Attr) attributes.item(i);
			e.addAttribute(new Attribute(attr.getName(), attr.getValue()));
		}
	}
}
