package amp.repository.mongo;

import amp.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMongoRepository extends MongoRepository<Board,Long> {

}
