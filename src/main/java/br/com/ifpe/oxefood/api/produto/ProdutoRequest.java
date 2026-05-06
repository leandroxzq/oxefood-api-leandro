package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.categoria.Categoria;
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

   private String codigo;

   private String titulo;

   private String descricao;

   private Double valorUnitario;

   private Integer tempoEntregaMinimo;

   private Integer tempoEntregaMaximo;

   private Long idCategoria;

   public Produto build() {

       Categoria categoria = null;

       if (idCategoria != null) {
           categoria = new Categoria();
           categoria.setId(idCategoria);
       }

       return Produto.builder()
           .codigo(codigo)
           .titulo(titulo)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .tempoEntregaMinimo(tempoEntregaMinimo)
           .tempoEntregaMaximo(tempoEntregaMaximo)
           .categoria(categoria)
           .build();
   }
}
