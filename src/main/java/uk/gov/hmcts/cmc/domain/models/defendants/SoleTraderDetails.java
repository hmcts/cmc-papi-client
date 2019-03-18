package uk.gov.hmcts.cmc.domain.models.defendants;

import uk.gov.hmcts.cmc.domain.models.claimants.TitledParty;
import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.Optional;

import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
public class SoleTraderDetails extends TheirDetails implements TitledParty {

    @Size(max = 35, message = "must be at most {max} characters")
    private final String title;

    @Size(max = 35, message = "may not be longer than {max} characters")
    private final String businessName;

    @Builder
    public SoleTraderDetails(
        String id,
        String name,
        Address address,
        String email,
        Representative representative,
        Address serviceAddress,
        String title,
        String businessName
    ) {
        super(id, name, address, email, representative, serviceAddress);
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