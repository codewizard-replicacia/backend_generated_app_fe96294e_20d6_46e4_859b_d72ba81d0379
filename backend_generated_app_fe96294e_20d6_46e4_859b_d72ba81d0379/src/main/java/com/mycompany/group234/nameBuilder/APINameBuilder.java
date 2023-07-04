package com.mycompany.group234.nameBuilder;


import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAEdmNameBuilder;
import com.sap.olingo.jpa.metadata.core.edm.mapper.impl.JPADefaultEdmNameBuilder;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class APINameBuilder implements JPAEdmNameBuilder {
    private final JPAEdmNameBuilder defaultNameBuilder;

    public APINameBuilder(final String punit) {
        defaultNameBuilder = new JPADefaultEdmNameBuilder(punit);
    }

    @Override
    public String buildComplexTypeName(final EmbeddableType<?> jpaEmbeddedType) {
        return defaultNameBuilder.buildComplexTypeName(jpaEmbeddedType);
    }

    @Override
    public String buildContainerName() {
        return defaultNameBuilder.buildContainerName();
    }

    @Override
	public String buildEntitySetName(final String entityTypeName) {
    	String eSetName = null;
    	
    	eSetName = "PackageManagement".equals(entityTypeName) ? "PackageManagements" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "User".equals(entityTypeName) ? "Users" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Server".equals(entityTypeName) ? "Servers" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "BETechnology".equals(entityTypeName) ? "BETechnologies" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Document".equals(entityTypeName) ? "Documents" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "BackendApp".equals(entityTypeName) ? "BackendApps" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Industry".equals(entityTypeName) ? "Industries" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ScreenFeature".equals(entityTypeName) ? "ScreenFeatures" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "UITemplate".equals(entityTypeName) ? "UITemplates" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "SiteMap".equals(entityTypeName) ? "SiteMaps" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Database".equals(entityTypeName) ? "Databases" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "FETechnology".equals(entityTypeName) ? "FETechnologies" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "FrontendApp".equals(entityTypeName) ? "FrontendApps" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Architecture".equals(entityTypeName) ? "Architectures" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Capability".equals(entityTypeName) ? "Capabilities" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "FECapability".equals(entityTypeName) ? "FECapabilities" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Setting".equals(entityTypeName) ? "Settings" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "BackendTemplate".equals(entityTypeName) ? "BackendTemplates" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ScreenFlow".equals(entityTypeName) ? "ScreenFlows" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Project".equals(entityTypeName) ? "Projects" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "FrontendScreen".equals(entityTypeName) ? "FrontendScreens" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ModelFile".equals(entityTypeName) ? "ModelFiles" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "BuildTool".equals(entityTypeName) ? "BuildTools" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "BECapability".equals(entityTypeName) ? "BECapabilities" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Theme".equals(entityTypeName) ? "Themes" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ReviewRequest".equals(entityTypeName) ? "ReviewRequests" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Generator".equals(entityTypeName) ? "Generators" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "GitHubCreds".equals(entityTypeName) ? "GitHubCreds" : defaultNameBuilder.buildEntitySetName(entityTypeName);
        return eSetName;
    }

    @Override
    public String buildEntityTypeName(final EntityType<?> jpaEntityType) {
        return defaultNameBuilder.buildEntityTypeName(jpaEntityType);
    }

    @Override
    public String buildEnumerationTypeName(final Class<? extends Enum<?>> javaEnum) {
        return defaultNameBuilder.buildEnumerationTypeName(javaEnum);
    }

    @Override
    public String buildNaviPropertyName(final Attribute<?, ?> jpaAttribute) {
        return defaultNameBuilder.buildNaviPropertyName(jpaAttribute);
    }

    @Override
    public String buildOperationName(final String internalOperationName) {
        return defaultNameBuilder.buildOperationName(internalOperationName);
    }

    @Override
    public String buildPropertyName(final String jpaAttributeName) {
        return defaultNameBuilder.buildPropertyName(jpaAttributeName);
    }

    @Override
    public String getNamespace() {
        return defaultNameBuilder.getNamespace();
    }
}
