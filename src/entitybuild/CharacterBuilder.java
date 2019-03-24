package entitybuild;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Character;
import entity.Equipment;
import entity.Skills;

public abstract class CharacterBuilder {
	Character character = new Character();

	public abstract void bulidCareer();

	public void buildExperience() {
		character.setExperience(0);
	}

	public void buildBag() {
		character.setBag(new ArrayList<Equipment>());
	}

	public void bulidRank() {
		character.setRank(0);
	}

	public void bulidMoney() {
		character.setMoney(0);
	}

	public void bulidEquipment() {
		character.setEquipments(new HashMap<String, Equipment>());
	}

	public void buildSkill() {
		character.setSkills(new Skills());
	}

	public Character getResult() {
		return character;
	}
}
