
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class displays a message dialog window given that a friend is double
 * clicked from the list.
 * 
 * @author Jacob Collins
 * @version 1.1
 */
public class InstantMessageDialog extends JDialog {
	private JButton send, cancel;
	private JTextArea message;

	/**
	 * This class makes our modal dialog window for sending messages to one
	 * person that was double clicked on.
	 * 
	 * @param owner
	 *            The owner of the Frame
	 * @param recipient
	 *            The recipient of the message
	 * @throws IOException 
	 */
	public InstantMessageDialog(Frame owner, String recipient, String sender) throws IOException {
		super(owner, "SendMessage Dialog", true);

		Container contentPane = this.getContentPane();

		// components
		send = new JButton("Send");
		cancel = new JButton("Cancel");
		message = new JTextArea();

		

		// adding things to the south panel
		JPanel south = new JPanel();
		south.add(send);
		south.add(cancel);
		contentPane.add(south, BorderLayout.SOUTH);

		// adding JScrollPane to center panel
		JScrollPane center = new JScrollPane(message);
		contentPane.add(center, BorderLayout.CENTER);

		// adds JLabel that tells us who we are sending the message to
		JLabel north = new JLabel("Sending message to " + recipient);
		contentPane.add(north, BorderLayout.NORTH);

		this.setSize(400, 200);
		

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream(in);

		SendMessage listener = new SendMessage(message, recipient, sender, this, out);
		send.addActionListener(listener);
		cancel.addActionListener(listener);

		Participant user = new Participant(recipient, in);
		user.start();
	}

	public static void main(String [] args)
	{
		try
		{
			InstantMessageDialog d = new InstantMessageDialog(null, args[0], args[1]);
			d.show();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}