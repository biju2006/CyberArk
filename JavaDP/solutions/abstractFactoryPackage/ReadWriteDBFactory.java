package abstractFactoryPackage;

public class ReadWriteDBFactory extends ReadWriteFactory {

	public ReadWrite createReadWrite(String name) {
		return new ReadWriteDB(name);
	}
}