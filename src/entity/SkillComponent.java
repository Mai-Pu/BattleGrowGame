package entity;

import java.util.Iterator;

public abstract class SkillComponent {
	public int attack() {
		throw new UnsupportedOperationException();
	};

	public void add(SkillComponent skillComponent) {
		throw new UnsupportedOperationException();
	};

	public void remove(SkillComponent skillComponent) {
		throw new UnsupportedOperationException();
	};

	public SkillComponent getSkill(int i) {
		throw new UnsupportedOperationException();
	};

	public boolean upgrade() {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public int getLevel() {
		throw new UnsupportedOperationException();
	}

	public Iterator<SkillComponent> getIterator() {
		throw new UnsupportedOperationException();
	}

	public String description() {
		throw new UnsupportedOperationException();
	}

	public boolean contains(SkillComponent skillComponent) {
		throw new UnsupportedOperationException();
	}
}
