package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPF_SISTEMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(
            name = "SQ_SISTEMA",
            sequenceName = "SQ_SISTEMA",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_SISTEMA")
    private long id;

    @Column(name = "NM_SISTEMA")
    private String nome;

    @Column(name = "SL_SISTEMA")
    private String sigla;
}
