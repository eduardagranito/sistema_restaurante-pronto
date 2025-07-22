package br.com.tech4me.tech4pedido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4pedido.model.Pedido;
import br.com.tech4me.tech4pedido.repository.PedidoRepository;
import br.com.tech4me.tech4pedido.shared.PedidoCompletoDTO;
import br.com.tech4me.tech4pedido.shared.PedidoDTO;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public List<PedidoDTO> ObterTodos() {
        return repository.findAll()
            .stream()
            .map(p -> new PedidoDTO(p.getNomeCliente(), p.getItens()))
            .toList();
    }

    @Override
    public PedidoCompletoDTO ObterPorId(String id) {
        Pedido pedido = repository.findById(id).orElse(null);

        if (pedido != null) {
            return new PedidoCompletoDTO(pedido.getId(),
                pedido.getNomeCliente(),
                pedido.getItens(),
                pedido.getValorTotal(),
                pedido.getData());
        } else {
            return null;
        }
    }

    @Override
    public PedidoCompletoDTO Cadastrar(PedidoCompletoDTO pedido) {
        Pedido pedidoCadastro = new Pedido(pedido);
        repository.save(pedidoCadastro);

        return new PedidoCompletoDTO(pedidoCadastro.getId(),
            pedidoCadastro.getNomeCliente(),
            pedidoCadastro.getItens(),
            pedidoCadastro.getValorTotal(),
            pedidoCadastro.getData());
    }

    @Override
    public PedidoCompletoDTO Atualizar(String id, PedidoCompletoDTO pedido) {
        Pedido pedidoLocalizado = repository.findById(id).orElse(null);

        if (pedidoLocalizado != null) {
            Pedido pedidoAtualizacao = new Pedido(pedido);
            pedidoAtualizacao.setId(id);
            repository.save(pedidoAtualizacao);

            return new PedidoCompletoDTO(pedidoAtualizacao.getId(),
                pedidoAtualizacao.getNomeCliente(),
                pedidoAtualizacao.getItens(),
                pedidoAtualizacao.getValorTotal(),
                pedidoAtualizacao.getData());
        } else {
            return null;
        }
    }

    @Override
    public void Remover(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'Remover'");
    }

    @Override
    public Object obterTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }


}
