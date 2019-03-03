package compositePackage2;

import java.util.Vector;
import java.util.*;

public class Element {
	private Collection _attributes;

	private String _elementName;

	private Collection _elements;	

	public Element(String elementName) {
		_elementName = elementName;
		_elements = new Vector();
		_attributes = new Vector();
	}

	public boolean hasAttributes() {
		return (_attributes == null) ? true : false;
	}

	public boolean isLeaf() {
		return (_elements == null) ? true : false;
	}

	public void addAttribute(Attribute a) {
		if (_attributes != null)
			_attributes.add(a);
	}

	public void print() {
		System.out.println("Element name: " + this.getElementName());
		if(_attributes.size()>0)
		System.out.println("Attributes: " +this.getAttributeNames());
		if (!isLeaf()) {
			Iterator i = _elements.iterator();
			while (i.hasNext()) {
				Element e = (Element) i.next();
				e.print();
			}
		}
	}

	public String getElementName() {
		return _elementName;
	}
	
	public String getAttributeNames(){
		Iterator i = _attributes.iterator();
		StringBuffer s = new StringBuffer();
		while(i.hasNext())
		{
			Attribute attr = (Attribute)i.next();
			s.append(attr.getAttributeName() + " " + attr.getAttributeValue());
		}
		return s.toString();
	}

	public void addChild(Element c) {
		if (_elements != null)
			_elements.add(c);
	}
}