//package com.comment.utils.compare;
//
//import org.apache.commons.lang3.time.DateUtils;
//import org.javers.core.diff.changetype.PropertyChangeMetadata;
//import org.javers.core.diff.changetype.ValueChange;
//import org.javers.core.diff.custom.CustomPropertyComparator;
//import org.javers.core.metamodel.property.Property;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.Date;
//import java.util.Objects;
//import java.util.Optional;
//
//public class CustomDateComparator implements CustomPropertyComparator<Date, ValueChange> {
//
//
//    @Override
//    public Optional<ValueChange> compare(Date d1, Date d2, PropertyChangeMetadata propertyChangeMetadata, Property property) {
//        if (equals(d1, d2)) {
//            return Optional.empty();
//        }
//        return Optional.of(new ValueChange(propertyChangeMetadata, DateUtils.formatHasSeparatorDate(d1), DateUtils.formatHasSeparatorDate(d2)));
//    }
//
//    @Override
//    public boolean equals(Date d1, Date d2) {
//        LocalDate localDate1 = null;
//        LocalDate localDate2 = null;
//        if (Objects.nonNull(d1)) {
//            localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
//        }
//        if (Objects.nonNull(d2)) {
//            localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
//        }
//        return Objects.equals(localDate1, localDate2);
//    }
//
//    @Override
//    public String toString(Date date) {
//        return DateUtils.formatHasSeparatorDate(date);
//    }
//}