package entitybuild;

import career.Warrior;

public class WarriorBulider extends CharacterBuilder {

	@Override
	public void bulidCareer() {
		// TODO 自动生成的方法存根
		character.setCareer(new Warrior());
	}

}
