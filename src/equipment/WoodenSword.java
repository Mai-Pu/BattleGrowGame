package equipment;

import entity.Equipment;

public class WoodenSword extends Equipment {

	public WoodenSword() {
		setName("木剑");
		setType("Weapon");
		setPower(10);
		setLevel(0);
	}

	public WoodenSword(int level) {
		setType("Weapon");
		setPower(10);
		setLevel(level);
	}

	@Override
	public String describe() {
		return "这只是一把木剑,他的攻击力为" + getPower();
	}

}
