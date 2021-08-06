package com.bit;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bit.domain.Board;
import com.bit.persistence.BoardRepository;

//@RunWith(SpringRunner.class) 버전이 낮은곳에서 쓸때
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository bRepo;
	
	
	@Test
	public void inspect() {
		Class<?> clz = bRepo.getClass();
		System.out.println("1.***** : " + clz.getName());
		Class<?> interfaces[] = clz.getInterfaces();
		Stream.of(interfaces).forEach
			(inter -> System.out.println("2.***** : " + inter.getName()));
		Class<?> superClasses = clz.getSuperclass();
		System.out.println("3.***** : " + superClasses.getName());
		//System.out.println("테스트");
	}
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("게시물의 제목");
		board.setContent("게시물의 내용넣기");
		board.setWriter("길동이");
		
		bRepo.save(board);
	}
	
	@Test
	public void testRead() {
		//select * from tbl_boards where bno = 1;
		Optional<Board> board = bRepo.findById(1L); //bno 타입이 Long선언
		System.out.println("*********result:" + board);
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Read First.........");
		Optional<Board> board = bRepo.findById(3L);
		System.out.println("Update Title.............");
		board.get().setTitle("수정된 제목입니다");
		System.out.println("Call Save().............");
		bRepo.save(board.get());
	}
	
	@Test
	public void testDelete() {
		System.out.println("Delete Entity...........");
		//delete from tbl_boards where bno = 1
		bRepo.deleteById(1L);
	}

}
