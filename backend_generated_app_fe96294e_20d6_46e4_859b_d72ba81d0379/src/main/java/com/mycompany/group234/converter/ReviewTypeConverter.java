package com.mycompany.group234.converter;

import com.mycompany.group234.enums.ReviewType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class ReviewTypeConverter implements AttributeConverter<ReviewType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ReviewType reviewType) {
        return reviewType != null ? reviewType.ordinal() : null;
    }

    @Override
    public ReviewType convertToEntityAttribute(Integer dbData) {
		return ReviewType.getReviewType(dbData);
    }
}
