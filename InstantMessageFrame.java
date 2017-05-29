import java.awt.*;
import javax.swing.*;

/**
 * This class provides the frame that displays our friends list and sends
 * messages. The messages will be sent to all the friends if one isn't
 * specifically picked.
 * 
 * @author Jacob Collins
 * @version 1.1
 */
public class InstantMessageFrame extends JFrame {

	// fields
	private JTextField message;
	private JList friends;
	private JButton send;

	/**
	 * Constructor that takes in a string for the title
	 * 
	 * @param s
	 *            String that represents title of frame.
	 */
	public InstantMessageFrame(String s) {

		// sets title and default close operation
		super(s);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// adds our message panel
		this.add(getMessagePanel(), BorderLayout.SOUTH);
		this.add(getFriendsPane(), BorderLayout.CENTER);

		// instantiating the dialog window for messages
		IMHandler imh = new IMHandler(message, friends);
		DisplayMessageDialog dmd = new DisplayMessageDialog();

		// adding listeners
		friends.addMouseListener(dmd);
		message.addActionListener(imh);
		send.addActionListener(imh);

		// makeing friends list.
		String[] names = { "Jay", "Marie", "Melissa", "Mark", "Margaret" };
		friends.setListData(names);
	}

	/**
	 * This method gets the message panel where the message is typed
	 * 
	 * 
	 * This method has no parameters
	 * 
	 * @return JPanel returns the JPanel portion where the message is typed and
	 *         sent
	 */
	public JPanel getMessagePanel() {

		// makes panel and sets layout
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());

		// makes text field and send button
		message = new JTextField();
		send = new JButton("Send");

		// adds textfield and butotn to message panel
		messagePanel.add(message, BorderLayout.CENTER);
		messagePanel.add(send, BorderLayout.EAST);
		return messagePanel;
	}

	/**
	 * This method creates the area where the friends list will be displayed
	 * 
	 * 
	 * no parameters
	 * 
	 * @return JScrollPane The pane where the friends list is displayed
	 */
	public JScrollPane getFriendsPane() {
		friends = new JList();
		JScrollPane pane = new JScrollPane(friends);
		return pane;
	}

	/**
	 * Instantiates a new message frame object
	 * 
	 * @param args
	 *            Command line arguments, none are used in this method
	 */
	public static void main(String[] args) {

		JFrame i = new InstantMessageFrame("My IM Program");
		i.setSize(450, 220);

		i.setVisible(true);
	}
}
