package com.tenco.bank.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.bank.dto.boardDTO;
import com.tenco.bank.service.boardService;

@Controller
@RequestMapping("/blog")
public class mainController {
	
	private final boardService service;
	
	public mainController(boardService service) {
		this.service = service;
	}
	
	/** 메인 페이지
	 * 주소 : localhost:8080/blog/main
	 * @return
	 */
	@GetMapping("/main")
	public String blogPage(boardDTO dto, org.springframework.ui.Model model) {
		// TODO - JSP 들어가는지 확인
		System.out.println("메인 페이지 진입");
		
		List<boardDTO> board = service.readboard();
		
		
				
		model.addAttribute("board", board);
		System.out.println("board : " +board);

		return "blog";
	}
	
	/**
	 * [글쓰기] 클릭시 기능 작동
	 * @return
	 */
	@GetMapping("/board")
	public String blogClickPage() {
		// TODO - JSP 들어가는지 확인
		System.out.println("글쓰기 페이지 진입");
		return "board";
	}
	
	/**
	 * 게시판 작성
	 * @return
	 */
	@PostMapping("/blogBoardProc")
	public String blogClickProc(boardDTO dto) {
		
		service.createboard(dto);
		System.out.println("dto" + dto);
		
		return "redirect:/blog/main";
	}
	
	/**
	 * 게시판 글 삭제
	 * @param dto
	 * @return
	 */
	@GetMapping("/delete/{number}")
	public String remove(boardDTO dto, @PathVariable("number") Integer number) {
		
		service.deleteboard(number);
	
		return "redirect:/blog/main";
	}
	
	/**
	 * 게시글 수정 페이지로 이동
	 * @param number
	 * @return
	 */
	@GetMapping("/update/{number}")
	public String update(boardDTO dto, @PathVariable("number") Integer number, Model model) {	
		
		boardDTO board = service.update(number);
		
		model.addAttribute("board", board);
		
		return "board2";
	}
	
	/**
	 * 게시글 수정 기능 
	 * @return
	 */
	@PostMapping("/bupdateProc/{number}")
	public String updateProc(@PathVariable("number") Integer number, Model model,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("author") String author) {
		
		boardDTO dto = boardDTO.builder()
				.number(number)
				.title(title)
				.content(content)
				.author(author)
				.build();
						
		service.updateboard(dto);
		
		return "redirect:/blog/main";
	}

}
