package by.htp.library.action.util;

import java.util.Calendar;

public class PartDay {

	@SuppressWarnings("deprecation")
	public String getTimeDay() {
		String gritting = "";
		int hours = Calendar.getInstance().getTime().getHours();
		String[] hello = { "Good morning.", "Good afternoon.", "Good evening.", "Good night." };
		if (hours >= 6 && hours < 12) {
			gritting = hello[0];
		}
		if (hours >= 12 && hours < 18) {
			gritting = hello[1];
		}
		if (hours >= 18 && hours < 23) {
			gritting = hello[2];
		}
		if (hours >= 23 && hours < 6) {
			gritting = hello[3];
		}
		return gritting;
	}

}
