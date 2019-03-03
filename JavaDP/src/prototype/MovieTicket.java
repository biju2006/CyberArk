package prototype;

import java.util.Date;

public class MovieTicket extends Ticket {
	
	private String movieName;
	
	
	public MovieTicket (String movieName){
		setTitle("Movie Ticket");
		this.movieName=movieName;
		setDate(new Date());
	}
}
