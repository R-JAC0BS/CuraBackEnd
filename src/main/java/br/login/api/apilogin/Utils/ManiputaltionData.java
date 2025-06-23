package br.login.api.apilogin.Utils;

import br.login.api.apilogin.entitys.DadosEntity;
import br.login.api.apilogin.repositorys.ConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Optional;

public class ManiputaltionData implements ConvertData {

    static String qualidade;


    public static DadosEntity ConvertionData(String data) throws Exception {
        try {
            String json = data.replace("'", "\"");
            ObjectMapper mapper = new ObjectMapper();

            Map map = mapper.readValue(json, Map.class);

            Optional<String> uuid = Optional.ofNullable(map.get("uuid"))
                    .map(Object::toString);
            String temperatura = map.get("temperatura").toString();
            String umidade = map.get("umidade").toString();
            String luminosidade = map.get("luminosidade").toString();
            String ruido = map.get("ruido").toString();
            String qualidade_do_ar = map.get("qualidade_do_ar").toString();

            int qualidadeAr = Integer.parseInt(qualidade_do_ar);


            if (qualidadeAr < 200){
                qualidade = "Excelente";
            } else {
                qualidade = "Ruim";
            }

            return new DadosEntity(qualidade,ruido,umidade,temperatura,luminosidade,uuid.toString());
        } catch (Exception e){
            return null;
        }


    }


}
