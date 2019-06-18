package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, ObjectId>{

	@Query(" { 'nome' : ?0 } ")
	Cliente buscarPorNome(String nome);

	@Query(" { 'email' : ?0 } ")
	Cliente buscarPorEmail(String email);

	@Query(" { 'documento' : ?0 } ")
	Cliente buscarPorDocumento(String documento);
}
