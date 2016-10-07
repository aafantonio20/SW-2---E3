package pe.edu.ulima.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Prueba {

    public static void main(String[] args) {

        //Agregar Categoría:
        Categoria cat1 = new Categoria();
        Categoria cat2 = new Categoria();
        Categoria cat3 = new Categoria();
        Categoria cat4 = new Categoria();
        Categoria cat5 = new Categoria();

        cat1.setNombre("Vinos");
        cat2.setNombre("Pisco");
        cat3.setNombre("Platos");
        cat4.setNombre("Postres");
        cat5.setNombre("Shots");

        //Agregar Proveedor:
        Proveedor prov1 = new Proveedor();
        Proveedor prov2 = new Proveedor();
        Proveedor prov3 = new Proveedor();
        Proveedor prov4 = new Proveedor();
        Proveedor prov5 = new Proveedor();

        prov1.setNombre("PeruFarma");
        prov2.setNombre("Backus");
        prov3.setNombre("Alicor");
        prov4.setNombre("Gloria");
        prov5.setNombre("Nestle");
        

        //Agregando Producto:
        Producto prod1 = new Producto();
        Producto prod2 = new Producto();

        prod1.setId_categoria(cat1);
        prod1.setId_proveedor(prov1);
        prod1.setNombre("Navarro Correas");
        prod1.setPrecio(60.0f);
        prod1.setEstado("Activo");
        prod1.setPreparacion("A continuación mostraremos la preparación de este vino...");

        prod2.setId_categoria(cat2);
        prod2.setId_proveedor(prov2);
        prod2.setNombre("Picarones");
        prod2.setPrecio(8.0f);
        prod2.setEstado("Inactivo");
        prod2.setPreparacion("A continuación mostraremos la preparación de este postre...");

        //Creando Usuarios:
        Usuario usuario1 = new Usuario(1, "jcuro", "123456", "Juan Carlos", "Curo Choque", "123456789", "jcuro@gmail.com", 10);
        Usuario usuario2 = new Usuario(2, "aalfaro", "654321", "Antonio", "Alfaro", "123456789", "aalfaro@gmail.com", 10);

        //Creando Objeto DAO:
        GestionDAO daito = new GestionDAO();

        daito.conectarse();
        daito.registrarCategoria(cat1);
        daito.registrarProveedor(prov1);
        daito.registrarProducto(prod1);
        daito.registrarUsuario(usuario1);
        daito.registrarCategoria(cat2);
        daito.registrarProveedor(prov2);
        daito.registrarProducto(prod2);
        daito.registrarUsuario(usuario2);
        daito.registrarCategoria(cat3);
        daito.registrarProveedor(prov3);
        daito.registrarCategoria(cat4);
        daito.registrarProveedor(prov4);
        daito.registrarCategoria(cat5);
        daito.registrarProveedor(prov5);
        daito.desconectarse();


        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginPU");
        EntityManager em = emf.createEntityManager();

        Usuario usuario1 = new Usuario(1, "jcuro", "123456", "Juan Carlos", "Curo Choque", "123456789", "jcuro@gmail.com", 10);
        Usuario usuario2 = new Usuario(2, "aalfaro", "654321", "Antonio", "Alfaro", "123456789", "aalfaro@gmail.com", 10);
        
        em.getTransaction().begin();
        
        //¿Persist o merge?
        em.persist(usuario1);     
        em.persist(usuario2);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();

    }*/
    }
}
