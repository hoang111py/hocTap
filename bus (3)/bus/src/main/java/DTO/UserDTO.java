package DTO;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {
    private String username;
    private String password;  // Add this field
    private String role;
}



