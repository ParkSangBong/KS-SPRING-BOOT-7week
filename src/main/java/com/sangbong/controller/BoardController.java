package com.sangbong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangbong.models.Board;
import com.sangbong.repositories.BoardRepository;
import com.sangbong.services.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@PatchMapping("/patch")
	Board patchBoard() {
		return boardService.patchBoard();
	}
	
	@GetMapping("/")
	List<Board> listGetAll(){
		return boardService.getFindAll();
	}
	
	@GetMapping("/title")
	List<Board> listGetTitle(){
		return boardService.getFindByTitle("제목..177");
	}
	
	@GetMapping("/content")
	List<Board> listGetContent(){
		return boardService.getFindByContent("내용..141");
	}
	
	@GetMapping("/writer")
	List<Board> listGetWriter(){
		return boardService.getFindWriterContaining("05");
	}
}
