package fjpc.mvcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRespository customerRespository;

    @GetMapping
    public Flux<Customer> findAllCustomers() {
        return customerRespository.findAll();
    }

    @PostMapping
    public Mono<Customer> newCustomer(@RequestBody Customer customer) {
        return customerRespository.insert(customer);
    }

}
