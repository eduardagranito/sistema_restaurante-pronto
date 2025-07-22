package br.com.tech4me.tech4pedido.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("restaurante")
public interface RestauranteClient<ItemCardapio> {

    @RequestMapping(method = RequestMethod.GET, value = "cardapio/{id}")
    ItemCardapio obterItem(@PathVariable String id);
}
