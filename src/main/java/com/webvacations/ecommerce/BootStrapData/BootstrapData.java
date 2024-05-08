package com.webvacations.ecommerce.BootStrapData;

import com.webvacations.ecommerce.dao.CustomerRepository;
import com.webvacations.ecommerce.dao.DivisionRepository;
import com.webvacations.ecommerce.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

    @Component
    public class BootstrapData implements CommandLineRunner {
        // dependency injection
        private final CustomerRepository customerRepository;

        public BootstrapData(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
            //this.divisionRepository = divisionRepository;
        }
        @Override
        public void run(String... args) throws Exception {

            //Generate 5 sample customers
            /*
            **Format**
            First name
            Last name
            Postal code
            Phone number
            Division
             */

            Customer person1 = new Customer(
                    "Eric",
                    "Ericson",
                    "111 1st street",
                    "99999",
                    "999-999-9999",
                    4L);
            customerRepository.save(person1);

            Customer person2 = new Customer(
                    "Mark",
                    "Markson",
                    "222 2nd street",
                    "77777",
                    "888-888-8888",
                    4L);
            customerRepository.save(person2);

            Customer person3 = new Customer(
                    "Fred",
                    "Fredson",
                    "333 3rd street",
                    "66666",
                    "777-777-7777",
                    4L);
            customerRepository.save(person3);

            Customer person4 = new Customer(
                    "Mike",
                    "Mikeson",
                    "444 4th street",
                    "55555",
                    "666-666-6666",
                    4L);
            customerRepository.save(person4);

            Customer person5 = new Customer(
                    "Ace",
                    "Aceson",
                    "444 4th street",
                    "44444",
                    "555-555-5555",
                    4L);
            customerRepository.save(person5);
        }
    }
        //c1st.setCreate_date(new Date());
        //c1st.setLast_date(new Date());