package test;

import java.util.Iterator;

import entity.Character;
import entity.SkillComponent;
import entitybuild.CharacterDirector;
import entitybuild.MonsterFactory;
import equipment.WoodenSword;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CharacterDirector d = new CharacterDirector();
		Character c = d.construct();
		System.out.println(c.getCareer().getType());
		for (int i = 0; i < 33; i++)
			c.strengthen();
		System.out.println(c.getCareer().getHp());
		Iterator<SkillComponent> is = c.getSkills().getIterator();
		while (is.hasNext()) {
			SkillComponent ss = is.next();
			System.out.println(ss.getName());
		}
		c.wearEquipment(new WoodenSword());
		System.out.println(c.getEquipments().get("Weapon").describe());
		System.out.println(new MonsterFactory().getMonster("BlockHead", 50).desribe());
	}

}
