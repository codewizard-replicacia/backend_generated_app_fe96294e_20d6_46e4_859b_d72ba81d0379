package com.mycompany.group234.converter;

import com.mycompany.group234.enums.ApprovalState;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class ApprovalStateConverter implements AttributeConverter<ApprovalState, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ApprovalState approvalState) {
        return approvalState != null ? approvalState.ordinal() : null;
    }

    @Override
    public ApprovalState convertToEntityAttribute(Integer dbData) {
		return ApprovalState.getApprovalState(dbData);
    }
}
