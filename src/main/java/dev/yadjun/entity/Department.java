package dev.yadjun.entity;
import dev.yadjun.enums.DepartmentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Department {
    @Id
    private Long id;

}
