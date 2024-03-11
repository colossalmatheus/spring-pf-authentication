package entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_2TDSPF_PERFIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERFIL")
    @SequenceGenerator(
            name = "SQ_PERFIL",
            sequenceName = "SQ_PERFIL",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PERFIL")
    private long id;

    @Column(name = "NM_PERFIL")
    private String nome;


    private Set<Permissao> permissoes = new LinkedHashSet<>();


}
