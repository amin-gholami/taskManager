package amp.common.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateBoardResponse {
    private String boardName;
    private String boardId;
}
