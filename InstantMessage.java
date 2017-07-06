import java.io.Serializable;

public class InstantMessage implements Serializable {

	private String recipient, sender, message;

	public InstantMessage(String r, String s, String m) {
		recipient = r;
		sender = s;
		message = m;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getSender() {
		return sender;
	}

	public String getMessage() {
		return message;
	}
}
