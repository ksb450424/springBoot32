package springrest.exam.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "boardNo")
public class Board {

	private long boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;

}
