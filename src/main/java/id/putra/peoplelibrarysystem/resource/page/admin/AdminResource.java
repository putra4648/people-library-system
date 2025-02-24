package id.putra.peoplelibrarysystem.resource.page.admin;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

public class AdminResource implements AdminRoute {
    @Override
    public TemplateInstance admin(@Context SecurityContext sec) {
        AdminDatasource data = new AdminDatasource(sec.getUserPrincipal().getName());
        return AdminTemplates.index(data);
    }

    @CheckedTemplate
    public static class AdminTemplates {
        public static native TemplateInstance index(AdminDatasource data);
    }

}
