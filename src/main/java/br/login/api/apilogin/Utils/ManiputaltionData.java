package br.login.api.apilogin.Utils;

import br.login.api.apilogin.entitys.DadosEntity;
import br.login.api.apilogin.repositorys.ConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ManiputaltionData implements ConvertData {



    public static DadosEntity ConvertionData(String data) throws JsonProcessingException,Exception {
        String json = data.replace("'", "\"");
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(json, Map.class);
        String uuid = map.get("uuid").toString();
        String temperatura = map.get("temperatura").toString();
        String umidade = map.get("umidade").toString();
        String luminosidade = map.get("luminosidade").toString();
        String ruido = map.get("ruido").toString();
        String qualidade_do_ar = map.get("qualidade_do_ar").toString();

        if (uuid.length() < 10){
            throw new Exception("uuid invalido");
        }

        return new DadosEntity(qualidade_do_ar,ruido,umidade,temperatura,luminosidade,uuid);


    }


}
