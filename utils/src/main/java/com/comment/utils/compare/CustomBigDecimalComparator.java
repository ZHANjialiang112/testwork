package com.comment.utils.compare;

import org.javers.core.diff.changetype.PropertyChangeMetadata;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.diff.custom.CustomPropertyComparator;
import org.javers.core.metamodel.property.Property;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class CustomBigDecimalComparator implements CustomPropertyComparator<BigDecimal, ValueChange> {


    @Override
    public Optional<ValueChange> compare(BigDecimal d1, BigDecimal d2, PropertyChangeMetadata propertyChangeMetadata, Property property) {
        boolean b1 = (Objects.isNull(d1) && Objects.isNull(d2));
        if (b1) {
            return Optional.empty();
        }

        boolean b = Objects.isNull(d1) || Objects.isNull(d2);
        if (b) {
            return Optional.of(new ValueChange(propertyChangeMetadata, d1, d2));
        }
        boolean b2 = (d1.subtract(d2)).compareTo(BigDecimal.ZERO) == 0;
        if (b2) {
            return Optional.empty();
        }
        return Optional.of(new ValueChange(propertyChangeMetadata, d1, d2));
    }

    @Override
    public boolean equals(BigDecimal d1, BigDecimal d2) {
        boolean b1 = (Objects.isNull(d1) && Objects.isNull(d2));
        if (b1) {
            return true;
        }
        boolean b = Objects.isNull(d1) || Objects.isNull(d2);
        if (b) {
            return false;
        }

        return (d1.subtract(d2)).compareTo(BigDecimal.ZERO) == 0;
    }

    @Override
    public String toString(BigDecimal decimal) {
        return Objects.nonNull(decimal) ? decimal.toString() : null;
    }
}