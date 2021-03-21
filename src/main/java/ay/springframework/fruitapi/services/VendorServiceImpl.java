package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.domain.Vendor;
import ay.springframework.fruitapi.dtos.VendorDto;
import ay.springframework.fruitapi.exceptions.ResourceNotFoundException;
import ay.springframework.fruitapi.mappers.VendorMapper;
import ay.springframework.fruitapi.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 21/03/2021
 */
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorDto getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDto)
                .map(vendorDto -> {
                    vendorDto.setVendorUrl(getVendorUrl(id));
                    return vendorDto;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<VendorDto> getAllVendors() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendor -> {
                    VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);
                    vendorDto.setVendorUrl(getVendorUrl(vendor.getId()));
                    return vendorDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDto createNewVendor(VendorDto vendorDto) {
        return saveAndReturnDto(vendorMapper.vendorDtoToVendor(vendorDto));
    }

    @Override
    public VendorDto updateVendor(Long id, VendorDto vendorDto) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDto);
        vendor.setId(id);

        return saveAndReturnDto(vendor);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        vendorRepository.deleteById(id);
    }

    private String getVendorUrl(Long id) {
        return "api/v1/vendors" + id;
    }

    private VendorDto saveAndReturnDto(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDto vendorDto = vendorMapper.vendorToVendorDto(savedVendor);
        vendorDto.setVendorUrl(getVendorUrl(savedVendor.getId()));

        return vendorDto;
    }
}
