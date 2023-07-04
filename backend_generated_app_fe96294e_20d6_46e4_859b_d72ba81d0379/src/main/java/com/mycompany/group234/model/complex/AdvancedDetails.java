package com.mycompany.group234.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class AdvancedDetails {
  
	
  @Column(name = "\"CorsStatus\"", nullable = true)
  private Boolean corsStatus;
}
