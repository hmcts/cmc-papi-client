package uk.gov.hmcts.cmc.domain.models.amount;

import uk.gov.hmcts.cmc.domain.models.AmountRow;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@EqualsAndHashCode
public class AmountBreakDown implements Amount {

    @Valid
    @NotNull
    @Size(max = 1000)
    private final List<AmountRow> rows;

    public AmountBreakDown(@JsonProperty("rows") List<AmountRow> rows) {
        this.rows = rows;
    }

    @JsonIgnore
    public BigDecimal getTotalAmount() {
        return rows.stream()
            .map(AmountRow::getAmount)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<AmountRow> getRows() {
        return rows;
    }

}
