package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.entidades.Producto;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ControladorProductos", value = "/ControladorProductos")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 2,      // 2 MB
    maxRequestSize = 1024 * 1024 * 5   // 5 MB
)
public class ControladorProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        if(accion.equals("listarProductos")) {
            listarProductos(request, response);
        } else if(accion.equals("crearProducto")) {
            crearProducto(request, response);
        } else if (accion.equals("almacenarProducto")) {
            almacenarProducto(request, response);
        }
    }
    
    public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = ProductoDAO.getInstance();
        
        try {
            List<Producto> lProductos = dao.leerProductos();
        
            request.setAttribute("productos", lProductos);
            
            RequestDispatcher rd = request.getRequestDispatcher("/productos/listado_productos.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearProducto(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/productos/crear_producto.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void almacenarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("txt_idProducto"));
        String nombre = request.getParameter("txt_nombreProducto");
        String descripcion = request.getParameter("txt_descripcionProducto");
        int cantidad = Integer.parseInt(request.getParameter("txt_cantidadProducto"));
        
        Part parteArchivo = request.getPart("txt_imagenProducto");
        InputStream is = parteArchivo.getInputStream();
        
        byte[] imagen = getBytes(is);
        
        ProductoDAO dao = new ProductoDAO();
        Producto p = new Producto();
        if(id == 0) {
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setCantidad(cantidad);
            p.setImagen(imagen);
            
            dao.insertarProducto(p);
            
            listarProductos(request, response);
        }
    }
    
    public byte[] getBytes (InputStream is) throws IOException {
        byte[] buffer = new byte[is.available()];
        int bytesLeidos;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((bytesLeidos = is.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesLeidos);
        }
        byte[] datos = baos.toByteArray();
        
        return datos;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
