package com.mycompany.group234.function;

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

import com.mycompany.group234.model.jointable.FrontendAppSelectedScreens;



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
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmAction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataAction;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class JavaActions implements ODataAction {
    private static Logger log = LogManager.getLogger(JavaActions.class);
    private final EntityManager entityManager;

    public JavaActions(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @EdmAction(name = "LinkFrontendAppWithFrontendScreens", isBound = false)
    public boolean linkFrontendAppWithFrontendScreens(@EdmParameter(name = "ProjectId")final long projectId) {
        try { 
            Project project = entityManager.find(Project.class, projectId);
            log.info("Trip with TripId not found.");
            log.info("Action Project: " + project.getProjectFrontendApp());
            if( project != null && project.getProjectFrontendApp() != null ) {
                FrontendApp frontendApp = entityManager.find(FrontendApp.class, project.getProjectFrontendApp());
                log.info(frontendApp);           
                if (frontendApp != null) {
                    for(int selectedScreen : frontendApp.getSelectedScreenIds()) {
                        log.info(selectedScreen);
                        FrontendAppSelectedScreens jointable = new FrontendAppSelectedScreens();
                        jointable.setAppId(frontendApp.getAppId());
                        jointable.setFeScreenId(selectedScreen);
//                        jointable.setId(1);
                        entityManager.getTransaction().begin();
                        entityManager.merge(jointable);
                        entityManager.getTransaction().commit();
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
        	log.error("Error in LinkTripWithPlanItem", e);
            return false;
        }
    }
	
}
  