package uk.gov.hmcts.cmc.domain.models.party;

import uk.gov.hmcts.cmc.domain.models.Address;
import uk.gov.hmcts.cmc.domain.models.CollectionId;
import uk.gov.hmcts.cmc.domain.models.Representative;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class and its subtypes represent the data that a person provides about themselves.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = Individual.class, name = "individual"),
        @JsonSubTypes.Type(value = SoleTrader.class, name = "soleTrader"),
        @JsonSubTypes.Type(value = Company.class, name = "company"),
        @JsonSubTypes.Type(value = Organisation.class, name = "organisation")
    }
)
@EqualsAndHashCode(callSuper = true)
public abstract class Party extends CollectionId implements NamedParty {

    @NotBlank
    @Size(max = 255, message = "may not be longer than {max} characters")
    private final String name;

    @Valid
    @NotNull
    private final Address address;

    @Valid
    private final Address correspondenceAddress;

    @Size(max = 30, message = "may not be longer than {max} characters")
    private final String mobilePhone;

    @Valid
    private final Representative representative;

    public Party(
        String id,
        String name,
        Address address,
        Address correspondenceAddress,
        String mobilePhone,
        Representative representative
    ) {
        super(id);
        this.name = name;
        this.address = address;
        this.correspondenceAddress = correspondenceAddress;
        this.mobilePhone = mobilePhone;
        this.representative = representative;
    }

    @Override
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Optional<Address> getCorrespondenceAddress() {
        return Optional.ofNullable(correspondenceAddress);
    }

    public Optional<String> getMobilePhone() {
        return Optional.ofNullable(mobilePhone);
    }

    public Optional<Representative> getRepresentative() {
        return Optional.ofNullable(representative);
    }

}
