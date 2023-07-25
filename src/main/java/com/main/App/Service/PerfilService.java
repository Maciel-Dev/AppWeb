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
        return PerfilResponse.builder()
                .id(perfil.getId())
                .biography(perfil.getBiography())
//                .topics(topicsProjections)
                .fkUser(perfil.getUser().getId())
                .creationDate(perfil.getCreationDate()).build();
    }

    public PerfilResponse create(PerfilRequest request){
        //busca pelo usuário
        User user = ur.findById(request.getFkUser()).get();

        ur.setFirstLogin(user.getId());

        Perfil perfil = Perfil.builder()
                .id(request.getFkUser())
                .user(user)
                .gender(request.getGender())
                .biography(request.getBiography())
                .build();

        pr.save(perfil);

        return PerfilResponse.builder().id(perfil.getId()).biography(perfil.getBiography()).build();
    }

//    public PerfilResponse updatePerfil(Long id, PerfilRequest request){
//        Perfil perfil = pr.findById(id).get();
//
//        if(perfil != null){
//            perfil.setBiography(request.getBiography());
//            //atribuição dos tópicos no perfil
//            List<Topic> topics = new ArrayList<>();
//            for(Long topicId : request.getTopics()) {
//                Topic topic = tr.findById(topicId).get();
//                if (topic != null) {
//                    topics.add(topic);
//                }
//            }
//            perfil.setTopics(topics);
//
//            perfil = pr.save(perfil);
//
//            //construção da resposta
//            PerfilResponse response = PerfilResponse.builder()
//                    .id(perfil.getId())
//                    .biography(perfil.getBiography())
//                    .topics(perfil.getTopics())
//                    .fkUser(perfil.getUser().getId())
//                    .creationDate(perfil.getCreationDate()).build();
//
//            return response;
//        }
//        return null;
//    }
}
