package br.com.aioprojs.controleestoque.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class ProdutoCascadeListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;
    
    @Autowired
    private ProdutoRepository produtoRepository;
 
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) { 
        Object source = event.getSource(); 
        if ((source instanceof Produto) && (((Produto) source).getEstoque() != null)) { 
            mongoOperations.save(((Produto) source).getEstoque());
        }
    }
    
    @Override
    public void onAfterConvert(AfterConvertEvent<Object> event) { 
        Object source = event.getSource(); 
        if ((source instanceof Estoque)) { 
        	((Estoque) source).setProduto(produtoRepository.buscarPorIdEstoque(((Estoque) source).getId()));
        }
    }
}