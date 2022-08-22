package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;

@SpringBootTest
public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;
	
	// save 테스트
	//@Test
	public void saveTest() {
		assertEquals(1, commentDao.save(Comment.builder().content("aaa").bno(1).writer("spring").build())); 
	}
	// findByBno 테스트
	//@Test
	public void findByBnoTest() {
		assertEquals(0, commentDao.findByBno(1500).size());
		assertEquals(1, commentDao.findByBno(2).size());
	}
	
	// findWriterByBno 테스트
	//@Test
	public void findWriterByBnoTest() {
		assertEquals(true, commentDao.findWriterById(1500).isEmpty());
		assertEquals(true, commentDao.findWriterById(2).isPresent());
	}
	// deleteByCno 테스트
	@Transactional
	//@Test
	public void deleteByCnoTest() {
		assertEquals(1, commentDao.deleteByCno(61));
		assertEquals(0, commentDao.deleteByCno(1500));
	}
	// deleteByBno 테스트
	@Transactional
	@Test
	public void deleteByBnoTest() {
		assertEquals(0, commentDao.deleteByBno(1));
		assertEquals(0, commentDao.deleteByBno(1500));
	}
}
