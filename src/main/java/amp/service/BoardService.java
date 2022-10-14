package amp.service;

import amp.common.Global;
import amp.common.dto.request.CreateBoardRequest;
import amp.common.dto.response.CreateBoardResponse;
import amp.common.dto.response.GetBoardResponse;
import amp.model.Board;
import amp.repository.BoardRepository;
import amp.repository.mongo.BoardMongoRepository;
import org.springframework.stereotype.Service;
import amp.common.exceptions.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final Global global;
    private final UserService userService;

    public BoardService(BoardRepository boardRepository, Global global, UserService userService) {
        this.boardRepository = boardRepository;
        this.global = global;
        this.userService = userService;
    }

    public CreateBoardResponse createBoard(CreateBoardRequest boardRequest){
        Date date = new Date();
        Board board = boardRepository.save(Board.builder().boardName(boardRequest.getBoardName())
                .creatorId(userService.getUserByUsername(global.getUsername()))
                .createdOn(new Timestamp(date.getTime())).build());
        return CreateBoardResponse.builder().boardId(board.getId().toString())
                .boardName(board.getBoardName()).build();
    }

    public CreateBoardResponse editBoard(CreateBoardRequest boardRequest,Long id){
        Date date = new Date();
        Board board = getBoard(id);
        return CreateBoardResponse.builder().boardId(board.getId().toString())
                .boardName(board.getBoardName()).build();
    }

    public void deleteBoard(Long id){
        if(!boardRepository.existsById(id))
            throw new BadRequestException("could not find board by id");
        boardRepository.deleteById(id);
    }

    public GetBoardResponse getBoardResponse(Long id){
        if(!boardRepository.existsById(id))
            throw new BadRequestException("could not find board by id");
        Board board = boardRepository.findById(id).get();
        return GetBoardResponse.builder().boardName(board.getBoardName())
                .cardList(board.getCardList())
                .createdAt(board.getCreatedOn().toString())
                .creatorId(board.getCreatorId().getUsername()).build();
    }

    public Board getBoard(Long id){
        Optional<Board> board =  boardRepository.findById(id);
        if(board.isPresent())
            return board.get();
        throw new BadRequestException("board is not available");
    }
}
