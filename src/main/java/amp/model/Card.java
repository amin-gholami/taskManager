package amp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Long id;

    @Column(name ="card_title")
    private String cardTitle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @JoinColumn(name = "card_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> members;
}
