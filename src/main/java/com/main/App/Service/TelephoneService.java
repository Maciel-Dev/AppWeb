package com.main.App.Service;

import com.main.App.Models.Perfil;
import com.main.App.Models.Telephone;
import com.main.App.Payload.Request.TelephoneRequest;
import com.main.App.Payload.Response.TelephoneResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.TelephoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TelephoneService {
    @Autowired
    private TelephoneRepository tp;
    @Autowired
    private PerfilRepository pr;

    public TelephoneResponse create(TelephoneRequest req){
        //busca pelo perfil
        Perfil perfil = pr.findPerfilByUser(req.getIdUser());
        //construção do novo telephone
        Telephone telephone = Telephone.builder()
                .ddd(req.getDdd())
                .number(req.getNumber())
                .perfil(perfil)
                .build();
        //salvando o telefone no banco
        telephone = tp.save(telephone);
        //construção da resposta
        TelephoneResponse res = TelephoneResponse.builder()
                .id(telephone.getId())
                .ddd(telephone.getDdd())
                .number(telephone.getNumber())
                .build();

        return res;
    }

    public TelephoneResponse update(Long id, TelephoneRequest req){
        Telephone telephone = tp.findById(id).get();
        //verifica a existencia do telefone
        if(telephone != null){
            //atualização do telefone
            telephone.setDdd(req.getDdd());
            telephone.setNumber(req.getNumber());
            //salva as alterações no banco
            telephone = tp.save(telephone);
            //construção da resposta
            TelephoneResponse res = TelephoneResponse.builder()
                    .id(telephone.getId())
                    .ddd(telephone.getDdd())
                    .number(telephone.getNumber())
                    .build();
            return res;
        }
        return null;
    }

    public List<TelephoneResponse> getPhonesByPerfil(Long fk) {
       List<Telephone> phones = tp.findPhonesByPerfil(fk);

       List<TelephoneResponse> res = new ArrayList<>();
        //Converte para a lista de resposta
        for (Telephone phone : phones) {
            TelephoneResponse response = TelephoneResponse.builder()
                    .id(phone.getId())
                    .ddd(phone.getDdd())
                    .number(phone.getNumber())
                    .build();

            res.add(response);
        }
        return res;
    }
}
