package springrest.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.domain.Board;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/boards")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = "*")
public class BoardController {

	List<Board> boardList = new ArrayList<>();

	public BoardController() {
		Board board = new Board();
		board.setBoardNo(1);
		board.setTitle("아기공룡 둘리 한자대탐험");
		board.setContent("둘리 학습만화 시리즈");
		board.setWriter("김수정");
		board.setRegDate(LocalDateTime.now());

		boardList.add(board);

		board = new Board();
		board.setBoardNo(2);
		board.setTitle("고래 도서관");
		board.setContent("바다 도서관 이야기");
		board.setWriter("지드루");
		board.setRegDate(LocalDateTime.now());
		boardList.add(board);
	}

	@Operation(summary = "Boards 의 리스트를 출력")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Board 리스트",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Board.class)) })
	})
	@GetMapping
	public ResponseEntity<List<Board>> list() {
		log.info("list 요청");

		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);

		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@RequestBody Board board) {
		log.info("register 요청");
		boardList.add(board);
		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삽입했어용", HttpStatus.CREATED);

		return entity;
	}

	@Operation(summary = "boardNo 에 해당하는 Board 글 출력")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Board 글",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Board.class)) }),
			@ApiResponse(responseCode = "404", description = "boardNo 에 해당하는 Board 글이 없음",
					content = @Content) })
	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		log.info("read 요청");

		Board board = new Board();
		board.setBoardNo(boardNo);
	 	int index = boardList.indexOf(board);
		if (index >= 0)
			 board = boardList.get(index);

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
		log.info("remove 요청");
		Board board = new Board();
		board.setBoardNo(boardNo);
		boardList.remove(board);

		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삭제했어용", HttpStatus.OK);

		return entity;
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modify 요청");
		Board board1 = new Board();
		board1.setBoardNo(boardNo);
		int index = boardList.indexOf(board1);
		if (index >= 0)
			board1 = boardList.get(index);
		board1.setWriter(board.getWriter());
		board1.setContent(board.getContent());
		board1.setTitle(board.getTitle());
		board1.setRegDate(board.getRegDate());

		ResponseEntity<String> entity =
				new ResponseEntity<>("성공적으로 수정했어용", HttpStatus.OK);
		return entity;
	}

	@GetMapping("/day")
	public String day() {
		LocalDate ld = LocalDate.now();
		DayOfWeek dow = ld.getDayOfWeek();
		String korDay = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		return korDay;
	}

	@GetMapping(value = "/friends")
	public String getFriends() {
		log.info("getFriends 메소드가 호출되었습니다.");
		return "둘리 또치 도우너";
	}
}
