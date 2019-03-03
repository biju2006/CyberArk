package compositePackage2;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

class AllElements implements NodeFilter {
	public short acceptNode(Node n) {
		if (n.getNodeType() == Node.ELEMENT_NODE)
			return FILTER_ACCEPT;
		return FILTER_SKIP;
	}
}