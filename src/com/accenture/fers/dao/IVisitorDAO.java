package com.accenture.fers.dao;

import com.accenture.fers.entity.Visitor;

/**
 * Interface IVisitorDAO
 * No hay atributos en una Interface, podría haber constantes
 * Todos los métodos son abstractos, por tanto todas las clases
 * que hereden de ella tendrán que implementar todos los métodos
 *
 * @author Tecnilógica
 *
 * @version 1.0
 */
public interface IVisitorDAO {
	/**
	 *
	 * Añade un Visitor
	 * @param visitor
	 *
	 */
	 void save(Visitor visitor);

	/**
	 * 
	 * Actualiza un Visitor
	 * @param visitor
	 * @return int --> número de registros afectados (1 o 0)
	 * 
	 */
	int updateVisitor(Visitor visitor);


	/**
	 * 
	 * Busca un Visitor por userName
	 * @param userName
	 * @return Visitor
	 *
	 */
	Visitor findByUserName(String userName);
}
