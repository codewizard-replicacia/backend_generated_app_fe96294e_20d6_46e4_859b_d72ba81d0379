package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.mycompany.group234.model.Document;
import com.mycompany.group234.model.BackendTemplate;
import com.mycompany.group234.model.BECapability;
import com.mycompany.group234.model.Architecture;
import com.mycompany.group234.model.Capability;
import com.mycompany.group234.model.Server;
import com.mycompany.group234.model.ScreenFlow;
import com.mycompany.group234.model.FETechnology;
import com.mycompany.group234.model.ScreenFeature;
import com.mycompany.group234.model.FrontendScreen;
import com.mycompany.group234.model.BackendApp;
import com.mycompany.group234.model.ReviewRequest;
import com.mycompany.group234.model.Project;
import com.mycompany.group234.model.ModelFile;
import com.mycompany.group234.model.Theme;
import com.mycompany.group234.model.Setting;
import com.mycompany.group234.model.BETechnology;
import com.mycompany.group234.model.UITemplate;
import com.mycompany.group234.model.Generator;
import com.mycompany.group234.model.FECapability;
import com.mycompany.group234.model.Industry;
import com.mycompany.group234.model.User;
import com.mycompany.group234.model.SiteMap;
import com.mycompany.group234.model.GitHubCreds;
import com.mycompany.group234.model.BuildTool;
import com.mycompany.group234.model.Database;
import com.mycompany.group234.model.FrontendApp;
import com.mycompany.group234.model.PackageManagement;
import com.mycompany.group234.model.complex.BasicDetails;
import com.mycompany.group234.model.complex.AdvancedDetails;
import com.mycompany.group234.enums.ReviewType;
import com.mycompany.group234.enums.IndustryType;
import com.mycompany.group234.enums.ApprovalState;
import com.mycompany.group234.enums.ModelType;
import com.mycompany.group234.enums.ModelCreator;
import com.mycompany.group234.converter.IndustryTypeConverter;
import com.mycompany.group234.converter.ModelTypeConverter;
import com.mycompany.group234.converter.ApprovalStateConverter;
import com.mycompany.group234.converter.ReviewTypeConverter;
import com.mycompany.group234.converter.ModelCreatorConverter;
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "BackendTemplate")
@Table(name = "\"BackendTemplate\"", schema =  "\"generated_app\"")
@Data
                        
public class BackendTemplate {
	public BackendTemplate () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"TemplateId\"", nullable = true )
  private Integer templateId;
	  
  @Column(name = "\"TemplateName\"", nullable = true )
  private String templateName;
  
	  
  @Column(name = "\"TemplateDescription\"", nullable = true )
  private String templateDescription;
  
	  
  @Column(name = "\"RepoURL\"", nullable = true )
  private String repoURL;
  
	  
  @Column(name = "\"RepoName\"", nullable = true )
  private String repoName;
  
	  
  @Column(name = "\"TemplatePath\"", nullable = true )
  private String templatePath;
  
	  
  @Column(name = "\"GitHubURL\"", nullable = true )
  private String gitHubURL;
  
  
  
  
		@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendTemplateMainTechnology\"", referencedColumnName = "\"BeTechId\"", insertable = false, updatable = false)
	private BETechnology mainTechnology;
	
	@Column(name = "\"BackendTemplateMainTechnology\"")
	private Integer backendTemplateMainTechnology;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendTemplateSupported_Database\"", referencedColumnName = "\"DbId\"", insertable = false, updatable = false)
	private Database supported_Database;
	
	@Column(name = "\"BackendTemplateSupported_Database\"")
	private Integer backendTemplateSupported_Database;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendTemplateGenerator\"", referencedColumnName = "\"GenId\"", insertable = false, updatable = false)
	private Generator generator;
	
	@Column(name = "\"BackendTemplateGenerator\"")
	private Integer backendTemplateGenerator;
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"BackendTemplateSupported_Capabilities\"",
            joinColumns = @JoinColumn( name="\"TemplateId\""),
            inverseJoinColumns = @JoinColumn( name="\"CapabilityId\""), schema = "\"generated_app\"")
private List<Capability> supported_Capabilities = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "BackendTemplate [" 
  + "TemplateId= " + templateId  + ", " 
  + "TemplateName= " + templateName  + ", " 
  + "TemplateDescription= " + templateDescription  + ", " 
  + "RepoURL= " + repoURL  + ", " 
  + "RepoName= " + repoName  + ", " 
  + "TemplatePath= " + templatePath  + ", " 
  + "GitHubURL= " + gitHubURL 
 + "]";
	}
	
}