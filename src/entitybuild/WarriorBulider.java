package entitybuild;

import career.Warrior;

public class WarriorBulider extends CharacterBuilder {

	@Override
	public void bulidCareer() {
		// TODO �Զ����ɵķ������
		character.setCareer(new Warrior());
	}

}
