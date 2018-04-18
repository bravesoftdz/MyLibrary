package by.htp.library.bean;

public class Chat {
	
	private int idMessage;
	private long dateOn;
	private String fromUser;
	private String toUser;
	private String message;
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public long getDateOn() {
		return dateOn;
	}
	public void setDateOn(long dateOn) {
		this.dateOn = dateOn;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dateOn ^ (dateOn >>> 32));
		result = prime * result + ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime * result + idMessage;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((toUser == null) ? 0 : toUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		if (dateOn != other.dateOn)
			return false;
		if (fromUser == null) {
			if (other.fromUser != null)
				return false;
		} else if (!fromUser.equals(other.fromUser))
			return false;
		if (idMessage != other.idMessage)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (toUser == null) {
			if (other.toUser != null)
				return false;
		} else if (!toUser.equals(other.toUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chat [idMessage=" + idMessage + ", dateOn=" + dateOn + ", fromUser=" + fromUser + ", toUser=" + toUser
				+ ", message=" + message + "]";
	}
	
	

}
