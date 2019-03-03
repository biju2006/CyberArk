package compositePackage1;

public class FSFile implements FSEntity {
	
	private String _name;
	private int _size;
	
	public FSFile(String name, int size)
	{
		_name = name;
		_size = size;
	}
	
	public String name() {
		return _name;
	}

	public int size() {
		return _size;
	}
}
