package Journey.demo.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRespository viagemRespository;


    public Viagem saveViagem(Viagem Viagem) {
        return null;
    }

    public List<Viagem> listViagems() {
        return null;
    }

    public List<Viagem> listViagemsMotorista(Integer idMotorista) {
        return null;
    }

    public Viagem verifyViagem(Integer viagemId) {
        return null;
    }

    

}
