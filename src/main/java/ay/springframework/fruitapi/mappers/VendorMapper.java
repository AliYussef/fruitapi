package ay.springframework.fruitapi.mappers;

import ay.springframework.fruitapi.domain.Vendor;
import ay.springframework.fruitapi.dtos.VendorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * Created by aliyussef on 21/03/2021
 */
@Mapper
@Component
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDto vendorToVendorDto(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDto vendorDto);
}
