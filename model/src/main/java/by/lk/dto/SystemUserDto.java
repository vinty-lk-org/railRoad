package by.lk.dto;

import by.lk.entity.BaseEntity;
import by.lk.entity.Privilege;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class SystemUserDto extends BaseEntity {
    private String nameUser;
    private String familyUser;
    private String email;
    private String passwordUser;
    private Long privilegeId;
}
