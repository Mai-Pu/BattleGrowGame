package career;

import entity.Career;
import entity.SkillItem;
import skill.WarriorSkill_1;
import skill.WarriorSkill_2;
import skill.WarriorSkill_3;
import skill.WarriorSkill_4;

public class Warrior extends Career {

	// 战士职业，特点是血厚防高,每次升级重点提升血防

	public Warrior() {
		setType("战士");
		setAttack(30);
		setDefense(20);
		setHp(150);
		setSpeed(10);
	}

	@Override
	public SkillItem strengthen(int rank) {
		// TODO 自动生成的方法存根
		setAttack(getAttack() + 10);
		setDefense(getDefense() + 5);
		setHp(getHp() + 10);
		setSpeed(getSpeed() + 1);

		double d = Math.random();
		if (rank <= 10) // 10级以下每次升级有机会学得战士技能1
		{
			if (d <= 0.7) {
				return new WarriorSkill_1();
			} else {
				return null;
			}
		} else if (rank <= 20) {
			if (d <= 0.5) {
				return new WarriorSkill_2();
			} else {
				return null;
			}
		} else if (rank <= 30) {
			if (d <= 0.3) {
				return new WarriorSkill_3();
			} else {
				return null;
			}
		} else {
			if (d <= 0.2) {
				return new WarriorSkill_4();
			} else {
				return null;
			}
		}
	}

	@Override
	public String describe() {
		return "战士职业，特点是血厚防高";

	}

}
