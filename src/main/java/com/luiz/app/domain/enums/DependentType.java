package com.luiz.app.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum DependentType {

	ESPOSA(0, "Esposa"), 
	FILHO(1, "Filho"), 
	SECRETARIA(2, "Secretária");

	private int cod;
	private String description;

	private DependentType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static DependentType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		// busca o código no objeto e retorna objeto se encontrar
		for (DependentType x : DependentType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		// se não foi encontrado, lança exception
		throw new IllegalArgumentException("ID inválido: " + cod);

	}
	
	public static Map<Integer, String> listEnumToMap() {

		Map<Integer, String> lista = new HashMap<>();
		
		for (DependentType x : DependentType.values()) {
			
			lista.put(x.getCod(), x.getDescription());
		}

		return lista;

	}

}
