package fjpc.mvcdemo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRespository extends ReactiveMongoRepository<Customer, String> {
}
