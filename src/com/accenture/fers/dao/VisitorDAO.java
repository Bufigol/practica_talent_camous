package com.accenture.fers.dao;

import java.util.HashSet;
import java.util.Set;

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
public class VisitorDAO implements IVisitorDAO{

	private static Set<Visitor> visitors = new HashSet<Visitor>();
	private static int lastID = 4;
	static {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(1);
		visitor.setUserName("rebeca");
		visitor.setPassword("qwerty");
		visitor.setFirstName("Rebeca");
		visitor.setLastName("Velasco");
		visitor.setEmail("rebeca@tecnilogica.com");
		visitor.setDni("22.222.222-J");
		visitor.setPhoneNumber("1122334455");
		visitor.setAddress("La Finca 1 Edificio 10");
		visitors.add(visitor);

		Visitor visitor2 = new Visitor();
		visitor2.setVisitorId(2);
		visitor2.setUserName("erobles");
		visitor2.setPassword("qwerty");
		visitor2.setFirstName("Emilio");
		visitor2.setLastName("Robles");
		visitor2.setEmail("erobles@tecnilogica.es");
		visitor2.setDni("11.111.111-H");
		visitor2.setPhoneNumber("+1122334455");
		visitor2.setAddress("La Finca 1 Edificio 2");
		visitors.add(visitor2);
		
		Visitor visitor3 = new Visitor();
		visitor3.setVisitorId(3);
		visitor3.setUserName("alozano");
		visitor3.setPassword("qwerty");
		visitor3.setFirstName("Ana");
		visitor3.setLastName("Lozano");
		visitor3.setEmail("alozano@accenture.com");
		visitor3.setDni("11.111.111-H");
		visitor3.setPhoneNumber("+112233445566");
		visitor3.setAddress("La Finca 1 Edificio 2");
		visitors.add(visitor3);
		
		Visitor visitor4 = new Visitor();
		visitor4.setVisitorId(4);
		visitor4.setUserName("rmartin");
		visitor4.setPassword("qwerty");
		visitor4.setFirstName("Rodrigo");
		visitor4.setLastName("Martín");
		visitor4.setEmail("rmartin@accenture.com");
		visitor4.setDni("11.111.111-H");
		visitor4.setPhoneNumber("+112233445577");
		visitor4.setAddress("Sant Cugat Parque Oficinas");
		visitors.add(visitor4);
	}

	public VisitorDAO() {

	}

	/**
	 * Añade un visitor si no existe
	 *
	 * @param Visitor
	 * 
	 * */
	public void save(Visitor visitor) {
		lastID++;
		visitor.setVisitorId(lastID);
		visitors.add(visitor);

	}

	/**
	 * Actualiza un Visitor
	 *
	 * @param Visitor
	 * @return int --> numero de registros afectados (1 o 0)
	 * 
	 */
	public int updateVisitor(Visitor visitor) {
		int update = 0;
		for (Visitor visitor2 : visitors) {
			if (visitor2.getVisitorId() == visitor.getVisitorId()){
				visitor2.setAddress(visitor.getAddress());
				visitor2.setEmail(visitor.getEmail());
				visitor2.setFirstName(visitor.getFirstName());
				visitor2.setLastName(visitor.getLastName());
				visitor2.setPhoneNumber(visitor.getPhoneNumber());
				visitor2.setDni(visitor.getDni());
				visitor2.setPassword(visitor.getPassword());
				visitor2.setRegisteredEvents(visitor.getRegisteredEvents());
				update = 1;
			}
		}
		return update;
	}

	/**
	 * 
	 * Busca un Visitor por userName
	 * @param userName
	 * @return Visitor
	 *
	 */
	public Visitor findByUserName(String userName) {
		Visitor visitorFound = null;
		for (Visitor visitorF : visitors) {
			if (visitorF.getUserName().equals(userName)){
				visitorFound = visitorF;
			}
		}
		return visitorFound;
	}
}
