package skill;

import entity.SkillItem;

public class WarriorSkill_2 extends SkillItem {

	public WarriorSkill_2() {
		setName("战士技能2");
		setPower(25);
	}

	public String description() {
		return "攻击时有60%几率造成" + String.valueOf(getPower() + getLevel() * 10) + "点伤害";
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
