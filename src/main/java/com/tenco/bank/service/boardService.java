package com.tenco.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.bank.dto.boardDTO;
import com.tenco.bank.repository.interfaces.boardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class boardService {
	
	@Autowired
	private final boardRepository boardRepository;
	
	/**
	 * 게시판 글 등록
	 * @param dto
	 */
	@Transactional
	public void createboard(boardDTO dto) {
		
		boardRepository.insert(dto);
		System.out.println("!!!!!!!!!!!!!!!!");
		System.out.println("dto : dto");
		boardRepository.select();
	}

	/**
	 * 글 리스트 목록 
	 * @return
	 */
	public List<boardDTO> readboard() {
		
		List<boardDTO> dto = null;
		
		dto = boardRepository.select();
		
		return dto;
	}
	
	/**
	 * 글 삭제 기능
	 * @param dto
	 */
	public void deleteboard(@PathVariable("number") Integer number) {
		
		boardDTO dto = boardRepository.search(number);
		
		boardRepository.delete(number);
		
		boardRepository.select();
	}
	
	/**
	 * 글 수정 페이지 이동
	 * @return
	 */
	public boardDTO update(@PathVariable("number") Integer number) {
		
		boardDTO dto = boardRepository.search(number);
		
		return dto;
	}
	
	/**
	 * 글 수정 기능
	 * @param number
	 */
	@Transactional
	public void updateboard(@PathVariable("number") Integer number, boardDTO dto) { 
		
		System.out.println("서비스 : dto : " +dto);
		
	//	dto = boardRepository.search(number);
	//	System.out.println("글 수정 하기 전 dto : " + dto);
	//	boardRepository.update(dto); <-- 문제
		
		boardRepository.update(dto);
		
		System.out.println("글 수정 후 dto : " + dto);
	}
	
	
	

	
	
	
	
	

}
