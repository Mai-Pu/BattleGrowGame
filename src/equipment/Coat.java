package equipment;

import entity.Equipment;

public class Coat extends Equipment {

	public Coat() {
		setName("����");
		setType("Cloth");
		setPower(10);
		setLevel(0);
	}

	public Coat(int level) {
		setType("Cloth");
		setPower(10);
		setLevel(level);
	}

	@Override
	public String describe() {
		// TODO �Զ����ɵķ������
		return "����һ�����£����ķ�����Ϊ" + getPower();
	}

}
