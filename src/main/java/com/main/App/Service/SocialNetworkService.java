package com.main.App.Service;

import com.main.App.Models.Perfil;
import com.main.App.Models.SocialNetwork;
import com.main.App.Payload.Request.SocialNetworkRequest;
import com.main.App.Payload.Response.SocialNetworkResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.SocialNetworkRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SocialNetworkService {
    @Autowired
    private SocialNetworkRepository sr;
    @Autowired
    private PerfilRepository pr;

    public SocialNetworkResponse getSocialNetworkByPerfil(Long fk){
        SocialNetwork sw = sr.findSocialNetworkByPerfil(fk);
        //construção da resposta
        return SocialNetworkResponse.builder()
                .id(sw.getId())
                .instagram(sw.getInstagram())
                .linkedin(sw.getLinkedin())
                .telegram(sw.getTelegram())
                .build();
    }

    public SocialNetworkResponse create(SocialNetworkRequest req){
        Perfil perfil = pr.findPerfilByUser(req.getFkPerfil());
        //construção da social network
        SocialNetwork sw = SocialNetwork.builder()
                .instagram(req.getInstagram())
                .linkedin(req.getLinkedin())
                .telegram(req.getTelegram())
                .perfil(perfil)
                .build();
        //salva os dados no banco
        sw = sr.save(sw);
        //construção da resposta
        return SocialNetworkResponse.builder()
                .id(sw.getId())
                .instagram(sw.getInstagram())
                .linkedin(sw.getLinkedin())
                .telegram(sw.getTelegram())
                .build();
    }

    public SocialNetworkResponse update(Long id, SocialNetworkRequest req){
        SocialNetwork sw = sr.findById(id).get();
        //verifica a existencia do social network
        if(sw != null){
            //atualiza os dados
            sw.setInstagram(req.getInstagram());
            sw.setLinkedin(req.getLinkedin());
            sw.setTelegram(req.getTelegram());
            //salva as alterações no banco
            sw = sr.save(sw);
            //construção da resposta
            return SocialNetworkResponse.builder()
                    .id(sw.getId())
                    .instagram(sw.getInstagram())
                    .linkedin(sw.getLinkedin())
                    .telegram(sw.getTelegram())
                    .build();
        }
        return null;
    }
}
