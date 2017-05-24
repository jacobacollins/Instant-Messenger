/*import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class InstantMessageDialog extends JDialog{

	 private JButton send;
	 private JButton cancel;
	 private JTextField message;
	 
	 InstantMessageDialog(JFrame owner, String recipient){
		//super(owner);
		super(owner, "SendMessage Dialog", true);
		
		Container contentPane = this.getContentPane();
		
		send = new JButton("Send");
		cancel = new JButton("Cancel");
		message = new JTextField();
		
		JPanel button = new JPanel();
		button.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button.add(cancel);
		button.add(send);
		contentPane.add(button, BorderLayout.SOUTH);
		
		JScrollPane center = new JScrollPane(message);
		contentPane.add(center, BorderLayout.CENTER);
		

		JLabel label = new JLabel("Sending message to " + recipient);
		contentPane.add(label, BorderLayout.NORTH);
		
		this.setSize(400, 200);
	 }
	 
	 public static void main(String[] args){
		 InstantMessageDialog imd = new InstantMessageDialog(null, "John");
		 imd.show();
		
	 }
}
*/

import java.awt.*;
import javax.swing.*;

public class InstantMessageDialog extends JDialog
{
	private JButton send, cancel;
	private JTextArea message;

	public InstantMessageDialog(Frame owner, String recipient)
	{
		super(owner, "SendMessage Dialog", true);

		Container contentPane = this.getContentPane();

		send = new JButton("Send");
		cancel = new JButton("Cancel");
		message = new JTextArea();

		JPanel south = new JPanel();
		south.add(send);
		south.add(cancel);
		contentPane.add(south, BorderLayout.SOUTH);

		JScrollPane center = new JScrollPane(message);
		contentPane.add(center, BorderLayout.CENTER);

		JLabel north = new JLabel("Sending message to " + recipient);
		contentPane.add(north, BorderLayout.NORTH);

		this.setSize(400,200);
	}

	public static void main(String [] args)
	{
		InstantMessageDialog d = new InstantMessageDialog(null, "j_doe");
		d.show();
	}
}