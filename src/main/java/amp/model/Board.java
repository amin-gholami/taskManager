package amp.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "board_Name")
    private String boardName;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name ="modified_on")
    private Timestamp modifiedOn;

    @OneToMany
    private List<Card> cardList;

    @OneToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creatorId;
}
