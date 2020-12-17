package com.accenture.fers.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.accenture.fers.entity.Visitor;

/**
 *
 * VisitortDAO
 *
 * @author Tecnilógica
 *
 * @version 1.0
 * 
 */
@Repository
public class VisitorDAO implements IVisitorDAO {
	@PersistenceContext
	EntityManager emanager;

	public VisitorDAO() {

	}

	/**
	 * Añade un visitor si no existe
	 *
	 * @param Visitor
	 * 
	 */
	@Override
	public void save(Visitor visitor) {
		emanager.persist(visitor);

	}

	/**
	 * Actualiza un Visitor
	 *
	 * @param Visitor
	 * @return int --> numero de registros afectados (1 o 0)
	 * 
	 */
	@Override
	public int updateVisitor(Visitor visitor) {
		// En el método updateVisitor  utilizar el método merge

		int update = 0;
		Visitor updated = emanager.merge(visitor);
		if (updated != null) {
			update = 1;
		}
		return update;
	}

	/**
	 * 
	 * Busca un Visitor por userName
	 * 
	 * @param userName
	 * @return Visitor
	 *
	 */
	@Override
	public Visitor findByUserName(String userName) {
		Visitor visitorFound = null;
		String consulta = "SELECT v FROM Visitor v WHERE v.userName = " + userName;
		Query queryConsulta = emanager.createQuery(consulta);
		visitorFound = (Visitor) queryConsulta.getSingleResult();
		return visitorFound;
	}
}
