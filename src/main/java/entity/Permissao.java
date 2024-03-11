package entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPF_PERMISSAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
    @SequenceGenerator(
            name = "SQ_PERMISSAO",
            sequenceName = "SQ_PERMISSAO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PERMISSAO")
    private long id;

    @Column(name = "NM_PERMISSAO")
    private String nome;


}
