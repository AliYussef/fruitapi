package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.domain.Customer;
import ay.springframework.fruitapi.dtos.CustomerDto;
import ay.springframework.fruitapi.exceptions.ResourceNotFoundException;
import ay.springframework.fruitapi.mappers.CustomerMapper;
import ay.springframework.fruitapi.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 21/03/2021
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);
                    customerDto.setCustomerUrl("api/v1/customers/" + customer.getId());
                    return customerDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerMapper.customerToCustomerDto(customerRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        return saveAndReturnCustomerDto(customerMapper.customerDtoToCustomer(customerDto));
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer.setId(id);

        return saveAndReturnCustomerDto(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.customerToCustomerDto(customerRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new));

        customerRepository.deleteById(id);
    }

    private CustomerDto saveAndReturnCustomerDto(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto mappedCustomer = customerMapper.customerToCustomerDto(savedCustomer);
        mappedCustomer.setCustomerUrl("api/v1/customers/" + savedCustomer.getId());

        return mappedCustomer;
    }
}
