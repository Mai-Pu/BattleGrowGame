package entity;

public abstract class Monster implements Battler {
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private SkillComponent skill;
	private int money;
	private String type;
	private int rank;
	private int experience;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public SkillComponent getSkill() {
		return skill;
	}

	public void setSkill(SkillComponent skill) {
		this.skill = skill;
	}

	public abstract Equipment getDrop();

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String desribe() {
		return "一只强度为" + rank + "的" + type + "出现了";
	}
}
