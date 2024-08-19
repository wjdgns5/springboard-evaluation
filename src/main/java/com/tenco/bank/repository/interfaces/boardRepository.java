package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.dto.boardDTO;

@Mapper
public interface boardRepository {
	// TODO - 추가
	public int insert(boardDTO dto);

	// TODO - 리스트 정렬
	public List<boardDTO> select();
	
	// TODO - 삭제
	public int delete(Integer number);
	
	// TODO - 수정
	public int update(Integer number);
	
	// TODO - 검색 number를 사용하여 제목, 내용, 작성자 찾기
	public boardDTO search(Integer number);

}