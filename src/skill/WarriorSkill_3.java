package skill;

import entity.SkillItem;

public class WarriorSkill_3 extends SkillItem {
	public WarriorSkill_3() {
		setName("战士技能3");
		setPower(30);
	}

	public String description() {
		return "攻击时有80%几率造成" + String.valueOf(getPower() + getLevel() * 10) + "点伤害";
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
