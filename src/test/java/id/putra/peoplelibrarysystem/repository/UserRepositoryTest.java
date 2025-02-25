package id.putra.peoplelibrarysystem.repository;

import id.putra.peoplelibrarysystem.entity.User;
import id.putra.peoplelibrarysystem.service.UserService;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class UserRepositoryTest {
    @InjectMock
    UserRepository userRepository;

    @Test
    public void whenUserEmpty_shouldReturnZero() throws Throwable {
        /// When user is empty return 0
        Mockito.when(userRepository.count()).thenReturn(0L);
        Assertions.assertEquals(0, userRepository.count());
    }

    @Test
    public void whenUserAdded_shouldReturnOne() throws Throwable {
        /// When 1 user added should return 1
        var user = User.builder().username("admin").password(BcryptUtil.bcryptHash("admin123", 10)).build();
        userRepository.persistAndFlush(user);
        Mockito.verify(userRepository, Mockito.times(1)).persistAndFlush(user);
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}
