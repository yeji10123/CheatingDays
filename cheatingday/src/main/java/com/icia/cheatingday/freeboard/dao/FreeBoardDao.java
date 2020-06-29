package com.icia.cheatingday.freeboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.cheatingday.freeboard.entity.FreeBoard;


@Repository
public class FreeBoardDao {
	@Autowired
	private SqlSessionTemplate tpl;
//목록 불러오기, 글 읽기  쓰기 수정 삭제
	public List<FreeBoard> findAll(int startRowNum, int endRowNum) {
		Map<String,Integer> map = new HashMap<>();
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		return tpl.selectList("freeBoardMapper.findAll", map);
	}
	public List<FreeBoard> findAllByUsername(int startRowNum, int endRowNum, String username){
		Map<String, Object> map = new HashMap<>();
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		map.put("username", username);
		return tpl.selectList("freeBoardMapper.findAllByUsername",map);
		
	}
	public FreeBoard findById(Integer bno) {
		return tpl.selectOne("freeBoardMapper.findById",bno);
	}
	public int insert(FreeBoard board) {
		return tpl.insert("freeBoardMapper.insert",board);
	}
	public int update(FreeBoard board) {
		return tpl.update("freeBoardMapper.update",board);
	}
	public int delete(Integer bno) {
		return tpl.delete("freeBoardMapper.delete",bno);
	}
	public int count(String username) {
		return tpl.selectOne("freeBoardMapper.count",username);
	}
	
}
