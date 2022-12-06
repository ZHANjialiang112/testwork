//package com.comment.utils.compare;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.javers.core.Changes;
//import org.javers.core.Javers;
//import org.javers.core.JaversBuilder;
//import org.javers.core.diff.Change;
//import org.javers.core.diff.Diff;
//import org.javers.core.diff.ListCompareAlgorithm;
//import org.javers.core.diff.changetype.PropertyChange;
//import org.javers.core.diff.changetype.ReferenceChange;
//import org.javers.core.diff.changetype.ValueChange;
//import org.javers.core.diff.changetype.container.CollectionChange;
//import org.javers.core.diff.changetype.container.ValueAdded;
//import org.javers.core.diff.changetype.container.ValueRemoved;
//import org.javers.core.metamodel.object.GlobalId;
//import org.javers.core.metamodel.object.ValueObjectId;
//
//
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.*;
//
///**
// * 对比工具
// */
//public class CompareUtil {
//
//    private static DecimalFormat format = new DecimalFormat("0.00");
//
//    public static <T> List<DiffField> compare(T before, T after) {
//        Javers javers = JaversBuilder.javers()
//                .withListCompareAlgorithm(ListCompareAlgorithm.LEVENSHTEIN_DISTANCE)
//                .registerCustomType(Date.class, new CustomDateComparator())
//                .registerCustomType(BigDecimal.class, new CustomBigDecimalComparator())
//                .build();
//        Diff diff = javers.compare(before, after);
//        Changes changes = diff.getChanges();
//        List<DiffField> result = new ArrayList<>();
//        for (Change change : changes) {
//            String propertyNameWithPath = null;
//            String fieldName = null;
//
//            if (change instanceof PropertyChange) {
//                PropertyChange propertyChange = (PropertyChange) change;
//                propertyNameWithPath = propertyChange.getPropertyNameWithPath();
//                Optional<Object> affectedObject = propertyChange.getAffectedObject();
//                if (affectedObject.isPresent()) {
//                    try {
//                        String title = null;
//                        try {
//                            GlobalId globalId = propertyChange.getAffectedGlobalId();
//                            if (Objects.nonNull(globalId) && globalId instanceof ValueObjectId) {
//                                ValueObjectId valueObjectId = (ValueObjectId) globalId;
//                                String fragment = valueObjectId.getFragment();
//                                String typeName = valueObjectId.getOwnerId().getTypeName();
//                                title = Class.forName(typeName).getDeclaredField(fragment).getAnnotation(Schema.class).description();
//                            }
//                        } catch (Exception e) {}
//
//                        Class<?> clas = affectedObject.get().getClass();
//                        Field field = clas.getDeclaredField(propertyChange.getPropertyName());
//                        Schema annotation = field.getAnnotation(Schema.class);
//                        fieldName = Optional.ofNullable(annotation).map(Schema::description).orElse(null);
//                        if (Objects.nonNull(title)) {
//                            fieldName = title+"."+fieldName;
//                        }
//                    } catch (Exception e) {}
//                }
//            }
//            if (change instanceof ValueChange) {
//                ValueChange valuechange = (ValueChange) change;
//                String oldStr = toValue(valuechange.getLeft());//Objects.nonNull(valuechange.getLeft()) ? valuechange.getLeft().toString() : null;
//                String newStr = toValue(valuechange.getRight());//Objects.nonNull(valuechange.getRight()) ? valuechange.getRight().toString() : null;
//                boolean b = StringUtils.isBlank(oldStr) && StringUtils.isBlank(newStr) || Objects.equals(oldStr, newStr);
//                if (!b) {
//                    result.add(DiffField.builder()
//                            .field(valuechange.getPropertyName())
//                            .fieldName(Objects.nonNull(fieldName) ? fieldName : propertyNameWithPath)
//                            .beforeValue(oldStr)
//                            .afterValue(newStr)
//                            .build());
//                }
//            } else if (change instanceof CollectionChange) {
//                CollectionChange collectionChange = (CollectionChange) change;
//                for (ValueAdded valueAdded : collectionChange.getValueAddedChanges()) {
//                    result.add(DiffField.builder()
//                            .field(collectionChange.getPropertyName())
//                            .fieldName(Objects.nonNull(fieldName) ? fieldName : propertyNameWithPath)
//                            .beforeValue(null)
//                            .afterValue(valueAdded.getAddedValue().toString())
//                            .build());
//                }
//                for (ValueRemoved valueRemoved : collectionChange.getValueRemovedChanges()) {
//                    result.add(DiffField.builder()
//                            .field(collectionChange.getPropertyName())
//                            .fieldName(Objects.nonNull(fieldName) ? fieldName : propertyNameWithPath)
//                            .beforeValue(valueRemoved.getRemovedValue().toString())
//                            .afterValue(null)
//                            .build());
//                }
//            } else if (change instanceof ReferenceChange) {
//                ReferenceChange referenceChange = (ReferenceChange) change;
//                String oldStr = Objects.nonNull(referenceChange.getLeft()) ? referenceChange.getLeft().toString() : null;
//                String newStr = Objects.nonNull(referenceChange.getRight()) ? referenceChange.getRight().toString() : null;
//                boolean b = StringUtils.isBlank(oldStr) && StringUtils.isBlank(newStr) || Objects.equals(oldStr, newStr);
//                if (!b) {
//                    result.add(DiffField.builder()
//                            .field(referenceChange.getPropertyName())
//                            .fieldName(Objects.nonNull(fieldName) ? fieldName : propertyNameWithPath)
//                            .beforeValue(oldStr)
//                            .afterValue(newStr)
//                            .build());
//                }
//            }
//        }
//        return result;
//    }
//
//    public static String toValue(Object o) {
//        if (Objects.isNull(o)) return null;
//        if (o instanceof IValueObject) {
//            IValueObject e = (IValueObject) o;
//            return e.getName();
//        } else if (o instanceof BigDecimal) {
//            BigDecimal b = (BigDecimal) o;
//            return format.format(b);
//        } else {
//            return o.toString();
//        }
//    }
//
//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class DiffField {
//        // 字段
//        private String field;
//        // 字段名称
//        private String fieldName;
//        // 原来的值
//        private String beforeValue;
//        // 变更后的值
//        private String afterValue;
//    }
//}
