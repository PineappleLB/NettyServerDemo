package club.pinea.pms;

import java.util.concurrent.atomic.AtomicInteger;

import club.pinea.pms.server.queue.ServerQueue;
import club.pinea.pms.socket.protobuf.ProtoBufServer;
import club.pinea.pms.spring.SpringBeanFactory;
import club.pinea.pms.util.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pineapple
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	public static AtomicInteger flag = new AtomicInteger(0);

	@Autowired
	private Test test;
	
	public static void main(String[] args) {
//		NettySocketServer server = new NettySocketServer(8112);
		SpringApplication.run(Application.class, args);

//		ProtoBufServer server = new ProtoBufServer(8112);
//		new Thread(server).start();
//		ServerQueue.getServerQueue().begin();
	}

	@Override
	public void run(String[] args){
		test.print("demo");
		test.print("demo");
		test.print("demo");
		test.print("demo");
	}
}
