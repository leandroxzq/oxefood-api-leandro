package br.com.ifpe.oxefood.api.produto;

import java.math.BigDecimal;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private String nome;

   private String descricao;

   private BigDecimal valorUnitario;

   public Produto build() {

       return Produto.builder()
           .nome(nome)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .build();
   }
}
