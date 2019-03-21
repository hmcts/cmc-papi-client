package uk.gov.hmcts.cmc.domain.models;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.builders.SampleParty;
import uk.gov.hmcts.cmc.domain.models.claimants.SoleTrader;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class SoleTraderTest {

    @Test
    public void shouldBeValidWhenBusinessNameIsNull() {
        SoleTrader soleTrader = SampleParty.soleTrader();
        soleTrader.setBusinessName(null);

        Set<String> validationErrors = validate(soleTrader);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void shouldBeValidWhenBusinessNameIsEmpty() {
        SoleTrader soleTrader = SampleParty.soleTrader();
        soleTrader.setBusinessName("");

        Set<String> validationErrors = validate(soleTrader);

        assertThat(validationErrors).isEmpty();
    }

}
