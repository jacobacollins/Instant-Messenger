
import java.awt.*;
import javax.swing.*;

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
	 */
	public InstantMessageDialog(Frame owner, String recipient) {
		super(owner, "SendMessage Dialog", true);

		Container contentPane = this.getContentPane();

		// components
		send = new JButton("Send");
		cancel = new JButton("Cancel");
		message = new JTextArea();

		// action listener
		SendMessage sm = new SendMessage(message, recipient, this);
		send.addActionListener(sm);
		cancel.addActionListener(sm);

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
	}
}