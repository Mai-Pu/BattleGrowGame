package entity;

public abstract class Equipment {
	private String type; // 装备类型，武器、衣服等
	private int power; // 表示装备的基础属性
	private int level; // 强化等级
	private String name; // 装备的名称

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 返回装备经过强化后的属性
	public int getPower() {
		int sum = 0;
		for (int i = 1; i <= level; i++) {
			if (i <= 4) {
				sum += (int) (power * 0.2);
			} else if (level <= 6) {
				sum += (int) (power * 0.4);
			} else if (level <= 8) {
				sum += (int) (power * 0.6);
			} else if (level <= 10) {
				sum += (int) (power * 0.8);
			} else if (level <= 11) {
				sum += (int) (power * 0.9);
			} else if (level <= 12) {
				sum += power;
			} else if (level <= 13) {
				sum += (int) (power * 1.2);
			} else if (level <= 14) {
				sum += (int) (power * 1.5);
			} else {
				sum += (int) (power * 1.8);
			}
		}
		return power + sum;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// 强化概率根据等级变化
	public boolean strengthen() {
		double d = Math.random();
		if (level <= 4) {
			this.setLevel(level + 1);
			return true;
		} else if (level <= 6) {
			if (d <= 0.8) {
				this.setLevel(level + 1);
				return true;
			} else {
				return false;
			}
		} else if (level <= 8) {
			if (d <= 0.6) {
				this.setLevel(level + 1);
				return true;
			} else {
				return false;
			}
		} else if (level <= 10) {
			if (d <= 0.4) {
				this.setLevel(level + 1);
				return true;
			} else {
				return false;
			}
		} else if (level <= 11) {
			if (d <= 0.3) {
				this.setLevel(level + 1);
				return true;
			} else {
				this.setLevel(7);
				return false;
			}
		} else if (level <= 12) {
			if (d <= 0.2) {
				this.setLevel(level + 1);
				return true;
			} else {
				this.setLevel(8);
				return false;
			}
		} else if (level <= 13) {
			if (d <= 0.1667) {
				this.setLevel(level + 1);
				return true;
			} else {
				this.setLevel(0);
				return false;
			}
		} else if (level <= 14) {
			if (d <= 0.1429) {
				this.setLevel(level + 1);
				return true;
			} else {
				this.setLevel(0);
				return false;
			}
		} else {
			if (d <= 0.125) {
				this.setLevel(level + 1);
				return true;
			} else {
				this.setLevel(0);
				return false;
			}
		}
	}

	public abstract String describe();
}
