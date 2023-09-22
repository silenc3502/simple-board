package kr.eddi.demo.board.controller;

import kr.eddi.demo.board.controller.requestForm.BoardRequestForm;
import kr.eddi.demo.board.entity.Board;
import kr.eddi.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService boardService;

    @PostMapping("/register")
    public Board boardRegister (@RequestBody BoardRequestForm boardRequestForm) {
        log.info("boardRegister()");

        return boardService.register(boardRequestForm.toBoardRequest());
    }

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("boardList()");

        return boardService.list();
    }

    @GetMapping("/{boardId}")
    public Board boardRead(@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void boardRemove(@PathVariable("boardId") Long boardId) {
        log.info("boardRemove()");

        boardService.remove(boardId);
    }

    @PutMapping("/{boardId}")
    public Board boardModify(@PathVariable("boardId") Long boardId,
                             @RequestBody BoardRequestForm boardRequestForm) {

        log.info("boardModify(): " + boardRequestForm + "id: " + boardId);

        return boardService.modify(boardId, boardRequestForm.toBoardRequest());
    }
    
    @GetMapping("/deploy-test")
    public String printString () {
        log.info("printString()");

        return "Deploy Test";
    }
}
