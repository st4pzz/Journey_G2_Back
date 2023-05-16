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
        Viagem viagem = viagemRespository.findById(viagemId)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada com o ID: " + viagemId));
        viagem.setStatus(ViagemStatus.CONFIRMADO);
        return viagemRespository.save(viagem);
    }

    public Viagem cancelarViagem(Integer viagemId){
        Viagem viagem = viagemRespository.findById(viagemId)
        .orElseThrow(() -> new RuntimeException("Viagem não encontrada com o ID: " + viagemId));
        viagem.setStatus(ViagemStatus.FINALIZADO);
        viagemRespository.save(viagem);
        return viagem;
        
    }

    public Integer ViagemIdMotoristaEmProgresso(String idMotorista){
        List<Viagem> viagems = viagemRespository.findAll();
        List<Viagem> viagemMotoristaConfirmado = (viagems.stream().filter(viagem -> viagem.getIdMotorista().equals(idMotorista) && viagem.getStatus().equals(ViagemStatus.CONFIRMADO))).collect(Collectors.toList());
        if (viagemMotoristaConfirmado.isEmpty()) {
            throw new RuntimeException("Nenhuma viagem em progresso encontrada para o motorista com o ID: " + idMotorista);
        }
        return viagemMotoristaConfirmado.get(0).getId();
    }
}