package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false, length = 20)
    private String nombre;
    
    @Column(nullable = false, length = 30)
    private String descripcion;
    
    @Column(nullable = false, precision = 2)
    private int cantidad;
    
    @Lob    // Indica que la columna debe ser BLOB
    @Column(nullable = false)
    private byte[] imagen;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Cantidad: ").append(cantidad).append("\n");
        
        if(imagen != null) {
            sb.append("Imagen: ").append("Si hay imagen asociada.").append("\n");
        } else {
            sb.append("Imagen: ").append("No hay imagen asociada.").append("\n");
        }
        
        return sb.toString();
    }
}
