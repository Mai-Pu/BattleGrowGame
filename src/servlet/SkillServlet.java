package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Character;
import entity.SkillComponent;

/**
 * Servlet implementation class SkillServlet
 */
@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SkillServlet() {
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
		Character role = (Character) request.getSession().getAttribute("Character");
		Iterator<SkillComponent> is = role.getSkillIterator();
		// 技能名需要先解码
		String skillname = URLDecoder.decode(request.getParameter("skillname"), "UTF-8");
		SkillComponent skill = null;
		while (is.hasNext()) {
			skill = is.next();
			if (skill.getName().equals(skillname))
				break;
		}
		if (skill != null) {
			int select = Integer.parseInt(request.getParameter("select"));
			switch (select) {
			case 0:
				if (role.getMoney() >= 20) {
					role.strengthenSkill(skill);
					role.changeMoney(-20);
				}
				break;

			case 1:
				role.removeSkill(skill);
				break;
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
