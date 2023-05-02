package Journey.demo.viagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRespository extends JpaRepository<Viagem, String> {
}

