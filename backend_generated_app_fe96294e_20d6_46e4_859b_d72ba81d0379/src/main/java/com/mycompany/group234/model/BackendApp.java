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

@Entity(name = "BackendApp")
@Table(name = "\"BackendApp\"", schema =  "\"generated_app\"")
@Data
                        
public class BackendApp {
	public BackendApp () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"AppId\"", nullable = true )
  private Long appId;
	  
  @Embedded
  @Column(name = "\"AppDetails\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "appName", column = @Column(name = "\"AppDetails_AppName\"")) ,
            	@AttributeOverride(name = "appDescription", column = @Column(name = "\"AppDetails_AppDescription\"")) ,
            	@AttributeOverride(name = "namespace", column = @Column(name = "\"AppDetails_Namespace\"")) ,
            	@AttributeOverride(name = "packageManagement", column = @Column(name = "\"AppDetails_PackageManagement\"")) ,
            	@AttributeOverride(name = "buildTool", column = @Column(name = "\"AppDetails_BuildTool\"")) ,
            	@AttributeOverride(name = "server", column = @Column(name = "\"AppDetails_Server\"")) ,
            	@AttributeOverride(name = "architecture", column = @Column(name = "\"AppDetails_Architecture\""))  }) 
  private BasicDetails appDetails;
  
	  
  @Column(name = "\"DbSchemaName\"", nullable = true )
  private String dbSchemaName;
  
	  
  @Embedded
  @Column(name = "\"Advanced\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "corsStatus", column = @Column(name = "\"Advanced_CorsStatus\""))  }) 
  private AdvancedDetails advanced;
  
  
  
  
		@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppModel\"", referencedColumnName = "\"ModelId\"", insertable = false, updatable = false)
	private ModelFile model;
	
	@Column(name = "\"BackendAppModel\"")
	private Long backendAppModel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppDatabase\"", referencedColumnName = "\"DbId\"", insertable = false, updatable = false)
	private Database database;
	
	@Column(name = "\"BackendAppDatabase\"")
	private Integer backendAppDatabase;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppMainTechnology\"", referencedColumnName = "\"BeTechId\"", insertable = false, updatable = false)
	private BETechnology mainTechnology;
	
	@Column(name = "\"BackendAppMainTechnology\"")
	private Integer backendAppMainTechnology;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppTemplate\"", referencedColumnName = "\"TemplateId\"", insertable = false, updatable = false)
	private BackendTemplate template;
	
	@Column(name = "\"BackendAppTemplate\"")
	private Integer backendAppTemplate;
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"BackendAppCapabilities\"",
            joinColumns = @JoinColumn( name="\"AppId\""),
            inverseJoinColumns = @JoinColumn( name="\"CapabilityId\""), schema = "\"generated_app\"")
private List<BECapability> capabilities = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "BackendApp [" 
  + "AppId= " + appId  + ", " 
  + "AppDetails= " + appDetails  + ", " 
  + "DbSchemaName= " + dbSchemaName  + ", " 
  + "Advanced= " + advanced 
 + "]";
	}
	
}