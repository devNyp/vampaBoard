package com.vam.service;

import java.util.List;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;

public interface BoardService {
	 /* 게시판 등록 */
    public void enroll(BoardVO board);
	public List<BoardVO> getList();
    public BoardVO getPage(int bno) ;
    public int modify(BoardVO board);
    public int delete(int bno);
    /* 게시판 목록(페이징 적용) */
    public List<BoardVO> getListPaging(Criteria cri);
    /* 게시판 총 갯수 */
    public int getTotal();
}
