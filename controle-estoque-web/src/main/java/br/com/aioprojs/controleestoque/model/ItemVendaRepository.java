package br.com.aioprojs.controleestoque.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends MongoRepository<ItemVenda, Long>{

}
