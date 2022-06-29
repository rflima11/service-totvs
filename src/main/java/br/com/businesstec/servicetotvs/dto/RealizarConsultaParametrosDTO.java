package br.com.businesstec.servicetotvs.dto;

import br.com.businesstec.servicetotvs.enums.ConsultaParametrosEnum;
import br.com.businesstec.servicetotvs.enums.EnumParametersSoap;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RealizarConsultaParametrosDTO {

    private  String codSetenca;
    private final Integer codColigada;
    private final String codSistema;
    private Map<EnumParametersSoap, String> params;

    public RealizarConsultaParametrosDTO(String codSetenca) {
        this.codSistema =  ConsultaParametrosEnum.COD_SISTEMA.getValue();
        this.codColigada = Integer.valueOf(ConsultaParametrosEnum.COD_COLIGADA.getValue());
        this.codSetenca = codSetenca;
        this.params = new HashMap<EnumParametersSoap, String>();
    }

    public RealizarConsultaParametrosDTO(String codSetenca, Map<EnumParametersSoap, String> params) {
        this.codSistema =  ConsultaParametrosEnum.COD_SISTEMA.getValue();
        this.codColigada = Integer.valueOf(ConsultaParametrosEnum.COD_COLIGADA.getValue());
        this.codSetenca = codSetenca;
        this.params = params;
    }

    public String getCodSetenca() {
        return codSetenca;
    }

    public void setCodSetenca(String codSetenca) {
        this.codSetenca = codSetenca;
    }

    public Integer getCodColigada() {
        return codColigada;
    }

    public String getCodSistema() {
        return codSistema;
    }

    public Map<EnumParametersSoap, String> adicionarParametro(EnumParametersSoap chaveParametro, String valor) {
        this.params.put(chaveParametro, valor);
        return this.params;
    }

    public String getParameters() {
        String parametros = "";
        var parameters = params.entrySet()
                .stream()
                .sorted(Map.Entry.<EnumParametersSoap, String>comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<EnumParametersSoap, String> entry : parameters.entrySet()) {
            parametros += entry.getKey().getValue().concat(entry.getValue()).concat(";");
        }
        return parametros;
    }

}
