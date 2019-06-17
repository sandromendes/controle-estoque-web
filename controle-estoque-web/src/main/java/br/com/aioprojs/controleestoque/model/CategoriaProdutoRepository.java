package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProdutoRepository extends MongoRepository<CategoriaProduto, ObjectId>{

	@Query(" { 'nome' : ?0 } ")
    CategoriaProduto buscarPorNome(String nome);
}
