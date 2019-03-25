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
			addMessage("你们两个大战了20回合，谁也奈何不了谁，各自离开了", list);
		}
		int damage = attacker.attack() - defenser.defense();
		if (damage <= 0) {
			damage = 0;
		}
		d_hp -= damage;
		if (attacker instanceof Character) {
			addMessage("你对怪物造成了" + damage + "点伤害," + "怪物还剩下" + d_hp + "点生命值", list);
			if (d_hp <= 0) {
				addMessage("区区一个" + defenser.getType() + "看起来还不是你的对手啊", list);
				Monster monster = (Monster) defenser;
				Character role = (Character) attacker;
				int money = monster.getMoney();
				Equipment e = monster.getDrop();
				int exp = monster.getExperience();
				addMessage(defenser.getType() + "为你的钱包贡献了" + money + "个金币", list);
				role.changeMoney(money);
				addMessage("你增加了" + exp + "点经验", list);
				boolean learn = role.increaseExperience(exp);
				if (learn)
					addMessage("经过战斗,你好像学会了一个技能,但是也可能因为你的脑容量满了导致没学会", list);
				addMessage(defenser.getType() + "掉落了:" + e.getName(), list);
				role.addToBag(e);
				addMessage("战斗结束，你获得了胜利！", list);
				return;
			}
		} else {
			addMessage("怪物对你造成了" + damage + "点伤害," + "你还剩下" + d_hp + "点生命值", list);
			if (d_hp <= 0) {
				addMessage("你被打败了，看起来你还不够强大", list);
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
		// 怪物强度在人物强度的0.8-1.2倍之间浮动
		Monster monster = monsterFactory.getMonster("BlockHead", (int) (role.getRank() * (Math.random() * 0.4 + 0.8)));
		addMessage(monster.desribe(), list);
		// 战斗结束后记得回复生命值
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
