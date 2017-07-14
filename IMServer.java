import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class IMServer implements Runnable {

	private Vector vector;
	private ServerSocket server;

	public IMServer() throws IOException {
		vector = new Vector();
		server = new ServerSocket(5555);
	}

	@Override        
	public void run() {
		try {
			Socket socket = server.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String username = in.readUTF();

			Participant participant = new Participant(username, socket.getInputStream());
			vector.add(participant);
			participant.start();

		} catch (IOException e) {
			e.getMessage();
			e.getLocalizedMessage();
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			IMServer im = new IMServer();
			Thread thread = new Thread(im);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
			e.getLocalizedMessage();
		}

	}

}
