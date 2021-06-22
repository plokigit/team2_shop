package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class deleteCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String m_idx = request.getParameter("m_idx");
		
		CVO cvo = new CVO();
		
		cvo.setP_idx(Integer.parseInt(idx));
		cvo.setM_idx(Integer.parseInt(m_idx));
		
		DAO.getCart_delete(cvo);
		
		return "MyController?cmd=showCart&m_idx=" + m_idx;
	}
}
