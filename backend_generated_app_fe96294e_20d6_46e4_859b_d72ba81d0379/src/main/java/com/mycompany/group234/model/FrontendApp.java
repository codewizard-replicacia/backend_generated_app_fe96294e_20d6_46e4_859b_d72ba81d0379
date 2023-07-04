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

@Entity(name = "FrontendApp")
@Table(name = "\"FrontendApp\"", schema =  "\"generated_app\"")
@Data
                        
public class FrontendApp {
	public FrontendApp () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"AppId\"", nullable = true )
  private Long appId;
	  
  @Embedded
  @Column(name = "\"ProjectDetails\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "appName", column = @Column(name = "\"ProjectDetails_AppName\"")) ,
            	@AttributeOverride(name = "appDescription", column = @Column(name = "\"ProjectDetails_AppDescription\"")) ,
            	@AttributeOverride(name = "namespace", column = @Column(name = "\"ProjectDetails_Namespace\"")) ,
            	@AttributeOverride(name = "packageManagement", column = @Column(name = "\"ProjectDetails_PackageManagement\"")) ,
            	@AttributeOverride(name = "buildTool", column = @Column(name = "\"ProjectDetails_BuildTool\"")) ,
            	@AttributeOverride(name = "server", column = @Column(name = "\"ProjectDetails_Server\"")) ,
            	@AttributeOverride(name = "architecture", column = @Column(name = "\"ProjectDetails_Architecture\""))  }) 
  private BasicDetails projectDetails;
  
	  
	@Column(name = "\"MetaTags\"")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"generated_app\"", name = "\"FrontendAppMetaTags\"",joinColumns = @JoinColumn(name = "\"AppId\""))
    private List<String> metaTags = new ArrayList<>();
	  
  @Column(name = "\"Documentation\"", nullable = true )
  private String documentation;
  
	  
	@Column(name = "\"SelectedScreenIds\"")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"generated_app\"", name = "\"FrontendAppSelectedScreenIds\"",joinColumns = @JoinColumn(name = "\"AppId\""))
    private List<Integer> selectedScreenIds = new ArrayList<>();
  
  
  
		@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppModel\"", referencedColumnName = "\"ModelId\"", insertable = false, updatable = false)
	private ModelFile model;
	
	@Column(name = "\"FrontendAppModel\"")
	private Long frontendAppModel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppMainTechnology\"", referencedColumnName = "\"FeTechId\"", insertable = false, updatable = false)
	private FETechnology mainTechnology;
	
	@Column(name = "\"FrontendAppMainTechnology\"")
	private Integer frontendAppMainTechnology;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppSiteMap\"", referencedColumnName = "\"SiteMapId\"", insertable = false, updatable = false)
	private SiteMap siteMap;
	
	@Column(name = "\"FrontendAppSiteMap\"")
	private Long frontendAppSiteMap;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppTheme\"", referencedColumnName = "\"ThemeId\"", insertable = false, updatable = false)
	private Theme theme;
	
	@Column(name = "\"FrontendAppTheme\"")
	private Integer frontendAppTheme;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppTemplate\"", referencedColumnName = "\"TemplateId\"", insertable = false, updatable = false)
	private UITemplate template;
	
	@Column(name = "\"FrontendAppTemplate\"")
	private Integer frontendAppTemplate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"FrontendAppDependency\"", referencedColumnName = "\"AppId\"", insertable = false, updatable = false)
	private BackendApp dependency;
	
	@Column(name = "\"FrontendAppDependency\"")
	private Long frontendAppDependency;
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"FrontendAppSelectedScreens\"",
            joinColumns = @JoinColumn( name="\"AppId\""),
            inverseJoinColumns = @JoinColumn( name="\"FeScreenId\""), schema = "\"generated_app\"")
private List<FrontendScreen> selectedScreens = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"FrontendAppCapabilities\"",
            joinColumns = @JoinColumn( name="\"AppId\""),
            inverseJoinColumns = @JoinColumn( name="\"CapabilityId\""), schema = "\"generated_app\"")
private List<FECapability> capabilities = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "FrontendApp [" 
  + "AppId= " + appId  + ", " 
  + "ProjectDetails= " + projectDetails  + ", " 
  + "MetaTags= " + metaTags  + ", " 
  + "Documentation= " + documentation  + ", " 
  + "SelectedScreenIds= " + selectedScreenIds 
 + "]";
	}
	
}