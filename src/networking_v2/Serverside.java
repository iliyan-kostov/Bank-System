package networking_v2;

import java.net.Socket;

/**
 * A server-side connection. Executed as a thread.
 * <p>
 * TO DO: fields and methods visibility, general improvements.
 *
 * @author iliyan-kostov <iliyan.kostov.gml@gmail.com>
 */
public class Serverside extends Thread {

    public Socket socket;
    public Server server;

    public Serverside(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {

    }
}