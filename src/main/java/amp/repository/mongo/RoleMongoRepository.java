package amp.repository.mongo;

import amp.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMongoRepository extends MongoRepository<Role,Long> {

}
