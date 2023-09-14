package code.alencar.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
    
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

     /** Método abaixo converte um objeto origem em outro objeto destino
      * @param - recebe por parâmetro o objeto origem e a classe do objeto destino
      * @return - retorna o objeto destino convertido 
     */
    public static <ORIGEM, DESTINO> DESTINO parseObject(ORIGEM origem, Class<DESTINO> destino) {
        return mapper.map(origem, destino);
    }

    /** Método abaixo converte uma lista de objeto origem em outra lista de objeto destino
      * @param - recebe por parâmetro a lista de objeto origem e a classe do objeto destino
      * @return - retorna a lista do objeto destino convertido 
     */
    public static <ORIGEM, DESTINO> List<DESTINO> parseListObject(List<ORIGEM> listOrigem, Class<DESTINO> destino) {
        List<DESTINO> objetosDestinos = new ArrayList<DESTINO>();
        for (ORIGEM o : listOrigem) {
            objetosDestinos.add(mapper.map(o, destino));
        }
        return objetosDestinos;
    }
}
