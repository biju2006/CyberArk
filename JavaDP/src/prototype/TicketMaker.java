package prototype;

public class TicketMaker{
	
	private static int serialNo=2837987;
	
	private Ticket toCopy;
	public TicketMaker (Ticket t){
             toCopy=t;
             t.setSerial(++serialNo);
    }   
   
	public Ticket makeTicket(){
         Ticket copy= toCopy.clone();
         copy.setSerial(++serialNo);
         return copy;
    }
     
}
