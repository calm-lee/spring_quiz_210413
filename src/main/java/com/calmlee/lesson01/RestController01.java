package com.calmlee.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class RestController01 {

	@RequestMapping("/1")
	public List<Map> printList() {
		List<Map> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();

		map.put("rate", 15);
		map.put("Title", "기생충");
		map.put("Director", "봉준호");
		map.put("Time", 15);
		list.add(map);

		Map<String, Object> map2 = new HashMap<>();

		map2.put("rate", 15);
		map2.put("Title", "올드보이");
		map2.put("Director", "박찬욱");
		map2.put("Time", 15);
		list.add(map2);

		return list;

	}

	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		List<Board> result = new ArrayList<>();

		Board board = new Board();
		board.setTitle("안녕하세요");
		board.setUser("rose");
		board.setContent("방가방가");
		result.add(board);

		board = new Board(); // board 변수 재활용
		board.setTitle("와우");
		board.setUser("제니");
		board.setContent("아직 화요일밖에 안됐어요");
		result.add(board);

		board = new Board();
		board.setTitle("오늘 데이트");
		board.setUser("지수");
		board.setContent("노잼");
		result.add(board);

		return result;
	}

	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_03() {
		Board board = new Board();
		board.setTitle("안녕하세요");
		board.setUser("haglu");
		board.setContent("방가방가");

		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
