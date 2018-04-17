package com.sangbong.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sangbong.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	List<Board> findAll();
	List<Board> findByTitle(String title);
	List<Board> findByContent(String content);
	List<Board> findByWriterContaining(String writer);
}
