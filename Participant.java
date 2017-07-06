import java.io.*;

public class Participant extends Thread
{
	private ObjectInputStream in;
	private String username;

	public Participant(String username, InputStream source) throws IOException
	{
		this.username = username;
		in = new ObjectInputStream(source);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				InstantMessage im = (InstantMessage) in.readObject();
				System.out.println(im.getSender() + ": " + im.getMessage());
			}catch(Exception e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
}