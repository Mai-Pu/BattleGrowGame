package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Character implements Battler {

	private Career career;
	private int rank;
	private int money;
	private HashMap<String, Equipment> equipments;
	private Skills skills;
	private int experience;
	private List<Equipment> bag;

	/*
	 * 和职业以及状态相关的函数
	 */
	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String getType() {
		// TODO 自动生成的方法存根
		return career.getType();
	}

	// 获得新技能的话返回true
	public int getBaseHp() {
		return career.getHp();
	}

	public int getBaseAttack() {
		// 这个函数获得的是基础伤害，包括职业伤害和装备伤害， 不包括技能伤害
		Equipment e = equipments.get("Weapon");
		if (e != null)
			return career.getAttack() + e.getPower();
		else
			return career.getAttack();
	}

	public int getBaseDefense() {
		// 这个函数获得的是基础数值，包括职业数值和装备装备， 不包括技能数值
		Equipment e = equipments.get("Cloth");
		if (e != null)
			return career.getDefense() + e.getPower();
		else
			return career.getDefense();
	}

	public int getBaseSpeed() {
		// 这个函数获得的是基础数值，包括职业数值和装备装备， 不包括技能数值
		Equipment e = equipments.get("Shoe");
		if (e != null)
			return career.getSpeed() + e.getPower();
		else
			return career.getSpeed();
	}

	@Override
	public int attack() {
		// TODO 自动生成的方法存根
		return getBaseAttack() + skills.attack();
	}

	@Override
	public int defense() {
		// TODO 自动生成的方法存根
		return getBaseDefense();
	}

	public int speed() {
		return getBaseHp();
	}

	public int hp() {
		return getBaseHp();
	}

	public boolean strengthen() {
		SkillComponent learn = career.strengthen(rank);
		rank += 1;
		if (learn != null) {
			skills.add(learn);
			return true;
		}
		return false;
	}

	public boolean increaseExperience(int experience) {
		this.experience += experience;
		if (this.experience >= 100) {// 经验值到达100后自动升级
			this.experience -= 100;
			return strengthen();
		}
		return false;
	}

	public void changeMoney(int money) {
		this.money += money;
	}

	/*
	 * 和背包以及装备相关的一些函数
	 */

	public HashMap<String, Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(HashMap<String, Equipment> equipments) {
		this.equipments = equipments;
	}

	public List<Equipment> getBag() {
		return bag;
	}

	public void setBag(List<Equipment> bag) {
		this.bag = bag;
	}

	public void addToBag(Equipment e) {
		if (bag.size() < 50)
			bag.add(e);
	}

	public void removeFromBag(Equipment e) {
		bag.remove(e);
	}

	public void wearEquipment(Equipment e) {
		equipments.put(e.getType(), e);
	}

	public void takeOffEquipment(Equipment e) {
		equipments.remove(e.getType());
	}

	public void strengthenEquipment(String key) {
		Equipment e = equipments.get(key);
		if (e != null)
			e.strengthen();
	}

	/*
	 * 和技能相关的一些函数
	 */
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public Iterator<SkillComponent> getSkillIterator() {
		return skills.getIterator();
	}

	public void strengthenSkill(SkillComponent skill) {
		skill.upgrade();
	}

	public void removeSkill(SkillComponent skill) {
		skills.remove(skill);
	}

}
