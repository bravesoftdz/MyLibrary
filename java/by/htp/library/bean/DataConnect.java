package by.htp.library.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConnect {

	private String ip;
	private String time;
	private String date;

	public String getIp() throws IOException {
		return getIpUser();
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() throws IOException {
		return getTimeFind();
	}

	public void setTime(String time) {
		this.time = time;
	}	

	public String getDate() throws IOException {
		return gerDateFind();
	}

	public void setDate(String date) {
		this.date = date;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		DataConnect other = (DataConnect) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "DataConnect [ip=" + ip + ", time=" + time + ", date=" + date + "]";
	}

	private String getIpUser() throws IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
		String ip = in.readLine();
		if (ip == "<html>") {
			return null;
		} else {
			return ip;
			}
	}

	private String getTimeFind() throws IOException {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		format.format(d);
		return format.format(d);
	}
	
	private String gerDateFind() throws IOException {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		format.format(d);
		return format.format(d);
	}

}
