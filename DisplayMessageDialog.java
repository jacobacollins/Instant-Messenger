import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;


public class DisplayMessageDialog extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		int counter = e.getClickCount();
		
		if(counter == 2){
			JList item = (JList) e.getSource();
			String friend = (String) item.getSelectedValue();
			System.out.println("Friend = " + friend);
		}
		
	}

	

	
}
