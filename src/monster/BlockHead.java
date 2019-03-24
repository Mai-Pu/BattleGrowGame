package monster;

import entity.Equipment;
import entity.Monster;
import equipment.Coat;
import equipment.WoodenSword;
import skill.WarriorSkill_1;

public class BlockHead extends Monster {
	public BlockHead() {
		setHp(100);
		setAttack(30);
		setDefense(10);
		setSpeed(12);
		setSkill(new WarriorSkill_1());
		setExperience(50);
		setMoney(10);
		setType("BlockHead");
		setRank(0);
	}

	@Override
	public Equipment getDrop() {
		Double d = Math.random();
		if (d <= 0.5) {
			return new Coat();
		} else {
			return new WoodenSword();
		}
	}

	@Override
	public int attack() {
		return getAttack() + 8 * getRank() + getSkill().attack();
	}

	@Override
	public int defense() {
		return getDefense() + getRank() * 6;
	}

	@Override
	public int speed() {
		return getSpeed();
	}

	@Override
	public int hp() {
		return getHp() + getRank() * 10;
	}
}
