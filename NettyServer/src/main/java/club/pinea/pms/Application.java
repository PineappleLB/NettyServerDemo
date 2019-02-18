package club.pinea.pms;

import club.pinea.pms.server.queue.ServerQueue;
import club.pinea.pms.socket.protobuf.ProtoBufServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pineapple
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	public static AtomicInteger flag = new AtomicInteger(0);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String[] args){
		ProtoBufServer server = new ProtoBufServer(8112);
		new Thread(server).start();
		ServerQueue.getServerQueue().begin();
	}
}
