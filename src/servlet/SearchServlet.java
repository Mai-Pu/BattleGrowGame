package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Battler;
import entity.Character;
import entity.Equipment;
import entity.Monster;
import entitybuild.MonsterFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void addMessage(String s, List<String> list) {
		list.add(s);
	}

	private void battle(Battler attacker, Battler defenser, int a_hp, int d_hp, List<String> list, int turn) {
		if (turn > 20) {
			addMessage("����������ս��20�غϣ�˭Ҳ�κβ���˭�������뿪��", list);
		}
		int damage = attacker.attack() - defenser.defense();
		if (damage <= 0) {
			damage = 0;
		}
		d_hp -= damage;
		if (attacker instanceof Character) {
			addMessage("��Թ��������" + damage + "���˺�," + "���ﻹʣ��" + d_hp + "������ֵ", list);
			if (d_hp <= 0) {
				addMessage("����һ��" + defenser.getType() + "��������������Ķ��ְ�", list);
				Monster monster = (Monster) defenser;
				Character role = (Character) attacker;
				int money = monster.getMoney();
				Equipment e = monster.getDrop();
				int exp = monster.getExperience();
				addMessage(defenser.getType() + "Ϊ���Ǯ��������" + money + "�����", list);
				role.changeMoney(money);
				addMessage("��������" + exp + "�㾭��", list);
				boolean learn = role.increaseExperience(exp);
				if (learn)
					addMessage("����ս��,�����ѧ����һ������,����Ҳ������Ϊ������������˵���ûѧ��", list);
				addMessage(defenser.getType() + "������:" + e.getName(), list);
				role.addToBag(e);
				addMessage("ս��������������ʤ����", list);
				return;
			}
		} else {
			addMessage("������������" + damage + "���˺�," + "�㻹ʣ��" + d_hp + "������ֵ", list);
			if (d_hp <= 0) {
				addMessage("�㱻����ˣ��������㻹����ǿ��", list);
				return;
			}
		}
		battle(defenser, attacker, d_hp, a_hp, list, turn + 1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> list = (List) request.getSession().getAttribute("note");
		list.clear();
		Character role = (Character) request.getSession().getAttribute("Character");
		MonsterFactory monsterFactory = (MonsterFactory) request.getSession().getAttribute("MonsterFactory");
		// ����ǿ��������ǿ�ȵ�0.8-1.2��֮�両��
		Monster monster = monsterFactory.getMonster("BlockHead", (int) (role.getRank() * (Math.random() * 0.4 + 0.8)));
		addMessage(monster.desribe(), list);
		// ս��������ǵûظ�����ֵ
		if (role.speed() >= monster.speed())
			battle(role, monster, role.hp(), monster.hp(), list, 1);
		else
			battle(monster, role, monster.hp(), role.hp(), list, 1);
		response.sendRedirect(request.getHeader("Referer"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
