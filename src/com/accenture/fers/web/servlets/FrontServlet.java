package com.accenture.fers.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.fers.web.controllers.ChangePasswordController;
import com.accenture.fers.web.controllers.DisplayViewController;
import com.accenture.fers.web.controllers.EventRegController;
import com.accenture.fers.web.controllers.EventUnregController;
import com.accenture.fers.web.controllers.IController;
import com.accenture.fers.web.controllers.LogoutController;
import com.accenture.fers.web.controllers.NewVisitorController;
import com.accenture.fers.web.controllers.SearchVisitorController;
import com.accenture.fers.web.controllers.UpdateVisitorController;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("*.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 2. Creamos un mapa para recoger todos nuestras acciones y la instancia del
	// controller que le corresponde
	private Map<String, IController> controllers = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServlet() {
		super();
		// 3. Dar valores a nuestro mapa
		controllers.put("/searchVisitor.do", new SearchVisitorController());
		controllers.put("/newVisitor.do", new NewVisitorController());
		controllers.put("/updateVisitor.do", new UpdateVisitorController());
		controllers.put("/changePassword.do", new ChangePasswordController());
		controllers.put("/eventReg.do", new EventRegController());
		controllers.put("/eventUnreg.do", new EventUnregController());
		controllers.put("/displayView.do", new DisplayViewController());
		controllers.put("/logoutController.do", new LogoutController());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		// Implementar lo que queremos que haga el servlet

		// 1.Recogemos de la peticion la accion
		String url = request.getServletPath();

		// 2. Crear la instancia del controller para posteriormente llamar a su metodo
		// process
		IController controller = controllers.get(url); // new NewVisitorController()

		// 3. Llamamos al metodo process
		String view = controller.process(request, response);

		// 4. Elaborar la respuesta. Despachamos la orden a otro servlet, en nuestro
		// caso, a otro jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
