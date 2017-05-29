import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class SendMessage implements ActionListener {

	private JTextArea message;
	private String recipient;
	private JDialog window;

	public SendMessage(JTextArea m, String r, JDialog w) {

		message = m;
		recipient = r;
		window = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();

		if (button.equals("Send")) {
			String text = message.getText();
			System.out.println(recipient + " says: " + text);
		} else if (button.equals("Cancel")) {
			window.hide();
		}
	}

}
