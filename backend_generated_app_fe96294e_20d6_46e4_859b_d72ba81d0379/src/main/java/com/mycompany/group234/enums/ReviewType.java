package com.mycompany.group234.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum ReviewType{
	    GeneralReview,
	    VersionReview,
	    ReleaseReview,
	    MinorReview; 
    public int value(ReviewType reviewType) {
        return reviewType.ordinal();
    }
    public static ReviewType getReviewType(int ordinal) {
        for(ReviewType reviewType : ReviewType.values())
                if(reviewType.ordinal() == ordinal)
                        return reviewType;
        return null;
    }
}


