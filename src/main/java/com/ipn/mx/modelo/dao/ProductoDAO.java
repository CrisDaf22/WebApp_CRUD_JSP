package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Producto;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductoDAO {
    private static ProductoDAO instancia;
    private final EntityManagerFactory emf;

    public ProductoDAO() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
    }
    
    public static ProductoDAO getInstance() {
        if (instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }
    
    public void insertarProducto(Producto p) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(p);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Producto leerProducto(Producto p) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        Producto pLeido = null;
        pLeido = (Producto) manager.find(Producto.class, p.getId());
        
        manager.getTransaction().commit();
        manager.close();
        
        return pLeido;
    }
    
    public void actualizarProducto(Producto p) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        manager.merge(p);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void eliminarProducto(Producto p) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        Producto referenciaP = (Producto) manager.getReference(Producto.class, p.getId());
        manager.remove(referenciaP);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List leerProductos() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        List<Producto> l = null;
        l = (List<Producto>) manager.createQuery("FROM Producto").getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return l;
    }
    
    public static void main(String[] args) {
        Producto p = new Producto();
        
        // INSERTAR
        /*
        p.setNombre("Lapices");
        p.setDescripcion("Caja de 3 lapices");
        p.setCantidad(15);
        
        FileInputStream img = null;
        try {
            img = new FileInputStream("D:\\Cristian\\Pictures\\Imagenes para proyectos\\lapiz.jpg");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            p.setImagen(convertirDatos(img));
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ProductoDAO dao = new ProductoDAO();
        dao.insertarProducto(p);
        System.out.println("Se insertó correctamente.");
        */
        
        // LECTURA UN ELEMENTO
        /*
        p.setId(1);
        
        ProductoDAO dao = new ProductoDAO();
        Producto p1 = null;
        p1 = dao.leerProducto(p);
        
        System.out.println(p1.getId());
        System.out.println(p1.getNombre());
        System.out.println(p1.getDescripcion());
        System.out.println(p1.getCantidad());
        
        if (p1.getImagen() != null) {
            System.out.println("Imagen asociada.");
        } else {
            System.out.println("No hay imagen asociada.");
        }
        */
        
        // ACTUALIZACIÓN
        /*
        p.setId(1);
        p.setNombre("Concha");
        p.setDescripcion("Pieza de pan dulce.");
        p.setCantidad(20);
        
        FileInputStream img = null;
        try {
            img = new FileInputStream("D:\\Cristian\\Pictures\\Imagenes para proyectos\\concha.png");
            p.setImagen(convertirDatos(img));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ProductoDAO dao = new ProductoDAO();
        dao.actualizarProducto(p);
        System.out.println("Se actualizó correctamente.");
        */
        
        // LEER TODO
        
        ProductoDAO dao = new ProductoDAO();
        List<Producto> lp = null;
        lp = dao.leerProductos();
        
        System.out.println(lp);
        
        
        // ELIMINAR
        /*
        p.setId(1);
        
        ProductoDAO dao = new ProductoDAO();
        dao.eliminarProducto(p);
        
        System.out.println(dao.leerProductos());
        */
    }
    
    // Función encargada de convertir los datos de la imágen a byte[]
    public static byte[] convertirDatos(InputStream is) throws IOException {
        // Para leer los datos en partes pequeñas
        byte[] buffer = new byte[1024];
        int bytesLeidos;
        
        // Arreglo donde se almacenarán los datos de la imágen
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((bytesLeidos = is.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesLeidos);
        }
        byte[] datos = baos.toByteArray();
        
        return datos;
    } 
}
