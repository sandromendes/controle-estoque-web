package br.com.aioprojs.controleestoque.model;

import java.util.Date;

public abstract class AbstractModel {

    protected Date createdDate;
    protected Date lastModifiedDate;
    
    public AbstractModel() {
		super();
	}

	public AbstractModel(Date createdDate, Date lastModifiedDate) {
		super();
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
    
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate() {
		if(this.createdDate == null) this.createdDate = new Date();
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate() {
		this.lastModifiedDate = new Date();
	}
}
