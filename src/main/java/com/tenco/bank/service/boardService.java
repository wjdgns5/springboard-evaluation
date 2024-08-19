package com.tenco.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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
	 * 글 수정 기능
	 * @param number
	 */
	public void updateboard(@PathVariable("number") Integer number) { 
		
		boardDTO dto = boardRepository.search(number);
		
		boardRepository.update(number);
		
		boardRepository.select();
	}
	
	/**
	 * 글 업데이트 페이지 이동
	 * @return
	 */
	public boardDTO update(@PathVariable("number") Integer number) {
		
		boardDTO dto = boardRepository.search(number);
		
		return dto;
	}
	

	
	
	
	
	

}
