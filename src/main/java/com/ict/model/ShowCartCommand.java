package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class ShowCartCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String m_idx = request.getParameter("m_idx");

		List<VO> list = DAO.getcart_list(Integer.parseInt(m_idx));
	
		int total = 0;

		for (VO cvo : list) {
			total += cvo.getQuant() * cvo.getP_saleprice();
		}

		request.setAttribute("list", list);
		request.setAttribute("total", total);
		request.setAttribute("m_idx", m_idx);
		return "view/viewcart.jsp";
	}
}
