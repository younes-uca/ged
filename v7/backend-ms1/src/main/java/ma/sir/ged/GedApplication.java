package  ma.sir.ged;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.ged.bean.core.*;
import ma.sir.ged.service.facade.admin.*;

import ma.sir.ged.zynerator.security.common.AuthoritiesConstants;
import ma.sir.ged.zynerator.security.bean.User;
import ma.sir.ged.zynerator.security.bean.Permission;
import ma.sir.ged.zynerator.security.bean.Role;
import ma.sir.ged.zynerator.security.service.facade.UserService;
import ma.sir.ged.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.ged.required.facade")
public class GedApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(GedApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){

//            createDocumentType();
//            createDocumentCategorieField();
//            createUtilisateur();
//            createDocumentState();
//            createRoleUtilisateur();
//            createEntiteAdministrativeType();
//            createEtatUtilisateur();
//            createGroupe();
//            createAccessShare();
//            createDocumentFieldState();
//            createEntiteAdministrative();
//            createDocumentField();
//            createField();
//            createDocumentCategorieFieldRule();
//            createDocumentCategorie();


    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);


    // Role agent

        User userForAgent = new User("agent");

        Role roleForAgent = new Role();
        roleForAgent.setAuthority(AuthoritiesConstants.AGENT);
        List<Permission> permissionsForAgent = new ArrayList<>();
        addPermissionForAgent(permissionsForAgent);
        roleForAgent.setPermissions(permissionsForAgent);
        if(userForAgent.getRoles()==null)
            userForAgent.setRoles(new ArrayList<>());

        userForAgent.getRoles().add(roleForAgent);
        userService.save(userForAgent);
            }
        };
    }



    private void createDocumentType(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            DocumentType item = new DocumentType();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            documentTypeService.create(item);
        }
    }
    private void createDocumentCategorieField(){
        for (int i = 1; i < 100; i++) {
            DocumentCategorieField item = new DocumentCategorieField();
            documentCategorieFieldService.create(item);
        }
    }
    private void createUtilisateur(){
        String email = "email";
        String nom = "nom";
        String prenom = "prenom";
        for (int i = 1; i < 100; i++) {
            Utilisateur item = new Utilisateur();
            item.setEmail(fakeString(email, i));
            item.setNom(fakeString(nom, i));
            item.setPrenom(fakeString(prenom, i));
            utilisateurService.create(item);
        }
    }
    private void createDocumentState(){
        String code = "code";
        String libelle = "libelle";
        String style = "style";
        for (int i = 1; i < 100; i++) {
            DocumentState item = new DocumentState();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            item.setStyle(fakeString(style, i));
            documentStateService.create(item);
        }
    }
    private void createRoleUtilisateur(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            RoleUtilisateur item = new RoleUtilisateur();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            roleUtilisateurService.create(item);
        }
    }
    private void createEntiteAdministrativeType(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            EntiteAdministrativeType item = new EntiteAdministrativeType();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            entiteAdministrativeTypeService.create(item);
        }
    }
    private void createEtatUtilisateur(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            EtatUtilisateur item = new EtatUtilisateur();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            etatUtilisateurService.create(item);
        }
    }
    private void createGroupe(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            Groupe item = new Groupe();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            groupeService.create(item);
        }
    }
    private void createAccessShare(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            AccessShare item = new AccessShare();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            accessShareService.create(item);
        }
    }
    private void createDocumentFieldState(){
        String code = "code";
        String libelle = "libelle";
        String style = "style";
        for (int i = 1; i < 100; i++) {
            DocumentFieldState item = new DocumentFieldState();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            item.setStyle(fakeString(style, i));
            documentFieldStateService.create(item);
        }
    }
    private void createEntiteAdministrative(){
        String code = "code";
        String description = "description";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            EntiteAdministrative item = new EntiteAdministrative();
            item.setCode(fakeString(code, i));
            item.setDescription(fakeString(description, i));
            item.setLibelle(fakeString(libelle, i));
            entiteAdministrativeService.create(item);
        }
    }
    private void createDocumentField(){
        String value = "value";
        for (int i = 1; i < 100; i++) {
            DocumentField item = new DocumentField();
            item.setValue(fakeString(value, i));
            documentFieldService.create(item);
        }
    }
    private void createField(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            Field item = new Field();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            fieldService.create(item);
        }
    }
    private void createDocumentCategorieFieldRule(){
        String code = "code";
        String libelle = "libelle";
        String expresion = "expresion";
        for (int i = 1; i < 100; i++) {
            DocumentCategorieFieldRule item = new DocumentCategorieFieldRule();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            item.setExpresion(fakeString(expresion, i));
            documentCategorieFieldRuleService.create(item);
        }
    }
    private void createDocumentCategorie(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            DocumentCategorie item = new DocumentCategorie();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            documentCategorieService.create(item);
        }
    }

    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("DocumentType.edit"));
        permissions.add(new Permission("DocumentType.list"));
        permissions.add(new Permission("DocumentType.view"));
        permissions.add(new Permission("DocumentType.add"));
        permissions.add(new Permission("DocumentType.delete"));
        permissions.add(new Permission("GroupeUtilisateur.edit"));
        permissions.add(new Permission("GroupeUtilisateur.list"));
        permissions.add(new Permission("GroupeUtilisateur.view"));
        permissions.add(new Permission("GroupeUtilisateur.add"));
        permissions.add(new Permission("GroupeUtilisateur.delete"));
        permissions.add(new Permission("DocumentPartageUtilisateur.edit"));
        permissions.add(new Permission("DocumentPartageUtilisateur.list"));
        permissions.add(new Permission("DocumentPartageUtilisateur.view"));
        permissions.add(new Permission("DocumentPartageUtilisateur.add"));
        permissions.add(new Permission("DocumentPartageUtilisateur.delete"));
        permissions.add(new Permission("DocumentCategorieField.edit"));
        permissions.add(new Permission("DocumentCategorieField.list"));
        permissions.add(new Permission("DocumentCategorieField.view"));
        permissions.add(new Permission("DocumentCategorieField.add"));
        permissions.add(new Permission("DocumentCategorieField.delete"));
        permissions.add(new Permission("Document.edit"));
        permissions.add(new Permission("Document.list"));
        permissions.add(new Permission("Document.view"));
        permissions.add(new Permission("Document.add"));
        permissions.add(new Permission("Document.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
        permissions.add(new Permission("DocumentState.edit"));
        permissions.add(new Permission("DocumentState.list"));
        permissions.add(new Permission("DocumentState.view"));
        permissions.add(new Permission("DocumentState.add"));
        permissions.add(new Permission("DocumentState.delete"));
        permissions.add(new Permission("RoleUtilisateur.edit"));
        permissions.add(new Permission("RoleUtilisateur.list"));
        permissions.add(new Permission("RoleUtilisateur.view"));
        permissions.add(new Permission("RoleUtilisateur.add"));
        permissions.add(new Permission("RoleUtilisateur.delete"));
        permissions.add(new Permission("EntiteAdministrativeType.edit"));
        permissions.add(new Permission("EntiteAdministrativeType.list"));
        permissions.add(new Permission("EntiteAdministrativeType.view"));
        permissions.add(new Permission("EntiteAdministrativeType.add"));
        permissions.add(new Permission("EntiteAdministrativeType.delete"));
        permissions.add(new Permission("EtatUtilisateur.edit"));
        permissions.add(new Permission("EtatUtilisateur.list"));
        permissions.add(new Permission("EtatUtilisateur.view"));
        permissions.add(new Permission("EtatUtilisateur.add"));
        permissions.add(new Permission("EtatUtilisateur.delete"));
        permissions.add(new Permission("Groupe.edit"));
        permissions.add(new Permission("Groupe.list"));
        permissions.add(new Permission("Groupe.view"));
        permissions.add(new Permission("Groupe.add"));
        permissions.add(new Permission("Groupe.delete"));
        permissions.add(new Permission("AccessShare.edit"));
        permissions.add(new Permission("AccessShare.list"));
        permissions.add(new Permission("AccessShare.view"));
        permissions.add(new Permission("AccessShare.add"));
        permissions.add(new Permission("AccessShare.delete"));
        permissions.add(new Permission("DocumentFieldState.edit"));
        permissions.add(new Permission("DocumentFieldState.list"));
        permissions.add(new Permission("DocumentFieldState.view"));
        permissions.add(new Permission("DocumentFieldState.add"));
        permissions.add(new Permission("DocumentFieldState.delete"));
        permissions.add(new Permission("DocumentPartageGroupe.edit"));
        permissions.add(new Permission("DocumentPartageGroupe.list"));
        permissions.add(new Permission("DocumentPartageGroupe.view"));
        permissions.add(new Permission("DocumentPartageGroupe.add"));
        permissions.add(new Permission("DocumentPartageGroupe.delete"));
        permissions.add(new Permission("EntiteAdministrative.edit"));
        permissions.add(new Permission("EntiteAdministrative.list"));
        permissions.add(new Permission("EntiteAdministrative.view"));
        permissions.add(new Permission("EntiteAdministrative.add"));
        permissions.add(new Permission("EntiteAdministrative.delete"));
        permissions.add(new Permission("DocumentField.edit"));
        permissions.add(new Permission("DocumentField.list"));
        permissions.add(new Permission("DocumentField.view"));
        permissions.add(new Permission("DocumentField.add"));
        permissions.add(new Permission("DocumentField.delete"));
        permissions.add(new Permission("Field.edit"));
        permissions.add(new Permission("Field.list"));
        permissions.add(new Permission("Field.view"));
        permissions.add(new Permission("Field.add"));
        permissions.add(new Permission("Field.delete"));
        permissions.add(new Permission("DocumentCategorieFieldRule.edit"));
        permissions.add(new Permission("DocumentCategorieFieldRule.list"));
        permissions.add(new Permission("DocumentCategorieFieldRule.view"));
        permissions.add(new Permission("DocumentCategorieFieldRule.add"));
        permissions.add(new Permission("DocumentCategorieFieldRule.delete"));
        permissions.add(new Permission("DocumentCategorie.edit"));
        permissions.add(new Permission("DocumentCategorie.list"));
        permissions.add(new Permission("DocumentCategorie.view"));
        permissions.add(new Permission("DocumentCategorie.add"));
        permissions.add(new Permission("DocumentCategorie.delete"));
    }
    private static void addPermissionForAgent(List<Permission> permissions){
        permissions.add(new Permission("DocumentType.edit"));
        permissions.add(new Permission("DocumentType.list"));
        permissions.add(new Permission("DocumentType.view"));
        permissions.add(new Permission("DocumentType.add"));
        permissions.add(new Permission("DocumentType.delete"));
        permissions.add(new Permission("GroupeUtilisateur.edit"));
        permissions.add(new Permission("GroupeUtilisateur.list"));
        permissions.add(new Permission("GroupeUtilisateur.view"));
        permissions.add(new Permission("GroupeUtilisateur.add"));
        permissions.add(new Permission("GroupeUtilisateur.delete"));
        permissions.add(new Permission("DocumentPartageUtilisateur.edit"));
        permissions.add(new Permission("DocumentPartageUtilisateur.list"));
        permissions.add(new Permission("DocumentPartageUtilisateur.view"));
        permissions.add(new Permission("DocumentPartageUtilisateur.add"));
        permissions.add(new Permission("DocumentPartageUtilisateur.delete"));
        permissions.add(new Permission("DocumentCategorieField.edit"));
        permissions.add(new Permission("DocumentCategorieField.list"));
        permissions.add(new Permission("DocumentCategorieField.view"));
        permissions.add(new Permission("DocumentCategorieField.add"));
        permissions.add(new Permission("DocumentCategorieField.delete"));
        permissions.add(new Permission("Document.edit"));
        permissions.add(new Permission("Document.list"));
        permissions.add(new Permission("Document.view"));
        permissions.add(new Permission("Document.add"));
        permissions.add(new Permission("Document.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
        permissions.add(new Permission("DocumentState.edit"));
        permissions.add(new Permission("DocumentState.list"));
        permissions.add(new Permission("DocumentState.view"));
        permissions.add(new Permission("DocumentState.add"));
        permissions.add(new Permission("DocumentState.delete"));
        permissions.add(new Permission("RoleUtilisateur.edit"));
        permissions.add(new Permission("RoleUtilisateur.list"));
        permissions.add(new Permission("RoleUtilisateur.view"));
        permissions.add(new Permission("RoleUtilisateur.add"));
        permissions.add(new Permission("RoleUtilisateur.delete"));
        permissions.add(new Permission("EntiteAdministrativeType.edit"));
        permissions.add(new Permission("EntiteAdministrativeType.list"));
        permissions.add(new Permission("EntiteAdministrativeType.view"));
        permissions.add(new Permission("EntiteAdministrativeType.add"));
        permissions.add(new Permission("EntiteAdministrativeType.delete"));
        permissions.add(new Permission("EtatUtilisateur.edit"));
        permissions.add(new Permission("EtatUtilisateur.list"));
        permissions.add(new Permission("EtatUtilisateur.view"));
        permissions.add(new Permission("EtatUtilisateur.add"));
        permissions.add(new Permission("EtatUtilisateur.delete"));
        permissions.add(new Permission("Groupe.edit"));
        permissions.add(new Permission("Groupe.list"));
        permissions.add(new Permission("Groupe.view"));
        permissions.add(new Permission("Groupe.add"));
        permissions.add(new Permission("Groupe.delete"));
        permissions.add(new Permission("AccessShare.edit"));
        permissions.add(new Permission("AccessShare.list"));
        permissions.add(new Permission("AccessShare.view"));
        permissions.add(new Permission("AccessShare.add"));
        permissions.add(new Permission("AccessShare.delete"));
        permissions.add(new Permission("DocumentFieldState.edit"));
        permissions.add(new Permission("DocumentFieldState.list"));
        permissions.add(new Permission("DocumentFieldState.view"));
        permissions.add(new Permission("DocumentFieldState.add"));
        permissions.add(new Permission("DocumentFieldState.delete"));
        permissions.add(new Permission("DocumentPartageGroupe.edit"));
        permissions.add(new Permission("DocumentPartageGroupe.list"));
        permissions.add(new Permission("DocumentPartageGroupe.view"));
        permissions.add(new Permission("DocumentPartageGroupe.add"));
        permissions.add(new Permission("DocumentPartageGroupe.delete"));
        permissions.add(new Permission("EntiteAdministrative.edit"));
        permissions.add(new Permission("EntiteAdministrative.list"));
        permissions.add(new Permission("EntiteAdministrative.view"));
        permissions.add(new Permission("EntiteAdministrative.add"));
        permissions.add(new Permission("EntiteAdministrative.delete"));
        permissions.add(new Permission("DocumentField.edit"));
        permissions.add(new Permission("DocumentField.list"));
        permissions.add(new Permission("DocumentField.view"));
        permissions.add(new Permission("DocumentField.add"));
        permissions.add(new Permission("DocumentField.delete"));
        permissions.add(new Permission("Field.edit"));
        permissions.add(new Permission("Field.list"));
        permissions.add(new Permission("Field.view"));
        permissions.add(new Permission("Field.add"));
        permissions.add(new Permission("Field.delete"));
        permissions.add(new Permission("DocumentCategorieFieldRule.edit"));
        permissions.add(new Permission("DocumentCategorieFieldRule.list"));
        permissions.add(new Permission("DocumentCategorieFieldRule.view"));
        permissions.add(new Permission("DocumentCategorieFieldRule.add"));
        permissions.add(new Permission("DocumentCategorieFieldRule.delete"));
        permissions.add(new Permission("DocumentCategorie.edit"));
        permissions.add(new Permission("DocumentCategorie.list"));
        permissions.add(new Permission("DocumentCategorie.view"));
        permissions.add(new Permission("DocumentCategorie.add"));
        permissions.add(new Permission("DocumentCategorie.delete"));
    }

    @Autowired
    DocumentTypeAdminService documentTypeService;
    @Autowired
    DocumentCategorieFieldAdminService documentCategorieFieldService;
    @Autowired
    UtilisateurAdminService utilisateurService;
    @Autowired
    DocumentStateAdminService documentStateService;
    @Autowired
    RoleUtilisateurAdminService roleUtilisateurService;
    @Autowired
    EntiteAdministrativeTypeAdminService entiteAdministrativeTypeService;
    @Autowired
    EtatUtilisateurAdminService etatUtilisateurService;
    @Autowired
    GroupeAdminService groupeService;
    @Autowired
    AccessShareAdminService accessShareService;
    @Autowired
    DocumentFieldStateAdminService documentFieldStateService;
    @Autowired
    EntiteAdministrativeAdminService entiteAdministrativeService;
    @Autowired
    DocumentFieldAdminService documentFieldService;
    @Autowired
    FieldAdminService fieldService;
    @Autowired
    DocumentCategorieFieldRuleAdminService documentCategorieFieldRuleService;
    @Autowired
    DocumentCategorieAdminService documentCategorieService;
}


