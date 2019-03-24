package skill;

import entity.SkillItem;

public class WarriorSkill_1 extends SkillItem {
	public WarriorSkill_1() {
		setName("战士技能1");
		setPower(20);
	}

	public String description() {
		return "攻击时有40%几率造成" + String.valueOf(getPower() + getLevel() * 10) + "点伤害";
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
