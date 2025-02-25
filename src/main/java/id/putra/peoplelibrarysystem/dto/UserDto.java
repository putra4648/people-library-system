package id.putra.peoplelibrarysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    private String id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private RoleDto role;
}
