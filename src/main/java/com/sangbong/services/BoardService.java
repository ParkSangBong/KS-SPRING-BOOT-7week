package com.sangbong.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangbong.models.Board;
import com.sangbong.repositories.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public Board patchBoard() {
		//1. findById
		Optional<Board> board = boardRepository.findById(1L);
		
		//2. Patch
		if(board.isPresent()) {
			Board patchBoard = board.get();
			patchBoard.setTitle("(patch)" + patchBoard.getTitle());
			
			//3. 저장
			return boardRepository.save(patchBoard);
		}
		
		return null;
	}
	
	public List<Board> getFindAll(){
		return boardRepository.findAll();
	}
	public List<Board> getFindByTitle(String title){
		return boardRepository.findByTitle(title);
	}
	public List<Board> getFindByContent(String content){
		return boardRepository.findByContent(content);
	}
	public List<Board> getFindWriterContaining(String writer){
		return boardRepository.findByWriterContaining(writer);
	}
}