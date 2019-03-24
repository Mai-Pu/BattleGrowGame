package skill;

import entity.SkillItem;

public class WarriorSkill_4 extends SkillItem {
	public WarriorSkill_4() {
		setName("սʿ����4");
		setPower(40);
	}

	public String description() {
		return "����ʱ��80%�������" + String.valueOf(getPower() + getLevel() * 20) + "���˺�";
	}

	public int attack() {
		double d = Math.random();
		if (d <= 0.8) {
			return getPower() + getLevel() * 20;
		} else {
			return 0;
		}
	};
}
