import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JList;

/**
 * This class will display a message dialog given the event there is a double
 * click on a friend in the list
 * 
 * @author Jacob Collins
 * @version 1.0
 */
public class DisplayMessageDialog extends MouseAdapter {

	/**
	 * Handles a double click event on a friend in the list and displays a
	 * message dialog.
	 * 
	 * @param e
	 *            MouseEvent, when double clicking on friends list item we will
	 *            display a message dialog.
	 **/
	@Override
	public void mouseClicked(MouseEvent e) {
		int counter = e.getClickCount();

		// if we double click a friend on the list
		if (counter == 2) {
			JList item = (JList) e.getSource();
			String friend = (String) item.getSelectedValue();
			System.out.println("Friend = " + friend);
			JDialog im = new InstantMessageDialog(null, friend);
			im.show();

		}

	}

}
