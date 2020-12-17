package com.accenture.fers.dao;

import com.accenture.fers.entity.Visitor;

public interface IVisitorDAO {

	/**
	 * Añade un visitor si no existe
	 *
	 * @param Visitor
	 * 
	 */
	void save(Visitor visitor);

	/**
	 * Actualiza un Visitor
	 *
	 * @param Visitor
	 * @return int --> numero de registros afectados (1 o 0)
	 * 
	 */
	int updateVisitor(Visitor visitor);

	/**
	 * 
	 * Busca un Visitor por userName
	 * 
	 * @param userName
	 * @return Visitor
	 *
	 */
	Visitor findByUserName(String userName);

}