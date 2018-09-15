package com.krobawksy.caramelitosapp.models;

public class Producto {

    private Integer codigo;
    private String nombre;
    private String preciounitario;
    private String imagenxs;
    private String imagendetalle;
    private String descripcion;
    private String stock;
    private String categoria_idcategoria;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(String preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getImagenxs() {
        return imagenxs;
    }

    public void setImagenxs(String imagenxs) {
        this.imagenxs = imagenxs;
    }

    public String getImagendetalle() {
        return imagendetalle;
    }

    public void setImagendetalle(String imagendetalle) {
        this.imagendetalle = imagendetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCategoria_idcategoria() {
        return categoria_idcategoria;
    }

    public void setCategoria_idcategoria(String categoria_idcategoria) {
        this.categoria_idcategoria = categoria_idcategoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", preciounitario='" + preciounitario + '\'' +
                ", imagenxs='" + imagenxs + '\'' +
                ", imagendetalle='" + imagendetalle + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock='" + stock + '\'' +
                ", categoria_idcategoria='" + categoria_idcategoria + '\'' +
                '}';
    }
}
