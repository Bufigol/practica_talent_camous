package com.accenture.fers.dao;

import com.accenture.fers.entity.Visitor;

/**
 * Interface IVisitorDAO
 * No hay atributos en una Interface, podr�a haber constantes
 * Todos los m�todos son abstractos, por tanto todas las clases
 * que hereden de ella tendr�n que implementar todos los m�todos
 *
 * @author Tecnil�gica
 *
 * @version 1.0
 */
public interface IVisitorDAO {
	/**
	 *
	 * A�ade un Visitor
	 * @param visitor
	 *
	 */
	 void save(Visitor visitor);

	/**
	 * 
	 * Actualiza un Visitor
	 * @param visitor
	 * @return int --> n�mero de registros afectados (1 o 0)
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
