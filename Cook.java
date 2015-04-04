package ikovfisherancooker;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

public class Cook implements Strategy {
	Item[] rawMonkFish = Inventory.getItems(7945);

	@Override
	public boolean activate() {
		return Inventory.getCount(7945) >= 1 && Inventory.isFull()
				&& Constants.toCook();
	}

	@Override
	public void execute() {
		// To Add.

	}

}
