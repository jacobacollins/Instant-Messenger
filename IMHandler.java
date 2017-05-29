import java.awt.event.*;
import javax.swing.*;

/**
 * This class prints to the command line the text you are sending and the
 * recipients of that text.
 * 
 * @author Jacob Collins
 * @version 1.2 @
 */
public class IMHandler implements ActionListener {

	// fields
	private JTextField text;
	private JList list;

	/**
	 * This is the constructor for our InstantMessegeHandler
	 * 
	 * @param t
	 *            TextField that is initialized
	 * @param l
	 *            JList that is initialized
	 */
	public IMHandler(JTextField t, JList l) {
		text = t;
		list = l;
	}

	/**
	 * The Action Handler for the InstantMessageHandler that will display the
	 * text and recipients if we press send or hit enter
	 * 
	 * @param e
	 *            The action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object component = e.getSource();

		String t = text.getText();

		// if we click send or hit enter
		if (e.getActionCommand().equals("Send") || component instanceof JTextField) {

			if (t != "") {
				ListModel model = list.getModel();
				int size = model.getSize();
				for (int i = 0; i < size; i++) {
					// prints out the text and recipients of it
					System.out.println(t + " " + model.getElementAt(i));

				}
			}
		}

	}

}
