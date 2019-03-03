package java9.interfaces;

public class RecorderImpl implements Recorder<String>{

	@Override
	public void record(String data) {
		System.out.println("Recording....["+data+"]");  
		
	}  

}
