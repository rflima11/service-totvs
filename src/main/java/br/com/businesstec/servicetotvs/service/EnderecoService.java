package br.com.businesstec.servicetotvs.service;

import br.com.businesstec.model.entities.Cliente;
import br.com.businesstec.model.entities.Endereco;

public interface EnderecoService {

    Endereco encontrarPeloIdCliente(Long idCliente);
}
