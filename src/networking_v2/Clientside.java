package networking_v2;

import java.net.Socket;

/**
 * A client-side connection. Executed as a thread.
 * <p>
 * TO DO: fields and methods visibility, general improvements.
 *
 * @author iliyan-kostov <iliyan.kostov.gml@gmail.com>
 */
public class Clientside extends Thread {

    public Socket socket;

    public Clientside(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}