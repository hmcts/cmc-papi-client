package uk.gov.hmcts.cmc.domain.models;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.builders.SampleAddress;
import uk.gov.hmcts.cmc.domain.models.common.Address;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class AddressTest {

    @Test
    public void shouldBeSuccessfulValidationForCorrectAddress() {
        //given
        Address address = SampleAddress.validDefaults();
        //when
        Set<String> response = validate(address);
        //then
        assertThat(response).hasSize(0);
    }

    @Test
    public void shouldBeInvalidForNullLineOne() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setLine1(null);

        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("line1 : Address Line1 should not be empty");
    }

    @Test
    public void shouldBeInvalidForEmptyLineOne() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setLine1("");
        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("line1 : Address Line1 should not be empty");
    }

    @Test
    public void shouldBeInvalidForEmptyCity() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setCity("");
        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("city : City/town should not be empty");
    }

    @Test
    public void shouldBeInvalidForNullPostcode() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setPostcode(null);

        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("postcode : must not be null");
    }

    @Test
    public void shouldBeInvalidForEmptyPostcode() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setPostcode("");
        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("postcode : Postcode is not of valid format");
    }

    @Test
    public void shouldBeInvalidForInvalidPostcode() {
        //given
        Address address = SampleAddress.validDefaults();
        address.setPostcode("SW123456");

        //when
        Set<String> errors = validate(address);
        //then
        assertThat(errors)
            .hasSize(1)
            .contains("postcode : Postcode is not of valid format");
    }

}
