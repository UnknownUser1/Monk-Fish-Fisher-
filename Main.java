package ikovfisherancooker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.*;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

@ScriptManifest(author = "Unknown User", category = Category.FISHING, description = "Banks raw monkfish, Will add cooking.", name = "UMonk Fisher", servers = { "Ikov" }, version = 1)
public class Main extends Script implements Paintable, MessageListener {
	private static int count;
	public long startTime;

	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public boolean onExecute() {
		startTime = System.currentTimeMillis();
		strategies.add(new ReLogin());
		strategies.add(new Fish());
		strategies.add(new BankRaw());
		strategies.add(new BankCooked());
		strategies.add(new Cook());
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(20);
		}
		provide(strategies);

		return true;
	}

	public void onFinish() {
	}

	private final Color color1 = new Color(153, 153, 0);
	private final Color color2 = new Color(0, 0, 0);

	private final BasicStroke stroke1 = new BasicStroke(3);

	private final Font font1 = new Font("Tahoma", 0, 13);
	private final Font font2 = new Font("Tahoma", 0, 8);

	public void paint(Graphics C) {
		Graphics2D g = (Graphics2D) C;
		g.setColor(color1);
		g.fillRect(4, 58, 95, 17);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRect(4, 58, 95, 17);
		g.setColor(color1);
		g.fillRect(3, 76, 132, 80);
		g.setColor(color2);
		g.drawRect(3, 76, 132, 80);
		g.setFont(font1);
		g.drawString("Monk Fisher", 6, 72);
		g.setFont(font2);
		g.drawString("V1", 87, 72);
		g.setFont(font1);
		g.drawString("Run Time -", 7, 95);
		g.drawString("Status -", 7, 145);
		g.drawString("Caught -", 6, 124);

		g.drawString(Constants.addDecimals(count), 60, 124);
		g.drawString(Constants.runTime(startTime), 75, 95);
		g.drawString(Constants.Status, 55, 145);
	}

	public void messageReceived(MessageEvent m) {
		if (m.getType() == 0) {
			if ((m.getMessage().contains("catch a raw monkfish."))) {
				count += 1;
			}
		}
	}
}
