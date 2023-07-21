package kr.eddi.demo.board.controller.requestForm;

import kr.eddi.demo.board.service.request.BoardRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardRequestForm {

    final private String title;
    final private String writer;
    final private String content;

    public BoardRequest toBoardRequest () {
        return new BoardRequest(title, writer, content);
    }
}
