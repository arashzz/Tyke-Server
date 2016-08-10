package io.tyke.models;

public class ForeignDocument<T extends TykeModel> {
	String id;
	T foreignDocument;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public T getForeignDocument() {
		return foreignDocument;
	}

	public void setForeignDocument(T foreignDocument) {
		this.foreignDocument = foreignDocument;
	}
	
	
}
