package exceptions;

import lombok.Data;

@Data
public class Erro {
    private String classe;
    private String atributo;
    private String mensagem;
}
