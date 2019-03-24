package skill;

import entity.SkillItem;

public class WarriorSkill_2 extends SkillItem {

	public WarriorSkill_2() {
		setName("սʿ����2");
		setPower(25);
	}

	public String description() {
		return "����ʱ��60%�������" + String.valueOf(getPower() + getLevel() * 10) + "���˺�";
	}

	public int attack() {
		double d = Math.random();
		if (d <= 0.6) {
			return getPower() + getLevel() * 10;
		} else {
			return 0;
		}
	};
}
