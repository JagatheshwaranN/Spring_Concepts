package com.automation.SpringConcepts.visa;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.entity.Customer;
import com.automation.SpringConcepts.page.visa.VisaRegistrationPage;
import com.automation.SpringConcepts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;

public class CustomerVisaDataProviderTest extends SpringTestNGTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VisaRegistrationPage visaRegistrationPage;

    @Value("${visa.url}")
    private String url;

    @Test(dataProvider = "getData")
    public void getLimitedCustomerDataRowsTest(Customer customer) {
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

    @DataProvider
    public Object[] getData(ITestContext testContext) {
        return this.customerRepository.findByDobBetween(Date.valueOf(testContext.getCurrentXmlTest().getAllParameters().get("dobFrom")),
                        Date.valueOf(testContext.getCurrentXmlTest().getAllParameters().get("dobTo")))
                .stream()
                .limit(3)
                .toArray();
    }


}
