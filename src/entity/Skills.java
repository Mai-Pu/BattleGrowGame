package entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Skills extends SkillComponent {
	private ArrayList<SkillComponent> SkillComponents = new ArrayList<SkillComponent>();

	@Override
	public int attack() {
		int sum = 0;
		for (SkillComponent skillComponent : SkillComponents) {
			sum += skillComponent.attack();
		}
		return sum;
	}

	@Override
	public void add(SkillComponent skillComponent) {
		// TODO 自动生成的方法存根
		if (SkillComponents.size() < 4 && (!contains(skillComponent))) {
			SkillComponents.add(skillComponent);
		}
	}

	@Override
	public void remove(SkillComponent skillComponent) {
		SkillComponents.remove(skillComponent);
	}

	@Override
	public SkillComponent getSkill(int i) {
		return SkillComponents.get(i);
	}

	@Override
	public Iterator<SkillComponent> getIterator() {
		return SkillComponents.iterator();
	}

	@Override
	public boolean contains(SkillComponent skillComponent) {
		for (SkillComponent s : SkillComponents) {
			if (s.contains(skillComponent))
				return true;
		}
		return false;
	}
}
