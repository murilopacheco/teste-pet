package com.br.testepet.dto;

import java.util.Optional;

public class ResponseObject {
    public Object object;
    public String mensagem;

    public ResponseObject(Object object, String mensagem) {
        this.object = object;
        this.mensagem = mensagem;
    }
}
