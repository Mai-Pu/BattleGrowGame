package skill;

import entity.SkillItem;

public class WarriorSkill_4 extends SkillItem {
	public WarriorSkill_4() {
		setName("战士技能4");
		setPower(40);
	}

	public String description() {
		return "攻击时有80%几率造成" + String.valueOf(getPower() + getLevel() * 20) + "点伤害";
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
