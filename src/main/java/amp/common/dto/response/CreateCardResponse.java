package amp.common.dto.response;

import amp.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCardResponse {
    private String cardTitle;
    private String description;
    private Long boardId;
    private Long cardId;
    private List<User> userList;
}
