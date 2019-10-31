package fjpc.mvcdemo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRespository extends MongoRepository<Customer, String> {
}
