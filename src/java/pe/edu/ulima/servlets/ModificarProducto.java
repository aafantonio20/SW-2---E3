
package pe.edu.ulima.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.model.GestionDAO;
import pe.edu.ulima.model.Producto;


public class ModificarProducto extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        GestionDAO gestion = new GestionDAO();
        Producto productito = gestion.obtenerProductoSegunID(idProducto);

        RequestDispatcher rd = request.getRequestDispatcher("productoamodificar.jsp");
        request.setAttribute("producto", productito);
                
        rd.forward(request, response);
        
    }

    }
