package br.com.ifpe.oxefood.api.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import br.com.ifpe.oxefood.modelo.categoria.CategoriaService;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
public class CategoriaController {

   @Autowired
   private CategoriaService categoriaService;

   @PostMapping
   public ResponseEntity<Categoria> save(@RequestBody CategoriaRequest request) {

       Categoria categoria = categoriaService.save(request.build());
       return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Categoria> listarTodos() {

       return categoriaService.listarTodos();
   }
}
