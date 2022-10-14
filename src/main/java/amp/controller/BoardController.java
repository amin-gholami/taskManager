package amp.controller;

import amp.common.dto.request.CreateBoardRequest;
import amp.common.dto.response.CreateBoardResponse;
import amp.common.dto.response.GetBoardResponse;
import amp.common.dto.Response;
import amp.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<Response<CreateBoardResponse>> createBoard(@RequestBody CreateBoardRequest createBoardRequest,
                                                                     HttpServletRequest request) {
        return new ResponseEntity<>(new Response<CreateBoardResponse>().build()
                .setMessage(boardService.createBoard(createBoardRequest))
                .setPath(request.getRequestURI()), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteBoard(@PathVariable("id") Long id,
                                                        HttpServletRequest request) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(new Response<String>().build()
                .setMessage("board is deleted")
                .setPath(request.getRequestURI()), OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetBoardResponse>> getBoard(@PathVariable("id") Long id,
                                                               HttpServletRequest request) {
        return new ResponseEntity<>(new Response<GetBoardResponse>().build()
                .setMessage(boardService.getBoardResponse(id))
                .setPath(request.getRequestURI()), OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response<CreateBoardResponse>> editBoard(@RequestBody CreateBoardRequest createBoardRequest,
                                                                     @PathVariable("id") Long id,
                                                                     HttpServletRequest request) {
        return new ResponseEntity<>(new Response<CreateBoardResponse>().build()
                .setMessage(boardService.editBoard(createBoardRequest,id))
                .setPath(request.getRequestURI()), OK);
    }
}
