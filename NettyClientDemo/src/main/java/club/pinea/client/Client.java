package club.pinea.client;

import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8112;

	@Override
	public void run() {
		try {
			Socket socket = new Socket(HOST, PORT);
			socket.getOutputStream().write(("Hello World!" + new String(new byte[] { 6, 3, 7 })).getBytes());
			Scanner sc = new Scanner(socket.getInputStream());
			String res = sc.nextLine();
			System.out.println(res);
			sc.close();
			if (!socket.isClosed())
				socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Client()).start();
		}
	}
}
