package com.main.App.Service;

import com.main.App.Models.Perfil;
import com.main.App.Models.Topic;
import com.main.App.Models.User;
import com.main.App.Payload.Request.PerfilRequest;
import com.main.App.Payload.Response.PerfilResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.TopicRepository;
import com.main.App.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PerfilService {
    @Autowired
    private PerfilRepository pr;
    @Autowired
    private UserRepository ur;
    @Autowired
    private TopicRepository tr;

    public PerfilResponse getPerfilByUser(Long fk){
        //busca pelo usuário
        Perfil perfil = pr.findPerfilByUser(fk);
        //recuperando os tópicos do perfil
        List topicsProjections = tr.findTopicsByPerfilId(perfil.getId());

        //construção da resposta
        PerfilResponse response = PerfilResponse.builder()
                .id(perfil.getId())
                .biography(perfil.getBiography())
                .topics(topicsProjections)
                .fkUser(perfil.getUser().getId())
                .creationDate(perfil.getCreationDate()).build();
        return response;
    }

    public PerfilResponse create(PerfilRequest request){
        //busca pelo usuário
        User user = ur.findById(request.getFkUser()).get();

        //construção do novo perfil
        Perfil newPerfil = Perfil.builder()
                .biography(request.getBiography())
                .user(user).build();

        //atribuição dos tópicos no perfil
        List<Topic> topics = new ArrayList<>();
        for(Long topicId : request.getTopics()) {
            Topic topic = tr.findById(topicId).get();
            if (topic != null) {
                topics.add(topic);
            }
        }
        newPerfil.setTopics(topics);

        //salvando o perfil no banco
        Perfil perfilCreated = pr.save(newPerfil);
        //recuperando os tópicos do perfil
        List topicsProjections = tr.findTopicsByPerfilId(perfilCreated.getId());

        //construção da resposta
        PerfilResponse response = PerfilResponse.builder()
                .id(perfilCreated.getId())
                .biography(perfilCreated.getBiography())
                .topics(topicsProjections)
                .fkUser(perfilCreated.getUser().getId())
                .creationDate(perfilCreated.getCreationDate()).build();

        return response;
    }

    public PerfilResponse updatePerfil(Long id, PerfilRequest request){
        Perfil perfil = pr.findById(id).get();

        if(perfil != null){
            perfil.setBiography(request.getBiography());
            //atribuição dos tópicos no perfil
            List<Topic> topics = new ArrayList<>();
            for(Long topicId : request.getTopics()) {
                Topic topic = tr.findById(topicId).get();
                if (topic != null) {
                    topics.add(topic);
                }
            }
            perfil.setTopics(topics);

            perfil = pr.save(perfil);

            //construção da resposta
            PerfilResponse response = PerfilResponse.builder()
                    .id(perfil.getId())
                    .biography(perfil.getBiography())
                    .topics(perfil.getTopics())
                    .fkUser(perfil.getUser().getId())
                    .creationDate(perfil.getCreationDate()).build();

            return response;
        }
        return null;
    }
}
