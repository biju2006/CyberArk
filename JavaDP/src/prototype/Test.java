package prototype;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Ticket t=new MovieTicket("Lord of the Rings - The Return of the King");
		TicketMaker maker =new TicketMaker( t );
		List<Ticket> movieTickets=new ArrayList<>();
		for(int i=0;i<100;i++){
			Ticket copy = maker.makeTicket();
			movieTickets.add(copy);
		}
		for(Ticket ticket:movieTickets){
			System.out.println(ticket.getSerial()+" - "+ticket.getTitle()+", "+ticket.getDate());
		}


	}

}
