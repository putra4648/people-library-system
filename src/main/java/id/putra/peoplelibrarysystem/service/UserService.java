package id.putra.peoplelibrarysystem.service;

import id.putra.peoplelibrarysystem.dto.UserDto;
import id.putra.peoplelibrarysystem.entity.User;
import id.putra.peoplelibrarysystem.exception.UserException;
import id.putra.peoplelibrarysystem.repository.RoleRepository;
import id.putra.peoplelibrarysystem.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class UserService implements BaseCrudService<UserDto> {
    @Inject
    UserRepository userRepository;

    @Inject
    RoleRepository roleRepository;

    @Override
    public void save(UserDto userDto) throws UserException {
        var user = userRepository.find("username", userDto.getUsername());
        var role = roleRepository.find("name", userDto.getRole().getName());
        if (user.count() == 0) {
            var userEntity = User
                    .builder()
                    .email(userDto.getEmail())
                    .username(userDto.getUsername())
                    .password(BcryptUtil.bcryptHash(userDto.getPassword(), 10))
                    .role(role.firstResult()    )
                    .build();
            userRepository.persist(userEntity);
        } else {
            throw new UserException("Username already exist");
        }
    }

    @Override
    public void update(UserDto userDto) {
        var user = userRepository.find("username", userDto.getUsername());
        user.stream().forEach(u -> {
            userRepository.update("username = ?1, password = ?2", u.getUsername(), u.getPassword());
        });
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete("username = ?1", userDto.getUsername());
    }

    @Override
    public UserDto findOne(String query, Sort sort, UserDto userDto) {
        PanacheQuery<User> user = userRepository.find(query, sort, userDto.getUsername());
        if (user.count() == 1) {
            User userEntity = user.firstResult();
            return UserDto.builder().username(userEntity.getUsername()).email(userEntity.getPassword()).build();
        }
        return null;
    }

    @Override
    public List<UserDto> findAll(String query, Sort sort, UserDto userDto) {
        return List.of();
    }
}
