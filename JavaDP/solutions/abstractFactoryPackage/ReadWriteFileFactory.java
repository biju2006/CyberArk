package abstractFactoryPackage;

public class ReadWriteFileFactory extends ReadWriteFactory {

	public ReadWrite createReadWrite(String name) {
		return new ReadWriteFile(name);
	}
}