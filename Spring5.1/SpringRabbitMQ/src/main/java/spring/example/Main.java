package spring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.example.rabbit.Producer;


@SpringBootApplication
public class Main implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Autowired
	private Producer sender;
	
    @Override
    public void run(String... strings) throws Exception {
        sender.send("***  MESSAGE 1 ***");
        sender.send("***  MESSAGE 2 ***");
        try{Thread.sleep(5000);}catch(Exception e){}
        sender.send("***  MESSAGE 3 ***");
    }
}
