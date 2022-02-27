package com.vam.mapper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
@Log4j
public class BoardMapperTests {
	
    
    @Autowired
    private BoardMapper mapper;
    
    @Ignore
    @Test
    public void testEnroll() {
        
    	BoardVO vo = new BoardVO();
        
        vo.setTitle("mapper test");
        vo.setContent("mapper test");
        vo.setWriter("mapper test");
        
        mapper.enroll(vo);
        
    }
    
    /* 게시판 목록(페이징 적용)테스트 */
   @Test
   public void testGetListPaging() {
       
       Criteria cri = new Criteria();
                        
       List list = mapper.getListPaging(cri);
       
       list.forEach(board -> log.info("" + board));
   }
}
