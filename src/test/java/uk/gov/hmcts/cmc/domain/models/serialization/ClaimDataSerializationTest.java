package uk.gov.hmcts.cmc.domain.models.serialization;

import uk.gov.hmcts.cmc.domain.builders.SampleClaimData;
import uk.gov.hmcts.cmc.domain.builders.SampleInterestDate;
import uk.gov.hmcts.cmc.domain.builders.SampleParty;
import uk.gov.hmcts.cmc.domain.builders.SampleTheirDetails;
import uk.gov.hmcts.cmc.domain.config.JacksonConfiguration;
import uk.gov.hmcts.cmc.domain.models.ClaimData;
import uk.gov.hmcts.cmc.domain.utils.ResourceReader;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.builders.SampleInterest.standardInterestBuilder;

public class ClaimDataSerializationTest {

    @Test
    public void shouldConvertJsonToJava() throws IOException {
        //given
        String input = new ResourceReader().read("/claim-application.json");
        ObjectMapper mapper = new JacksonConfiguration().objectMapper();

        //when
        ClaimData claimData = mapper.readValue(input, ClaimData.class);

        //then
        ClaimData other = SampleClaimData.builder()
            .withExternalId(UUID.fromString("9f49d8df-b734-4e86-aeb6-e22f0c2ca78d"))
            .withInterest(
                standardInterestBuilder()
                    .withInterestDate(
                        SampleInterestDate.builder()
                            .withDate(LocalDate.of(2015, 2, 2))
                            .build())
                    .build())
            .withExternalReferenceNumber(null)
            .withPreferredCourt(null)
            .withFeeAccountNumber(null)
            .withHousingDisrepair(null)
            .withPersonalInjury(null)
            .withStatementOfTruth(null)
            .clearClaimants()
            .addClaimant(SampleParty.builder().withRepresentative(null).individual())
            .withDefendant(SampleTheirDetails.builder()
                .withRepresentative(null)
                .withServiceAddress(null)
                .withDateOfBirth(null)
                .individualDetails())
            .build();

        assertThat(claimData).isEqualTo(other);
    }
}