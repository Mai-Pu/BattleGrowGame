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
	 * ��ְҵ�Լ�״̬��صĺ���
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
		// TODO �Զ����ɵķ������
		return career.getType();
	}

	// ����¼��ܵĻ�����true
	public int getBaseHp() {
		return career.getHp();
	}

	public int getBaseAttack() {
		// ���������õ��ǻ����˺�������ְҵ�˺���װ���˺��� �����������˺�
		Equipment e = equipments.get("Weapon");
		if (e != null)
			return career.getAttack() + e.getPower();
		else
			return career.getAttack();
	}

	public int getBaseDefense() {
		// ���������õ��ǻ�����ֵ������ְҵ��ֵ��װ��װ���� ������������ֵ
		Equipment e = equipments.get("Cloth");
		if (e != null)
			return career.getDefense() + e.getPower();
		else
			return career.getDefense();
	}

	public int getBaseSpeed() {
		// ���������õ��ǻ�����ֵ������ְҵ��ֵ��װ��װ���� ������������ֵ
		Equipment e = equipments.get("Shoe");
		if (e != null)
			return career.getSpeed() + e.getPower();
		else
			return career.getSpeed();
	}

	@Override
	public int attack() {
		// TODO �Զ����ɵķ������
		return getBaseAttack() + skills.attack();
	}

	@Override
	public int defense() {
		// TODO �Զ����ɵķ������
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
		if (this.experience >= 100) {// ����ֵ����100���Զ�����
			this.experience -= 100;
			return strengthen();
		}
		return false;
	}

	public void changeMoney(int money) {
		this.money += money;
	}

	/*
	 * �ͱ����Լ�װ����ص�һЩ����
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
	 * �ͼ�����ص�һЩ����
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
