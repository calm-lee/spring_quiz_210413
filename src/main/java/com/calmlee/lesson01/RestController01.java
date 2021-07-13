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
		map.put("Title", "�����");
		map.put("Director", "����ȣ");
		map.put("Time", 15);
		list.add(map);

		Map<String, Object> map2 = new HashMap<>();

		map2.put("rate", 15);
		map2.put("Title", "�õ庸��");
		map2.put("Director", "������");
		map2.put("Time", 15);
		list.add(map2);

		return list;

	}

	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		List<Board> result = new ArrayList<>();

		Board board = new Board();
		board.setTitle("�ȳ��ϼ���");
		board.setUser("rose");
		board.setContent("�氡�氡");
		result.add(board);

		board = new Board(); // board ���� ��Ȱ��
		board.setTitle("�Ϳ�");
		board.setUser("����");
		board.setContent("���� ȭ���Ϲۿ� �ȵƾ��");
		result.add(board);

		board = new Board();
		board.setTitle("���� ����Ʈ");
		board.setUser("����");
		board.setContent("����");
		result.add(board);

		return result;
	}

	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_03() {
		Board board = new Board();
		board.setTitle("�ȳ��ϼ���");
		board.setUser("haglu");
		board.setContent("�氡�氡");

		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
