import java.awt.*;
import javax.swing.*;

public class InstantMessageFrame extends JFrame {

	private JTextField message;
	private JList friends;
	private JButton send;

	public InstantMessageFrame(String s) {

		super(s);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(getMessagePanel(), BorderLayout.SOUTH);
		this.add(getFriendsPane(), BorderLayout.CENTER);

		IMHandler imh = new IMHandler(message, friends);
		message.addActionListener(imh);
		send.addActionListener(imh);

		String[] names = { "Jay", "Marie", "Melissa", "Mark", "Margaret" };
		friends.setListData(names);
	}

	public JPanel getMessagePanel() {

		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());

		message = new JTextField();
		send = new JButton("Send");

		messagePanel.add(message, BorderLayout.CENTER);
		messagePanel.add(send, BorderLayout.EAST);
		return messagePanel;
	}

	public JScrollPane getFriendsPane() {
		friends = new JList();
		JScrollPane pane = new JScrollPane(friends);
		return pane;
	}

	public static void main(String[] args) {

		JFrame i = new InstantMessageFrame("My IM Program");
		i.setSize(450, 220);

		i.setVisible(true);
	}
}
