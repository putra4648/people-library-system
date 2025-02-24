package id.putra.peoplelibrarysystem.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<id.putra.peoplelibrarysystem.entity.User> {
}
