package entitybuild;

import entity.Character;

public class CharacterDirector {
	private CharacterBuilder characterBuilder;

	public CharacterDirector() {
		characterBuilder = new WarriorBulider();
	}

	public CharacterDirector(CharacterBuilder characterBuilder) {
		this.characterBuilder = characterBuilder;
	}

	public void setCharacterBuilder(CharacterBuilder characterBuilder) {
		this.characterBuilder = characterBuilder;
	}

	public Character construct() {
		characterBuilder.bulidCareer();

		characterBuilder.bulidRank();

		characterBuilder.bulidMoney();

		characterBuilder.bulidEquipment();

		characterBuilder.buildSkill();

		characterBuilder.buildExperience();

		characterBuilder.buildBag();

		return characterBuilder.getResult();
	}
}
