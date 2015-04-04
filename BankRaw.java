package ikovfisherancooker;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.Npc;

public class BankRaw implements Strategy {

	Npc[] banker = Npcs.getNearest(494);
	Item[] rawMonkFish = Inventory.getItems(7945);

	@Override
	public boolean activate() {
		return Inventory.isFull() && !Constants.toCook();
	}

	@Override
	public void execute() {
		if (banker.length > 0 && banker != null
				&& Game.getOpenInterfaceId() == -1) {
			Constants.Status = "To Bank";
			banker[0].interact(0);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() != -1;
				}
			}, 3000);
		} else {
			if (Game.getOpenInterfaceId() != -1) {
				Constants.Status = "In Bank";
				Menu.sendAction(431, 7944, rawMonkFish[0].getSlot(), 5064);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Inventory.getCount(7945) == 0;
					}
				}, 1250);
			}
		}
	}
}
