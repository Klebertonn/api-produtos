package io.github.klebertonn.apiprodutos.repository;

import io.github.klebertonn.apiprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);

}
