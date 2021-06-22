package com.ict.db;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	// 리스트
	public static List<VO> getList(String category){
		List<VO> list = null;
		list = getSession().selectList("list", category);
		return list;
	}
	
	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	// 로그인 
	public static MVO getLogIn(MVO m_vo) {
		MVO mvo = null;
		mvo = getSession().selectOne("login", m_vo);
		return mvo;
	}
	
	// 상품등록
	public static int getProductInsert(VO vo) {
		int result = 0 ;
		try {
			result = getSession().insert("product_add", vo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static void getCart_add(CVO cvo) {
		System.out.println(cvo.getP_idx() + " p DAO");
		System.out.println(cvo.getM_idx() + " m DAO");
		
		getSession().insert("cart_add", cvo);
		ss.commit();
		
	}

	public static void getCart_plus(CVO cvo) {
		System.out.println(cvo.getP_idx() + " p DAO");
		System.out.println(cvo.getM_idx() + " m DAO");
		
		getSession().update("cart_plus" , cvo);
		
		System.out.println("멈춰!");
		
		ss.commit();
		
	}
	public static List<VO> getcart_list(int m_idx) {
		List<VO> list = null; 
		list = getSession().selectList("cart_list", m_idx);
		return list;
	}


	public static void getCart_update(CVO cvo) {
		
		System.out.println(cvo.getP_idx());
		System.out.println(cvo.getM_idx());
		System.out.println(cvo.getQuant());
		System.out.println("------------");
		
		getSession().update("cart_update", cvo);
		
	}

	public static void getCart_delete(CVO cvo) {
		getSession().delete("cart_delete", cvo);
		
	}
}

















