package amp.controller;

import amp.common.dto.Response;
import amp.common.dto.request.CreateCardRequest;
import amp.common.dto.response.CreateCardResponse;
import amp.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/board")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/{boardId}/card")
    public ResponseEntity<Response<CreateCardResponse>> createCard(@RequestBody CreateCardRequest createCardRequest,
                                                                   @PathVariable("boardId") Long boardId,
                                                                   HttpServletRequest request) {
        return new ResponseEntity<>(new Response<CreateCardResponse>().build()
                .setMessage(cardService.createCard(createCardRequest, boardId))
                .setPath(request.getRequestURI()), OK);

    }

    @GetMapping("/{boardId}/card/{cardId}")
    public ResponseEntity<Response<CreateCardResponse>> getCard(@PathVariable("boardId") Long boardId,
                                                                @PathVariable("cardId") Long cardId,
                                                                HttpServletRequest request) {
        return new ResponseEntity<>(new Response<CreateCardResponse>().build()
                .setMessage(cardService.getCard(boardId, cardId))
                .setPath(request.getRequestURI()), OK);

    }

    @PutMapping("/{boardId}/card/{cardId}")
    public ResponseEntity<Response<CreateCardResponse>> editCard(@RequestBody CreateCardRequest createCardRequest,
                                                                 @PathVariable("boardId") Long boardId,
                                                                 @PathVariable("cardId") Long cardId,
                                                                 HttpServletRequest request) {
        return new ResponseEntity<>(new Response<CreateCardResponse>().build()
                .setMessage(cardService.editCard(createCardRequest, boardId, cardId))
                .setPath(request.getRequestURI()), OK);

    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteCard(@PathVariable("boardId") Long boardId,
                                                       @PathVariable("cardId") Long cardId,
                                                       HttpServletRequest request) {
        cardService.deleteCard(boardId, cardId);
        return new ResponseEntity<>(new Response<String>().build()
                .setMessage("card deleted successfully")
                .setPath(request.getRequestURI()), OK);

    }
}
