package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Character;
import entity.Equipment;

/**
 * Servlet implementation class BackpackServlet
 */
@WebServlet("/BackpackServlet")
public class BackpackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackpackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String select = request.getParameter("select");
		Character role = (Character) request.getSession().getAttribute("Character");
		List<Equipment> bag = role.getBag();
		if ("seq".equals(select)) {
			// 强化一次要10个金币，金币不够点击无效
			if (role.getMoney() >= 10) {
				role.strengthenEquipment(request.getParameter("equipment"));
				role.changeMoney(-10);
			}
		} else {
			int i = Integer.parseInt(request.getParameter("index"));
			if ("0".equals(select)) {
				role.wearEquipment(bag.get(i));
			} else if ("1".equals(select)) {
				role.takeOffEquipment(bag.get(i));
			} else if ("2".equals(select)) {
				// 强化一次要10个金币，金币不够点击无效
				if (role.getMoney() >= 10) {
					bag.get(i).strengthen();
					role.changeMoney(-10);
				}
			} else if ("3".equals(select)) {
				role.removeFromBag(bag.get(i));
			}
		}
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
