package com.main.App.Service;

import com.main.App.Models.Perfil;
import com.main.App.Models.User;
import com.main.App.Payload.Request.PerfilRequest;
import com.main.App.Payload.Response.PerfilResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PerfilService {
    @Autowired
    private PerfilRepository pr;
    @Autowired
    private UserRepository ur;

    public PerfilResponse getPerfilByUser(Long fk){
        Perfil perfil = pr.findPerfilByUser(fk);

        PerfilResponse response = PerfilResponse.builder()
                .id(perfil.getId())
                .biography(perfil.getBiography())
                .creationDate(perfil.getCreationDate())
                .fkUser(perfil.getUser().getId())
                .build();
        return response;
    }

    public PerfilResponse create(PerfilRequest request){
        User user = ur.findById(request.getFkUser()).get();
        //construção do novo perfil
        Perfil newPerfil = Perfil.builder()
                .biography(request.getBiography())
                .user(user).build();
        //salvando o perfil no banco
        Perfil perfilCreated = pr.save(newPerfil);
        //construção da resposta
        PerfilResponse response = PerfilResponse.builder()
                .id(perfilCreated.getId())
                .biography(perfilCreated.getBiography())
                .fkUser(perfilCreated.getUser().getId())
                .creationDate(perfilCreated.getCreationDate()).build();

        return response;
    }
}
