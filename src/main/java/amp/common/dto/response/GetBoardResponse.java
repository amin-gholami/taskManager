package amp.common.dto.response;

import amp.model.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class GetBoardResponse {
    private String boardName;
    private String creatorId;
    private String createdAt;
    private List<Card> cardList;
}
