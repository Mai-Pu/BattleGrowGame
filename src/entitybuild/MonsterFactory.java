package entitybuild;

import java.util.HashMap;

import entity.Monster;
import monster.BlockHead;

public class MonsterFactory {
	private HashMap<String, Monster> monsters = new HashMap<>();

	public Monster getMonster(String key, int rank) {
		Monster monster = null;
		if (monsters.containsKey(key)) {
			monster = monsters.get(key);
		} else {
			if ("BlockHead".equals(key)) {
				monster = new BlockHead();
				monsters.put(key, monster);
			}
		}
		if (monster != null)
			monster.setRank(rank);
		return monster;
	}
}
