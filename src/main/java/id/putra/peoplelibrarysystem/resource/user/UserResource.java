package id.putra.peoplelibrarysystem.resource.user;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.core.SecurityContext;

public class UserResource implements UserRoute {

    @Override
    public TemplateInstance user(SecurityContext sec) {
        UserDatasource datasource = new UserDatasource();
        return Templates.index(datasource);
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(UserDatasource data);
    }
}
