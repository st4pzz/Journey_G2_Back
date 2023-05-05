package Journey.demo.viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViagemService {

    @Autowired
    private ViagemRespository viagemRespository;

    public Viagem saveViagem(Viagem viagem) {
        return viagemRespository.save(viagem);
    }

    public List<Viagem> listViagems() {
        return viagemRespository.findAll();
    }

    public List<Viagem> listViagemsMotorista(Integer idMotorista) {
        List<Viagem> allViagems = viagemRespository.findAll();
        return allViagems.stream().filter(viagem -> viagem.getIdMotorista().equals(idMotorista)).collect(Collectors.toList());
    }

    public Viagem verifyViagem(Integer viagemId) {
        return null;
    }
}
