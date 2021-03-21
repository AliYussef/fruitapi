package ay.springframework.fruitapi.bootstrap;

import ay.springframework.fruitapi.domain.Category;
import ay.springframework.fruitapi.domain.Customer;
import ay.springframework.fruitapi.repositories.CategoryRepository;
import ay.springframework.fruitapi.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by aliyussef on 21/03/2021
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        categoryRepository.save(fruits);

        Category dried = new Category();
        dried.setName("Fruits");
        categoryRepository.save(dried);

        Category fresh = new Category();
        fresh.setName("Fruits");
        categoryRepository.save(fresh);

        Category exotic = new Category();
        exotic.setName("Fruits");
        categoryRepository.save(exotic);

        Category nuts = new Category();
        nuts.setName("Fruits");
        categoryRepository.save(nuts);

        System.out.println("Categories Loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Michael");
        customer1.setLastName("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");
        customerRepository.save(customer2);

        System.out.println("Customers Loaded = " + customerRepository.count());
    }
}
