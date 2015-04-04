package ikovfisherancooker;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

public class Fish implements Strategy {
	Npc[] fishSpot = Npcs.getNearest(1333);

	@Override
	public boolean activate() {

		return !Inventory.isFull() && Constants.isLoggedIn();
	}

	@Override
	public void execute() {
		Constants.Status = "Fishing";
		if (Players.getMyPlayer().getAnimation() == -1) {
			if (fishSpot.length > 0 && fishSpot != null) {
				fishSpot[0].interact(0);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getAnimation() != -1;
					}

				}, 1500);
			}

		}
	}
}
