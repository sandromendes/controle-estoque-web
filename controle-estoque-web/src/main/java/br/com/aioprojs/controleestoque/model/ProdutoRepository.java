package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, ObjectId>{

	@Query(" { 'estoque.id' : ?0 } ")
	Produto buscarPorIdEstoque(ObjectId id);
}
