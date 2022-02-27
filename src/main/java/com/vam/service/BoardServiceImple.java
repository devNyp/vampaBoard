package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BoardMapper;
import com.vam.model.BoardVO;
import com.vam.model.Criteria;

@Service
public class BoardServiceImple implements BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public BoardVO getPage(int bno) {
		return mapper.getPage(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}

	@Override
	public int delete(int bno) {		
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListPaging(cri);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}

}
