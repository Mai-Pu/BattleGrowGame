package skill;

import entity.SkillItem;

public class WarriorSkill_3 extends SkillItem {
	public WarriorSkill_3() {
		setName("սʿ����3");
		setPower(30);
	}

	public String description() {
		return "����ʱ��80%�������" + String.valueOf(getPower() + getLevel() * 10) + "���˺�";
	}

	public int attack() {
		double d = Math.random();
		if (d <= 0.8) {
			return getPower() + getLevel() * 10;
		} else {
			return 0;
		}
	};
}
