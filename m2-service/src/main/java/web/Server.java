package web;

import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.gson.GsonModule;
import io.jooby.handler.Cors;
import io.jooby.handler.CorsHandler;
import io.jooby.netty.NettyServer;

public class Server extends Jooby {

	private static final int PORT = 8087;

	public Server() {

		Cors cors = new Cors()
				.setOrigin("*")
				.setMethods("GET", "POST", "PUT", "DELETE");
	
		use(new CorsHandler(cors));
		install(new GsonModule());

		// mount your modules here
		
	}

	public static void main(String[] args) {
		System.out.println("\nStarting Server.");
		ServerOptions options = new ServerOptions().setPort(PORT);
		runApp(args, new NettyServer(options), () -> new Server());
	}

}
