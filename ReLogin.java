package ikovfisherancooker;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

public class ReLogin implements Strategy {

	@Override
	public boolean activate() {

		return Constants.toRelog() && !Constants.isLoggedIn();
	}

	@Override
	public void execute() {
		Constants.Status = "Relog!";
		Keyboard.getInstance().sendKeys("");
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Constants.isLoggedIn();
			}

		}, 3000);

	}

}
