
package pe.edu.ulima.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GestionDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public void conectarse() {
        emf = Persistence.createEntityManagerFactory("LoginPU");
        em = emf.createEntityManager();
    }

    public void desconectarse() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
    
     public void registrarUsuario(Usuario usuario) {
        conectarse();

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        desconectarse();
    }
    
    public boolean validarLogueo(String username, String password) {

        conectarse();
        boolean estado = false;
        Query query = em.createQuery(
                "select user from Usuario user where user.username=:p1 and user.password=:p2");
        
        query.setParameter("p1", username);
        query.setParameter("p2", password);

        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        if (usuarios.size() == 0) {
            estado = false;
        } else {
            estado = true;
        }
        desconectarse();

        return estado;
    }
    
    //REGISTRAR CATEGORÍA:
    public void registrarCategoria(Categoria categoria) {
        conectarse();

        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

       desconectarse();
    }
    
    //REGISTRAR PROVEEDOR:
    public void registrarProveedor(Proveedor proveedor) {
        conectarse();

        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

        desconectarse();
    }
    
    //REGISTRAR PRODUCTO:
    public void registrarProducto(Producto producto) {
        conectarse();

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

        desconectarse();
    }

     public List<Categoria> obtenerCategorias() {
        conectarse();
        List<Categoria> categorias
                //Query query = em.createQuery(
                
                = em.createQuery("SELECT p FROM Categoria p").getResultList();
        desconectarse();
        return categorias;
    }
     
     public List<Producto> obtenerProductos() {
        conectarse();
        List<Producto> productos
                //Query query = em.createQuery(
                
                = em.createQuery("SELECT p FROM Producto p").getResultList();
        desconectarse();
        return productos;
    }
     
     public List<Producto> obtenerProductosActivos(String estado) {
        conectarse();
        List<Producto> productos=null;
                Query query = em.createQuery("select p from Producto p where p.estado=:p1");
                query.setParameter("p1", estado);

        desconectarse();
        return productos;
     }
        
          
          
     public List<Proveedor> obtenerProveedores() {
        conectarse();
        List<Proveedor> proveedores
                = em.createQuery("SELECT p FROM Proveedor p").getResultList();
        desconectarse();
        return proveedores;
    }
     
      public Categoria obtenerCategoriaSegunID(int idCategoria) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Categoria p where p.id_categoria =:p1");
        query.setParameter("p1", idCategoria);
        Categoria categoria = null;
        try {
            categoria = (Categoria) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return categoria;
    }
      
         
      public Categoria obtenerCatSegunIDProd(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_categoria from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Categoria categoria = null;
        try {
            categoria = (Categoria) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return categoria;
    }
      
      public Proveedor obtenerProSegunIDProd(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p.id_proveedor from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return proveedor;
    }
      
      public Producto obtenerProductoSegunID(int idProducto) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Producto p where p.id_producto =:p1");
        query.setParameter("p1", idProducto);
        Producto producto = null;
        try {
            producto = (Producto) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return producto;
    }
      
      public Proveedor obtenerProveedorSegunID(int idProveedor) {
        conectarse();

        //Persona persona = em.find(Persona.class, id);
        Query query = em.createQuery(
                "select p from Proveedor p where p.id_proveedor =:p1");
        query.setParameter("p1", idProveedor);
        Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

        desconectarse();

        return proveedor;
    }
      
            
      public void eliminarProductoSegunID(int idProducto){
        conectarse();
        
        Producto producto = em.find(Producto.class, idProducto);
        em.getTransaction().begin();
        em.remove(producto);
        em.getTransaction().commit();
        
        desconectarse();
    }
      
      
       public void modificarProducto(Producto producto){
       conectarse();
        
        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();
        
        desconectarse();
    }
      
}
