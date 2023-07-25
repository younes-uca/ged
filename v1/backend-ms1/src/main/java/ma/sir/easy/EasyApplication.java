package  ma.sir.easy;

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


import ma.sir.easy.bean.core.*;
import ma.sir.easy.service.facade.admin.*;

import ma.sir.easy.zynerator.security.common.AuthoritiesConstants;
import ma.sir.easy.zynerator.security.bean.User;
import ma.sir.easy.zynerator.security.bean.Permission;
import ma.sir.easy.zynerator.security.bean.Role;
import ma.sir.easy.zynerator.security.service.facade.UserService;
import ma.sir.easy.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.easy.required.facade")
public class EasyApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(EasyApplication.class, args);
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
        if(false){

            createTag();
            createEntiteAdministrative();
            createUtilisateur();
            createDocumentType();
            createGroupe();
            createAcessManagement();
            createAcessShare();


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
        permissions.add(new Permission("DocumentPartageGroupe.edit"));
        permissions.add(new Permission("DocumentPartageGroupe.list"));
        permissions.add(new Permission("DocumentPartageGroupe.view"));
        permissions.add(new Permission("DocumentPartageGroupe.add"));
        permissions.add(new Permission("DocumentPartageGroupe.delete"));
        permissions.add(new Permission("DocumentAcessShare.edit"));
        permissions.add(new Permission("DocumentAcessShare.list"));
        permissions.add(new Permission("DocumentAcessShare.view"));
        permissions.add(new Permission("DocumentAcessShare.add"));
        permissions.add(new Permission("DocumentAcessShare.delete"));
        permissions.add(new Permission("Document.edit"));
        permissions.add(new Permission("Document.list"));
        permissions.add(new Permission("Document.view"));
        permissions.add(new Permission("Document.add"));
        permissions.add(new Permission("Document.delete"));
        permissions.add(new Permission("Tag.edit"));
        permissions.add(new Permission("Tag.list"));
        permissions.add(new Permission("Tag.view"));
        permissions.add(new Permission("Tag.add"));
        permissions.add(new Permission("Tag.delete"));
        permissions.add(new Permission("DocumentPartageUtilisateur.edit"));
        permissions.add(new Permission("DocumentPartageUtilisateur.list"));
        permissions.add(new Permission("DocumentPartageUtilisateur.view"));
        permissions.add(new Permission("DocumentPartageUtilisateur.add"));
        permissions.add(new Permission("DocumentPartageUtilisateur.delete"));
        permissions.add(new Permission("GroupeUtilisateur.edit"));
        permissions.add(new Permission("GroupeUtilisateur.list"));
        permissions.add(new Permission("GroupeUtilisateur.view"));
        permissions.add(new Permission("GroupeUtilisateur.add"));
        permissions.add(new Permission("GroupeUtilisateur.delete"));
        permissions.add(new Permission("EntiteAdministrative.edit"));
        permissions.add(new Permission("EntiteAdministrative.list"));
        permissions.add(new Permission("EntiteAdministrative.view"));
        permissions.add(new Permission("EntiteAdministrative.add"));
        permissions.add(new Permission("EntiteAdministrative.delete"));
        permissions.add(new Permission("DocumentTag.edit"));
        permissions.add(new Permission("DocumentTag.list"));
        permissions.add(new Permission("DocumentTag.view"));
        permissions.add(new Permission("DocumentTag.add"));
        permissions.add(new Permission("DocumentTag.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
        permissions.add(new Permission("DocumentManagementUtilisateur.edit"));
        permissions.add(new Permission("DocumentManagementUtilisateur.list"));
        permissions.add(new Permission("DocumentManagementUtilisateur.view"));
        permissions.add(new Permission("DocumentManagementUtilisateur.add"));
        permissions.add(new Permission("DocumentManagementUtilisateur.delete"));
        permissions.add(new Permission("DocumentType.edit"));
        permissions.add(new Permission("DocumentType.list"));
        permissions.add(new Permission("DocumentType.view"));
        permissions.add(new Permission("DocumentType.add"));
        permissions.add(new Permission("DocumentType.delete"));
        permissions.add(new Permission("Groupe.edit"));
        permissions.add(new Permission("Groupe.list"));
        permissions.add(new Permission("Groupe.view"));
        permissions.add(new Permission("Groupe.add"));
        permissions.add(new Permission("Groupe.delete"));
        permissions.add(new Permission("AcessManagement.edit"));
        permissions.add(new Permission("AcessManagement.list"));
        permissions.add(new Permission("AcessManagement.view"));
        permissions.add(new Permission("AcessManagement.add"));
        permissions.add(new Permission("AcessManagement.delete"));
        permissions.add(new Permission("AcessShare.edit"));
        permissions.add(new Permission("AcessShare.list"));
        permissions.add(new Permission("AcessShare.view"));
        permissions.add(new Permission("AcessShare.add"));
        permissions.add(new Permission("AcessShare.delete"));
        permissions.add(new Permission("DocumentManagementGroupe.edit"));
        permissions.add(new Permission("DocumentManagementGroupe.list"));
        permissions.add(new Permission("DocumentManagementGroupe.view"));
        permissions.add(new Permission("DocumentManagementGroupe.add"));
        permissions.add(new Permission("DocumentManagementGroupe.delete"));
    }

    @Autowired
    TagAdminService tagService;
    @Autowired
    EntiteAdministrativeAdminService entiteAdministrativeService;
    @Autowired
    UtilisateurAdminService utilisateurService;
    @Autowired
    DocumentTypeAdminService documentTypeService;
    @Autowired
    GroupeAdminService groupeService;
    @Autowired
    AcessManagementAdminService acessManagementService;
    @Autowired
    AcessShareAdminService acessShareService;
}


