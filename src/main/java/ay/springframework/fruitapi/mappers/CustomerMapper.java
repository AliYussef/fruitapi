package ay.springframework.fruitapi.mappers;

import ay.springframework.fruitapi.domain.Customer;
import ay.springframework.fruitapi.dtos.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * Created by aliyussef on 21/03/2021
 */
@Component
@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDto(Customer customer);
}
