package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.dtos.CustomerDto;

import java.util.List;

/**
 * Created by aliyussef on 21/03/2021
 */
public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto createNewCustomer(CustomerDto customerDto);
}
