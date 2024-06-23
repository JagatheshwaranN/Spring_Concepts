package com.automation.SpringConcepts.visa;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.entity.Customer;
import com.automation.SpringConcepts.page.visa.VisaRegistrationPage;
import com.automation.SpringConcepts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerVisaTest extends SpringTestNGTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VisaRegistrationPage visaRegistrationPage;

    @Value("${visa.url}")
    private String url;

    @Test
    public void getCustomerVisaDataSetCountTest() {
        System.out.println(this.customerRepository.findAll().size());
    }

    @Test
    public void getCustomerBasedOnIdTest() {
        this.customerRepository
                .findById(85)
                .ifPresent(customer ->
                        System.out.println(customer.getFirstName()));
    }

    @Test
    public void getLimitedCustomerDataRowsTest() {

        List<Customer> customerList = this.customerRepository.findAll()
                .stream()
                .limit(3)
                .toList();

        for (Customer customer : customerList) {
            this.visaRegistrationPage.launch(url);
            this.visaRegistrationPage.isAt();
            this.visaRegistrationPage.fillName(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.selectCountries(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.fillBirthDate(customer.getDob().toLocalDate());
            this.visaRegistrationPage.fillContactDetails(customer.getCustomerEmail(), customer.getPhone());
            this.visaRegistrationPage.fillComments(customer.getComments());
            this.visaRegistrationPage.submitForm();
            System.out.println(this.visaRegistrationPage.getConfirmationNumber());
        }
        this.visaRegistrationPage.close();
    }

    @Test
    public void getCustomerWithFirstNameTest() {

        List<Customer> customerList = this.customerRepository.findByFirstNameStartingWith("Mi")
                .stream()
                .limit(3)
                .toList();

        for (Customer customer : customerList) {
            this.visaRegistrationPage.launch(url);
            this.visaRegistrationPage.isAt();
            this.visaRegistrationPage.fillName(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.selectCountries(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.fillBirthDate(customer.getDob().toLocalDate());
            this.visaRegistrationPage.fillContactDetails(customer.getCustomerEmail(), customer.getPhone());
            this.visaRegistrationPage.fillComments(customer.getComments());
            this.visaRegistrationPage.submitForm();
            System.out.println(this.visaRegistrationPage.getConfirmationNumber());
        }
        this.visaRegistrationPage.close();
    }

    @Test
    public void getCustomerByDOBRangeTest() {

        List<Customer> customerList = this.customerRepository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .toList();

        for (Customer customer : customerList) {
            this.visaRegistrationPage.launch(url);
            this.visaRegistrationPage.isAt();
            this.visaRegistrationPage.fillName(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.selectCountries(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.fillBirthDate(customer.getDob().toLocalDate());
            this.visaRegistrationPage.fillContactDetails(customer.getCustomerEmail(), customer.getPhone());
            this.visaRegistrationPage.fillComments(customer.getComments());
            this.visaRegistrationPage.submitForm();
            System.out.println(this.visaRegistrationPage.getConfirmationNumber());
        }
        this.visaRegistrationPage.close();
    }

    @Test
    public void deleteCustomerBasedOnIdTest() {
        this.customerRepository
                .deleteById(85);
        System.out.println("Customer Deleted");
        System.out.println("Customer With ID 85 is present? : " + this.customerRepository
                .findById(85)
                .isPresent());
    }

    // Not sure whether its working.
    @Test
    public void UpdateCustomerBasedOnIdTest() {
        Optional<Customer> customer = this.customerRepository
                .findById(2);
        customer.ifPresent(cust -> cust.setComments("Tourist Visa"));
        System.out.println("Customer Detail Updated");
    }

    @Test
    public void AddNewCustomerTest() {
        Customer customer = new Customer();
        customer.setId(101);
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setFromCountry("USA");
        customer.setToCountry("Australia");
        customer.setDob(Date.valueOf("1998-01-01"));
        customer.setCustomerEmail("john@gmail.com");
        customer.setPhone("1234567890");
        this.customerRepository.save(customer);
        System.out.println("Customer Detail Added");
        this.customerRepository
                .findById(101)
                .ifPresent(cust ->
                        System.out.println(cust.getFirstName()));
    }

}
