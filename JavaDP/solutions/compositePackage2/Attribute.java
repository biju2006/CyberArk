package compositePackage2;

public class Attribute {
	private String _attributeName;

	private String _attributeValue;

	public Attribute(String attributeName, String attributeValue) {
		_attributeName = attributeName;
		_attributeValue = attributeValue;
	}

	public String getAttributeName() {
		return _attributeName;
	}

	public String getAttributeValue() {
		return _attributeValue;
	}
}