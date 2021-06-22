package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.VO;

public class AddCartCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String p_idx = request.getParameter("idx"); //p_idx
		String m_idx = request.getParameter("m_idx");
		
		
		CVO cvo = new CVO();
		System.out.println(p_idx + " p addcartmodel");
		System.out.println(m_idx + " m addcartmodel");
		cvo.setM_idx(Integer.parseInt(m_idx));
		cvo.setP_idx(Integer.parseInt(p_idx));
		
		List<VO> list = DAO.getcart_list(Integer.parseInt(m_idx));
		
		VO vo2 = null;
		for (VO vo : list) {
			if(vo.getIdx().equalsIgnoreCase(p_idx)) {//이미 있으면
				vo2 = vo;
				break;
			}
		}
		
		
		if(vo2==null) {
			DAO.getCart_add(cvo);
		}else {
			DAO.getCart_plus(cvo);
		}
		
		return "MyController?cmd=onelist&m_idx=" + m_idx;
	}
}
