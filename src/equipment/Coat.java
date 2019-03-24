package equipment;

import entity.Equipment;

public class Coat extends Equipment {

	public Coat() {
		setName("棉衣");
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
		// TODO 自动生成的方法存根
		return "这是一件棉衣，它的防御力为" + getPower();
	}

}
