package com.vam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.model.PageMakerDTO;
import com.vam.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Autowired
	BoardService bservice;
//	
//	@GetMapping("/list")
//    // => @RequestMapping(value="list", method=RequestMethod.GET)
//    public void boardListGET(Model model) {
//        
//        log.info("게시판 목록 페이지 진입");
//        //같은 것이 String 반환으로 return /board/list인데!!!!! 저 경로 그대로 jsp를 가져와준다는걸 알 수 있지
//        model.addAttribute("list", bservice.getList());        
//    }
//    
//    /* 게시판 목록 페이지 접속(페이징 적용) */
//    @GetMapping("/list")
//    public void boardListGET(Model model, Criteria cri) {        
//        log.info("boardListGET");        
//        model.addAttribute("list", bservice.getListPaging(cri));
//        
//    }
//    
	 /* 게시판 목록 페이지 접속(페이징 적용) */
    @GetMapping("/list")
    public void boardListGET(Model model, Criteria cri) {
        
        log.info("boardListGET");        
        model.addAttribute("list", bservice.getListPaging(cri));        
        int total = bservice.getTotal();        
        PageMakerDTO pageMake = new PageMakerDTO(cri, total);        
        model.addAttribute("pageMaker", pageMake);        
    }    
	
    @GetMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
    public void boardEnrollGET() {        
        log.info("게시판 등록 페이지 진입");        
    }
    
    @PostMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {        
        bservice.enroll(board);
        rttr.addFlashAttribute("result", "enrol success");
        
        return "redirect:/board/list";
    }
    
    @GetMapping("/get")
    public void boardGetPageGet(int bno, Model model, Criteria cri) {
    	model.addAttribute("pageInfo", bservice.getPage(bno));
    	model.addAttribute("cri", cri);
	}
    
    /* 수정 페이지 이동 */
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model) {        
        model.addAttribute("pageInfo", bservice.getPage(bno));        
    }
/* 페이지 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {        
        bservice.modify(board);        
        rttr.addFlashAttribute("result", "modify success");        
        return "redirect:/board/list";
        
    }


}
