package id.putra.peoplelibrarysystem.repository;

import id.putra.peoplelibrarysystem.entity.Role;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoleRepository implements PanacheRepository<Role> {
}
