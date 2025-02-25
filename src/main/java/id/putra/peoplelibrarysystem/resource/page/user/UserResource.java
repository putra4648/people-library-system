package id.putra.peoplelibrarysystem.resource.page.user;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.core.SecurityContext;

public class UserResource implements UserRoute {

    @Override
    public TemplateInstance user(SecurityContext sec) {
        UserDatasource userDatasource = new UserDatasource(sec.getUserPrincipal().getName());
        return UserTemplates.index(userDatasource);
    }

    @CheckedTemplate
    public static class UserTemplates {
        public static native TemplateInstance index(UserDatasource userDatasource);
    }
}
