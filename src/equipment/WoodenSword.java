package equipment;

import entity.Equipment;

public class WoodenSword extends Equipment {

	public WoodenSword() {
		setName("ľ��");
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
		return "��ֻ��һ��ľ��,���Ĺ�����Ϊ" + getPower();
	}

}
