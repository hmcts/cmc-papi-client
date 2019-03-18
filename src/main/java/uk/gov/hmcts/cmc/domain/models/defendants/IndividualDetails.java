package uk.gov.hmcts.cmc.domain.models.defendants;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import java.time.LocalDate;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
public class IndividualDetails extends TheirDetails {

    private final LocalDate dateOfBirth;

    @Builder
    public IndividualDetails(
        String id,
        String name,
        Address address,
        String email,
        Representative representative,
        Address serviceAddress,
        LocalDate dateOfBirth
    ) {
        super(id, name, address, email, representative, serviceAddress);
        this.dateOfBirth = dateOfBirth;
    }

    public Optional<LocalDate> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

}
