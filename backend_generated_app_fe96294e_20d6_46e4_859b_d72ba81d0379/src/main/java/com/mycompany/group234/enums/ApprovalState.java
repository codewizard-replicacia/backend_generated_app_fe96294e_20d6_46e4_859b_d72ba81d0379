package com.mycompany.group234.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum ApprovalState{
	    Pending,
	    ChangesRequested,
	    Approved,
	    InProgress,
	    Rejected; 
    public int value(ApprovalState approvalState) {
        return approvalState.ordinal();
    }
    public static ApprovalState getApprovalState(int ordinal) {
        for(ApprovalState approvalState : ApprovalState.values())
                if(approvalState.ordinal() == ordinal)
                        return approvalState;
        return null;
    }
}


