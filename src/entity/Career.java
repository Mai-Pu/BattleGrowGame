package entity;

public abstract class Career {
	private String type;
	private int hp;
	private int attack;
	private int defense;
	private int speed;

	// 职业每次升级都有几率学会一些与职业相关的技能，每个职业升级所加的属性值是不同的
	public abstract SkillItem strengthen(int rank);

	public abstract String describe();

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

}
