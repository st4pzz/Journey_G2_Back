package Journey.demo.viagem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String idMotorista;
    private String dataStart;
    private String origem;
    private String  destino;
    private String horasStart;
    private String tempoTotal;
    private Integer precoTotal;
    private ViagemStatus status;
}
