package amp.service;

import amp.common.dto.request.CreateCardRequest;
import amp.common.dto.response.CreateCardResponse;
import amp.model.Card;
import amp.model.User;
import amp.repository.CardRepository;
import org.springframework.stereotype.Service;
import amp.common.exceptions.*;
import java.sql.Timestamp;
import java.util.*;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final UserService userService;
    private final BoardService boardService;

    public CardService(CardRepository cardRepository, UserService userService, BoardService boardService) {
        this.cardRepository = cardRepository;
        this.userService = userService;
        this.boardService = boardService;
    }

    public CreateCardResponse createCard(CreateCardRequest createCardRequest,Long boardId){
        Card card = new Card();
        Date date = new Date();
        card.setMembers(getUserList(createCardRequest.getMembers()));
        card.setBoard(boardService.getBoard(boardId));
        card.setCardTitle(createCardRequest.getCardTitle());
        card.setCreatedOn(new Timestamp(date.getTime()));
        card.setDescription(createCardRequest.getDescription());
        Card savedCard = cardRepository.save(card);
        return CreateCardResponse.builder().boardId(savedCard.getBoard().getId())
                .cardTitle(savedCard.getCardTitle())
                .description(savedCard.getDescription())
                .userList(savedCard.getMembers())
                .cardId(savedCard.getId())
                .build();
    }

    public CreateCardResponse editCard(CreateCardRequest createCardRequest,Long boardId,
                                       Long cardId){
        Date date = new Date();
        Card card = findCardAndCheckBoard(cardId,boardId);
        card.setMembers(getUserList(createCardRequest.getMembers()));
        card.setBoard(boardService.getBoard(boardId));
        card.setCardTitle(createCardRequest.getCardTitle());
        card.setModifiedOn(new Timestamp(date.getTime()));
        card.setDescription(createCardRequest.getDescription());
        Card savedCard = cardRepository.save(card);
        return CreateCardResponse.builder().boardId(savedCard.getBoard().getId())
                .cardTitle(savedCard.getCardTitle())
                .description(savedCard.getDescription())
                .userList(savedCard.getMembers())
                .cardId(savedCard.getId())
                .build();

    }

    public void deleteCard(Long boardId,Long cardId){
        Card card = findCardAndCheckBoard(cardId,boardId);
        cardRepository.delete(card);
    }

    private Card findCardAndCheckBoard(Long cardId,Long boardId){
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if(optionalCard.isPresent()){
            if(optionalCard.get().getBoard().getId() == boardId)
                return optionalCard.get();
            throw new BadRequestException("boardId is incorrect");
        }
        throw new BadRequestException("cardId is incorrect");
    }

    private List<User> getUserList(List<Long> userList){
        List<User> list = new ArrayList<>();
        for(Long user:userList){
                list.add(userService.getByUserId(user));
            }
            return list;
        }

    public CreateCardResponse getCard(Long boardId,Long cardId){
        boardService.getBoard(boardId);
        Card card = findCard(cardId);
        return CreateCardResponse.builder().boardId(card.getBoard().getId())
                .cardTitle(card.getCardTitle())
                .description(card.getDescription())
                .userList(card.getMembers())
                .cardId(card.getId())
                .build();
    }

    private Card findCard(Long cardId){
        Optional<Card> card = cardRepository.findById(cardId);
        if(card.isPresent())
            return card.get();
        throw new BadRequestException("card is not available");
    }
}
