package skill;

import entity.SkillItem;

public class WarriorSkill_1 extends SkillItem {
	public WarriorSkill_1() {
		setName("սʿ����1");
		setPower(20);
	}

	public String description() {
		return "����ʱ��40%�������" + String.valueOf(getPower() + getLevel() * 10) + "���˺�";
	}

	public int attack() {
		double d = Math.random();
		if (d <= 0.4) {
			return getPower() + getLevel() * 10;
		} else {
			return 0;
		}
	};
}
