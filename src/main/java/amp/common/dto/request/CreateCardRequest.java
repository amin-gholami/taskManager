package amp.common.dto.request;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateCardRequest {
    private String cardTitle;
    private String description;
    private List<Long> members;
}
