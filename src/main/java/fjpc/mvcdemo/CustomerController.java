package fjpc.mvcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRespository customerRespository;

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerRespository.findAll();
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer customer) {
        return customerRespository.save(customer);
    }

}
