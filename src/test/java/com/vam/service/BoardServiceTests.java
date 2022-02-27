package com.vam.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
@Log4j
public class BoardServiceTests {
	@Autowired
    private BoardService service;
    @Ignore
    @Test
    public void testEnroll() {
        
        BoardVO vo = new BoardVO();
        
        vo.setTitle("service test");
        vo.setContent("service test");
        vo.setWriter("service test");
        
        service.enroll(vo);        
    }
    @Ignore 
    @Test
    public void testGetList() {
    	List<BoardVO> list = service.getList();
    	
    	list.forEach(board -> log.info(board.getTitle()));
    }
    @Test
    public void testdelet() {
    	service.delete(5);
    	
    }        
}
