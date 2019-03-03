package compositePackage1;

import java.util.*;

public class FSDirectory implements FSEntity {
	Vector _files;
	
	public FSDirectory(String name)
	{
		_files = new Vector();
	}
	
	public void add(FSEntity entity)
	{
		_files.add(entity);
	}
	
	public void remove(FSEntity entity)
	{
		_files.remove(entity);
	}
	
	public void listFiles()
	{
		for(int i=0; i<_files.size(); i++)
			System.out.println( ((FSEntity)_files.elementAt(i)).name() );
	}
	
	public String name() {
		String name = "directory: ";
		Iterator i = _files.iterator();
		while(i.hasNext())
		{
			FSEntity f = (FSEntity)i.next();
			name += f.name() + " ";
		}
		return name;
	}

	public int size() {
		int size = 0;
		Iterator i = _files.iterator();
		while(i.hasNext())
		{
			FSEntity f = (FSEntity)i.next();
			size += f.size();
		}
		return size;
	}
}
