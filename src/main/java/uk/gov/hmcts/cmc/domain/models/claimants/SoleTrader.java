package uk.gov.hmcts.cmc.domain.models.claimants;

import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;

import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class SoleTrader extends Party implements TitledParty {

    @Size(max = 35, message = "must be at most {max} characters")
    private final String title;

    private final String businessName;

    @Builder
    public SoleTrader(
        String id,
        String name,
        Address address,
        Address correspondenceAddress,
        String mobilePhone,
        Representative representative,
        String title,
        String businessName
    ) {
        super(id, name, address, correspondenceAddress, mobilePhone, representative);
        this.title = title;
        this.businessName = businessName;
    }

    @Override
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Optional<String> getBusinessName() {
        return Optional.ofNullable(businessName);
    }

}