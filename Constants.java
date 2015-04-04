package ikovfisherancooker;

import java.text.DecimalFormat;

import org.rev317.min.api.methods.SceneObjects;

public class Constants {

	public static boolean toCook() {
		return Gui.checkBox_cookFish.isSelected();
	}

	public static boolean toRelog() {
		return Gui.checkBox_login.isSelected();
	}

	public static boolean isLoggedIn() {
		return SceneObjects.getNearest().length > 0;
	}

	public static String runTime(long i) {

		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;

		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

	public static String addDecimals(int item) {
		DecimalFormat form = new DecimalFormat("#,###");
		return "" + form.format(item);

	}

	public static String Status = "Loading!";
}
