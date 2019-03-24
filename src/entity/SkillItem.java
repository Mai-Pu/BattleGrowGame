package entity;

public abstract class SkillItem extends SkillComponent {

	private int level = 0;
	private String name;
	private int power;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public boolean upgrade() {
		double d = Math.random();
		if (level == 0) {
			if (d <= 0.6) {
				this.setLevel(1);
				return true;
			} else {
				return false;
			}
		} else if (level == 1) {
			if (d <= 0.3) {
				this.setLevel(2);
				return true;
			} else {
				return false;
			}
		} else if (level == 2) {
			if (d <= 0.1) {
				this.setLevel(3);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(SkillComponent skillComponent) {
		return name.equals(skillComponent.getName());
	}
}
