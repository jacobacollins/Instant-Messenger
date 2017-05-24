import java.awt.event.*;
import javax.swing.*;


public class IMHandler implements ActionListener{

	private JTextField text;
	private JList list;
	
	public IMHandler(JTextField t, JList l){
		text = t;
		list = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object component = e.getSource();
		
		String t = text.getText();
	
		if(e.getActionCommand().equals("Send") || component instanceof JTextField){
			
			if(t != "")
			{
				ListModel model = list.getModel();
				int size = model.getSize();
				for(int i = 0; i < size; i++)
				{
					System.out.println(t + " " + model.getElementAt(i));
				
			}
		}
		}
		
		
	}


}
