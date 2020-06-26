package com.icia.cheatingday.order.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.icia.cheatingday.order.entity.DetailorderEntity;

@Repository
public class OrderDao {
	private SqlSessionTemplate tpl;
	
	// 1. 장바구니 추가
	public int orderInsert(DetailorderEntity order) {
		return tpl.insert("orderAndReviewMapper.insert", order);
	}
	
	// 2. 장바구니 목록
	public List<DetailorderEntity> order(String uUsername) {
		return tpl.selectList("orderAndReviewMapper.orderList", uUsername);
	}
	
	// 3. 장바구니 삭제
	public int orderDelete(int dNo) {
		return tpl.delete("orderAndReviewMapper.delete", dNo); 
	}
	
	// 4. 장바구니 수정?
	public int orderUpdate(DetailorderEntity order) {
		return tpl.update("orderAndReviewMapper.orderUpdate", order);
	}
	
	// 5. 장바구니 금액 합계
	public int orderAllSum(String uUsername) {
		tpl.selectOne("orderAndReviewMapper.orderAllSum", uUsername);
		return tpl.selectOne("orderAndReviewMapper.orderAllSum", uUsername);
	}
	
	// 6. 장바구니 상품수량변경
	public int orderUpdatedCnt(DetailorderEntity order) {
		return tpl.update("orderAndReviewMapper.orderUpdatedCnt", order);
	}
}