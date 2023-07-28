package  ma.sir.ana;

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


import ma.sir.ana.bean.core.*;
import ma.sir.ana.service.facade.admin.*;

import ma.sir.ana.zynerator.security.common.AuthoritiesConstants;
import ma.sir.ana.zynerator.security.bean.User;
import ma.sir.ana.zynerator.security.bean.Permission;
import ma.sir.ana.zynerator.security.bean.Role;
import ma.sir.ana.zynerator.security.service.facade.UserService;
import ma.sir.ana.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.ana.required.facade")
public class AnaApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(AnaApplication.class, args);
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

            createTag();
            createField();
            createDocumentType();
            createGroupe();
            createDocumentField();
            createDocumentCategorieFieldRule();
            createDocumentCategorieField();
            createAcessShare();
            createDocumentState();
            createUtilisateur();
            createDocumentCategorie();
            createDocumentFieldState();
            createEntiteAdministrative();
            createAcessManagement();


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



    private void createTag(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            Tag item = new Tag();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            tagService.create(item);
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
    private void createDocumentField(){
        String value = "value";
        for (int i = 1; i < 100; i++) {
            DocumentField item = new DocumentField();
            item.setValue(fakeString(value, i));
            documentFieldService.create(item);
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
    private void createDocumentCategorieField(){
        for (int i = 1; i < 100; i++) {
            DocumentCategorieField item = new DocumentCategorieField();
            documentCategorieFieldService.create(item);
        }
    }
    private void createAcessShare(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            AcessShare item = new AcessShare();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            acessShareService.create(item);
        }
    }
    private void createDocumentState(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            DocumentState item = new DocumentState();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            documentStateService.create(item);
        }
    }
    private void createUtilisateur(){
        String email = "email";
        String name = "name";
        for (int i = 1; i < 100; i++) {
            Utilisateur item = new Utilisateur();
            item.setEmail(fakeString(email, i));
            item.setName(fakeString(name, i));
            utilisateurService.create(item);
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
    private void createDocumentFieldState(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            DocumentFieldState item = new DocumentFieldState();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            documentFieldStateService.create(item);
        }
    }
    private void createEntiteAdministrative(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            EntiteAdministrative item = new EntiteAdministrative();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            entiteAdministrativeService.create(item);
        }
    }
    private void createAcessManagement(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            AcessManagement item = new AcessManagement();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            acessManagementService.create(item);
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
        permissions.add(new Permission("Tag.edit"));
        permissions.add(new Permission("Tag.list"));
        permissions.add(new Permission("Tag.view"));
        permissions.add(new Permission("Tag.add"));
        permissions.add(new Permission("Tag.delete"));
        permissions.add(new Permission("DocumentManagementGroupe.edit"));
        permissions.add(new Permission("DocumentManagementGroupe.list"));
        permissions.add(new Permission("DocumentManagementGroupe.view"));
        permissions.add(new Permission("DocumentManagementGroupe.add"));
        permissions.add(new Permission("DocumentManagementGroupe.delete"));
        permissions.add(new Permission("Document.edit"));
        permissions.add(new Permission("Document.list"));
        permissions.add(new Permission("Document.view"));
        permissions.add(new Permission("Document.add"));
        permissions.add(new Permission("Document.delete"));
        permissions.add(new Permission("Field.edit"));
        permissions.add(new Permission("Field.list"));
        permissions.add(new Permission("Field.view"));
        permissions.add(new Permission("Field.add"));
        permissions.add(new Permission("Field.delete"));
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
        permissions.add(new Permission("Product.edit"));
        permissions.add(new Permission("Product.list"));
        permissions.add(new Permission("Product.view"));
        permissions.add(new Permission("Product.add"));
        permissions.add(new Permission("Product.delete"));
        permissions.add(new Permission("PurchaseTag.edit"));
        permissions.add(new Permission("PurchaseTag.list"));
        permissions.add(new Permission("PurchaseTag.view"));
        permissions.add(new Permission("PurchaseTag.add"));
        permissions.add(new Permission("PurchaseTag.delete"));
        permissions.add(new Permission("Groupe.edit"));
        permissions.add(new Permission("Groupe.list"));
        permissions.add(new Permission("Groupe.view"));
        permissions.add(new Permission("Groupe.add"));
        permissions.add(new Permission("Groupe.delete"));
        permissions.add(new Permission("DocumentField.edit"));
        permissions.add(new Permission("DocumentField.list"));
        permissions.add(new Permission("DocumentField.view"));
        permissions.add(new Permission("DocumentField.add"));
        permissions.add(new Permission("DocumentField.delete"));
        permissions.add(new Permission("DocumentCategorieFieldRule.edit"));
        permissions.add(new Permission("DocumentCategorieFieldRule.list"));
        permissions.add(new Permission("DocumentCategorieFieldRule.view"));
        permissions.add(new Permission("DocumentCategorieFieldRule.add"));
        permissions.add(new Permission("DocumentCategorieFieldRule.delete"));
        permissions.add(new Permission("PurchaseItem.edit"));
        permissions.add(new Permission("PurchaseItem.list"));
        permissions.add(new Permission("PurchaseItem.view"));
        permissions.add(new Permission("PurchaseItem.add"));
        permissions.add(new Permission("PurchaseItem.delete"));
        permissions.add(new Permission("DocumentCategorieField.edit"));
        permissions.add(new Permission("DocumentCategorieField.list"));
        permissions.add(new Permission("DocumentCategorieField.view"));
        permissions.add(new Permission("DocumentCategorieField.add"));
        permissions.add(new Permission("DocumentCategorieField.delete"));
        permissions.add(new Permission("DocumentPartageGroupe.edit"));
        permissions.add(new Permission("DocumentPartageGroupe.list"));
        permissions.add(new Permission("DocumentPartageGroupe.view"));
        permissions.add(new Permission("DocumentPartageGroupe.add"));
        permissions.add(new Permission("DocumentPartageGroupe.delete"));
        permissions.add(new Permission("AcessShare.edit"));
        permissions.add(new Permission("AcessShare.list"));
        permissions.add(new Permission("AcessShare.view"));
        permissions.add(new Permission("AcessShare.add"));
        permissions.add(new Permission("AcessShare.delete"));
        permissions.add(new Permission("ClientCategory.edit"));
        permissions.add(new Permission("ClientCategory.list"));
        permissions.add(new Permission("ClientCategory.view"));
        permissions.add(new Permission("ClientCategory.add"));
        permissions.add(new Permission("ClientCategory.delete"));
        permissions.add(new Permission("DocumentPartageUtilisateur.edit"));
        permissions.add(new Permission("DocumentPartageUtilisateur.list"));
        permissions.add(new Permission("DocumentPartageUtilisateur.view"));
        permissions.add(new Permission("DocumentPartageUtilisateur.add"));
        permissions.add(new Permission("DocumentPartageUtilisateur.delete"));
        permissions.add(new Permission("DocumentState.edit"));
        permissions.add(new Permission("DocumentState.list"));
        permissions.add(new Permission("DocumentState.view"));
        permissions.add(new Permission("DocumentState.add"));
        permissions.add(new Permission("DocumentState.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
        permissions.add(new Permission("DocumentCategorie.edit"));
        permissions.add(new Permission("DocumentCategorie.list"));
        permissions.add(new Permission("DocumentCategorie.view"));
        permissions.add(new Permission("DocumentCategorie.add"));
        permissions.add(new Permission("DocumentCategorie.delete"));
        permissions.add(new Permission("DocumentFieldState.edit"));
        permissions.add(new Permission("DocumentFieldState.list"));
        permissions.add(new Permission("DocumentFieldState.view"));
        permissions.add(new Permission("DocumentFieldState.add"));
        permissions.add(new Permission("DocumentFieldState.delete"));
        permissions.add(new Permission("DocumentManagementUtilisateur.edit"));
        permissions.add(new Permission("DocumentManagementUtilisateur.list"));
        permissions.add(new Permission("DocumentManagementUtilisateur.view"));
        permissions.add(new Permission("DocumentManagementUtilisateur.add"));
        permissions.add(new Permission("DocumentManagementUtilisateur.delete"));
        permissions.add(new Permission("DocumentAcessShare.edit"));
        permissions.add(new Permission("DocumentAcessShare.list"));
        permissions.add(new Permission("DocumentAcessShare.view"));
        permissions.add(new Permission("DocumentAcessShare.add"));
        permissions.add(new Permission("DocumentAcessShare.delete"));
        permissions.add(new Permission("EntiteAdministrative.edit"));
        permissions.add(new Permission("EntiteAdministrative.list"));
        permissions.add(new Permission("EntiteAdministrative.view"));
        permissions.add(new Permission("EntiteAdministrative.add"));
        permissions.add(new Permission("EntiteAdministrative.delete"));
        permissions.add(new Permission("AcessManagement.edit"));
        permissions.add(new Permission("AcessManagement.list"));
        permissions.add(new Permission("AcessManagement.view"));
        permissions.add(new Permission("AcessManagement.add"));
        permissions.add(new Permission("AcessManagement.delete"));
        permissions.add(new Permission("Purchase.edit"));
        permissions.add(new Permission("Purchase.list"));
        permissions.add(new Permission("Purchase.view"));
        permissions.add(new Permission("Purchase.add"));
        permissions.add(new Permission("Purchase.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("DocumentTag.edit"));
        permissions.add(new Permission("DocumentTag.list"));
        permissions.add(new Permission("DocumentTag.view"));
        permissions.add(new Permission("DocumentTag.add"));
        permissions.add(new Permission("DocumentTag.delete"));
    }
    private static void addPermissionForAgent(List<Permission> permissions){
        permissions.add(new Permission("Tag.edit"));
        permissions.add(new Permission("Tag.list"));
        permissions.add(new Permission("Tag.view"));
        permissions.add(new Permission("Tag.add"));
        permissions.add(new Permission("Tag.delete"));
        permissions.add(new Permission("DocumentManagementGroupe.edit"));
        permissions.add(new Permission("DocumentManagementGroupe.list"));
        permissions.add(new Permission("DocumentManagementGroupe.view"));
        permissions.add(new Permission("DocumentManagementGroupe.add"));
        permissions.add(new Permission("DocumentManagementGroupe.delete"));
        permissions.add(new Permission("Document.edit"));
        permissions.add(new Permission("Document.list"));
        permissions.add(new Permission("Document.view"));
        permissions.add(new Permission("Document.add"));
        permissions.add(new Permission("Document.delete"));
        permissions.add(new Permission("Field.edit"));
        permissions.add(new Permission("Field.list"));
        permissions.add(new Permission("Field.view"));
        permissions.add(new Permission("Field.add"));
        permissions.add(new Permission("Field.delete"));
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
        permissions.add(new Permission("Product.edit"));
        permissions.add(new Permission("Product.list"));
        permissions.add(new Permission("Product.view"));
        permissions.add(new Permission("Product.add"));
        permissions.add(new Permission("Product.delete"));
        permissions.add(new Permission("PurchaseTag.edit"));
        permissions.add(new Permission("PurchaseTag.list"));
        permissions.add(new Permission("PurchaseTag.view"));
        permissions.add(new Permission("PurchaseTag.add"));
        permissions.add(new Permission("PurchaseTag.delete"));
        permissions.add(new Permission("Groupe.edit"));
        permissions.add(new Permission("Groupe.list"));
        permissions.add(new Permission("Groupe.view"));
        permissions.add(new Permission("Groupe.add"));
        permissions.add(new Permission("Groupe.delete"));
        permissions.add(new Permission("DocumentField.edit"));
        permissions.add(new Permission("DocumentField.list"));
        permissions.add(new Permission("DocumentField.view"));
        permissions.add(new Permission("DocumentField.add"));
        permissions.add(new Permission("DocumentField.delete"));
        permissions.add(new Permission("DocumentCategorieFieldRule.edit"));
        permissions.add(new Permission("DocumentCategorieFieldRule.list"));
        permissions.add(new Permission("DocumentCategorieFieldRule.view"));
        permissions.add(new Permission("DocumentCategorieFieldRule.add"));
        permissions.add(new Permission("DocumentCategorieFieldRule.delete"));
        permissions.add(new Permission("PurchaseItem.edit"));
        permissions.add(new Permission("PurchaseItem.list"));
        permissions.add(new Permission("PurchaseItem.view"));
        permissions.add(new Permission("PurchaseItem.add"));
        permissions.add(new Permission("PurchaseItem.delete"));
        permissions.add(new Permission("DocumentCategorieField.edit"));
        permissions.add(new Permission("DocumentCategorieField.list"));
        permissions.add(new Permission("DocumentCategorieField.view"));
        permissions.add(new Permission("DocumentCategorieField.add"));
        permissions.add(new Permission("DocumentCategorieField.delete"));
        permissions.add(new Permission("DocumentPartageGroupe.edit"));
        permissions.add(new Permission("DocumentPartageGroupe.list"));
        permissions.add(new Permission("DocumentPartageGroupe.view"));
        permissions.add(new Permission("DocumentPartageGroupe.add"));
        permissions.add(new Permission("DocumentPartageGroupe.delete"));
        permissions.add(new Permission("AcessShare.edit"));
        permissions.add(new Permission("AcessShare.list"));
        permissions.add(new Permission("AcessShare.view"));
        permissions.add(new Permission("AcessShare.add"));
        permissions.add(new Permission("AcessShare.delete"));
        permissions.add(new Permission("ClientCategory.edit"));
        permissions.add(new Permission("ClientCategory.list"));
        permissions.add(new Permission("ClientCategory.view"));
        permissions.add(new Permission("ClientCategory.add"));
        permissions.add(new Permission("ClientCategory.delete"));
        permissions.add(new Permission("DocumentPartageUtilisateur.edit"));
        permissions.add(new Permission("DocumentPartageUtilisateur.list"));
        permissions.add(new Permission("DocumentPartageUtilisateur.view"));
        permissions.add(new Permission("DocumentPartageUtilisateur.add"));
        permissions.add(new Permission("DocumentPartageUtilisateur.delete"));
        permissions.add(new Permission("DocumentState.edit"));
        permissions.add(new Permission("DocumentState.list"));
        permissions.add(new Permission("DocumentState.view"));
        permissions.add(new Permission("DocumentState.add"));
        permissions.add(new Permission("DocumentState.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
        permissions.add(new Permission("DocumentCategorie.edit"));
        permissions.add(new Permission("DocumentCategorie.list"));
        permissions.add(new Permission("DocumentCategorie.view"));
        permissions.add(new Permission("DocumentCategorie.add"));
        permissions.add(new Permission("DocumentCategorie.delete"));
        permissions.add(new Permission("DocumentFieldState.edit"));
        permissions.add(new Permission("DocumentFieldState.list"));
        permissions.add(new Permission("DocumentFieldState.view"));
        permissions.add(new Permission("DocumentFieldState.add"));
        permissions.add(new Permission("DocumentFieldState.delete"));
        permissions.add(new Permission("DocumentManagementUtilisateur.edit"));
        permissions.add(new Permission("DocumentManagementUtilisateur.list"));
        permissions.add(new Permission("DocumentManagementUtilisateur.view"));
        permissions.add(new Permission("DocumentManagementUtilisateur.add"));
        permissions.add(new Permission("DocumentManagementUtilisateur.delete"));
        permissions.add(new Permission("DocumentAcessShare.edit"));
        permissions.add(new Permission("DocumentAcessShare.list"));
        permissions.add(new Permission("DocumentAcessShare.view"));
        permissions.add(new Permission("DocumentAcessShare.add"));
        permissions.add(new Permission("DocumentAcessShare.delete"));
        permissions.add(new Permission("EntiteAdministrative.edit"));
        permissions.add(new Permission("EntiteAdministrative.list"));
        permissions.add(new Permission("EntiteAdministrative.view"));
        permissions.add(new Permission("EntiteAdministrative.add"));
        permissions.add(new Permission("EntiteAdministrative.delete"));
        permissions.add(new Permission("AcessManagement.edit"));
        permissions.add(new Permission("AcessManagement.list"));
        permissions.add(new Permission("AcessManagement.view"));
        permissions.add(new Permission("AcessManagement.add"));
        permissions.add(new Permission("AcessManagement.delete"));
        permissions.add(new Permission("Purchase.edit"));
        permissions.add(new Permission("Purchase.list"));
        permissions.add(new Permission("Purchase.view"));
        permissions.add(new Permission("Purchase.add"));
        permissions.add(new Permission("Purchase.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("DocumentTag.edit"));
        permissions.add(new Permission("DocumentTag.list"));
        permissions.add(new Permission("DocumentTag.view"));
        permissions.add(new Permission("DocumentTag.add"));
        permissions.add(new Permission("DocumentTag.delete"));
    }

    @Autowired
    TagAdminService tagService;
    @Autowired
    FieldAdminService fieldService;
    @Autowired
    DocumentTypeAdminService documentTypeService;
    @Autowired
    GroupeAdminService groupeService;
    @Autowired
    DocumentFieldAdminService documentFieldService;
    @Autowired
    DocumentCategorieFieldRuleAdminService documentCategorieFieldRuleService;
    @Autowired
    DocumentCategorieFieldAdminService documentCategorieFieldService;
    @Autowired
    AcessShareAdminService acessShareService;
    @Autowired
    DocumentStateAdminService documentStateService;
    @Autowired
    UtilisateurAdminService utilisateurService;
    @Autowired
    DocumentCategorieAdminService documentCategorieService;
    @Autowired
    DocumentFieldStateAdminService documentFieldStateService;
    @Autowired
    EntiteAdministrativeAdminService entiteAdministrativeService;
    @Autowired
    AcessManagementAdminService acessManagementService;
}

