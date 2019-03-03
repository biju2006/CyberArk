package prototype;

import java.util.Date;

public class Ticket implements Cloneable {
	private Date date;
	private long serial;
	private String title;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSerial() {
		return serial;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	//in this implementation NULL value is returned when clone is not supported
	//consider assert / or throwing exceptions when clone fails in order to notify clients 
	public Ticket clone(){
		try{
		Ticket copy = (Ticket) super.clone();
		// no need in deep copy for this object...
		return copy;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}
	}

}
