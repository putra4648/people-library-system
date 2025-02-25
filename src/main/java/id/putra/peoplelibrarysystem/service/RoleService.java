package id.putra.peoplelibrarysystem.service;

import id.putra.peoplelibrarysystem.dto.RoleDto;
import id.putra.peoplelibrarysystem.entity.Role;
import id.putra.peoplelibrarysystem.exception.UserException;
import id.putra.peoplelibrarysystem.repository.RoleRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class RoleService implements BaseCrudService<RoleDto> {

    @Inject
    RoleRepository roleRepository;

    @Override
    public void save(RoleDto Dto) throws UserException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(RoleDto Dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(RoleDto Dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RoleDto findOne(String query, Sort sort, RoleDto Dto) {
        Role role = roleRepository.find(query, sort, Dto.getName().toUpperCase()).firstResult();
        return RoleDto.builder().id(role.getId()).name(role.getName()).build();
    }

    @Override
    public List<RoleDto> findAll(String query, Sort sort, RoleDto Dto) {
        return List.of();
    }
}
