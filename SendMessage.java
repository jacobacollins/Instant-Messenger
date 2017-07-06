import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class SendMessage implements ActionListener {

	private JTextArea message;
	private String recipient;
	private JDialog window;
	private ObjectOutputStream stream;
	private String sender;

	public SendMessage(JTextArea m, String r, String s, JDialog w, OutputStream dest) throws IOException {

		message = m;
		recipient = r;
		window = w;
		sender = s;
		stream = new ObjectOutputStream(dest);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();

		if (button.equals("Send")) {
			String text = message.getText();
			InstantMessage im = new InstantMessage(recipient, sender, text);
			try
			{
				stream.writeObject(im);
			}catch(IOException a)
			{
				System.out.println(a.getMessage());
			}
			window.hide();
			
		} else if (button.equals("Cancel")) {
			window.hide();
		}
	}

}
