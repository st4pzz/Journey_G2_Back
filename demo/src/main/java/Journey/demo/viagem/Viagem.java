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
    private Integer idMotorista;
    private Integer dataStart;
    private Integer dataEnd;
    private Integer origem;
    private Integer destino;
    private Integer horasTotal;
    private Integer precoTotal;
    
    private ViagemStatus status;


}
