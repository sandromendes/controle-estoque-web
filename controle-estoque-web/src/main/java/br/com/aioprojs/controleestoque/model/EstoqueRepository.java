package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, ObjectId>{

	@SuppressWarnings("unchecked")
	@Override
	Estoque save(Estoque entity);
}
