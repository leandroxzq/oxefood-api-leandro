package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("""
        SELECT p FROM Produto p
        WHERE (:codigo IS NULL OR p.codigo = :codigo)
        AND (:titulo IS NULL OR LOWER(p.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
        AND (:idCategoria IS NULL OR p.categoria.id = :idCategoria)
        ORDER BY p.titulo ASC
    """)
    List<Produto> filtrar(
        @Param("codigo") String codigo,
        @Param("titulo") String titulo,
        @Param("idCategoria") Long idCategoria);

}
