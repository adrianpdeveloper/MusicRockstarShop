package com.musicrockstar.musicrockstar.controladores;

import com.musicrockstar.musicrockstar.jpa.*;
import com.musicrockstar.musicrockstar.repositorio.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {
    @Autowired
    ProductoService productos;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PruebaService pruebas;
    @Autowired
    UsersService users;

    @Autowired
    OpinionService opiniones;

    @Autowired
    DireccionService direcciones;

    @Autowired
    TarjetaService tarjetas;

    @Autowired
    CarritoService carritos;
    @RequestMapping("/")
    public ModelAndView raiz(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            mv.setViewName("index");
            System.out.println(auth.getName());
            mv.addObject("correo",auth.getName());
            return mv;

        }catch(Exception e){
            mv.setViewName("index");
            return mv;
        }



    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/signup")
    public ModelAndView signup() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup");
        mv.addObject("user", new Users());
        return mv;
    }

    @RequestMapping("/productos")
    public ModelAndView productos() {
        ModelAndView mv = new ModelAndView();
        List<Producto> todosProductos = productos.listaProductos();
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("productos",todosProductos);
        mv.setViewName("productos");
        return mv;
    }

    @RequestMapping("/productosCuerda")
    public ModelAndView productosCuerda() {
        ModelAndView mv = new ModelAndView();

        List<Producto> todosProductos = productos.listaProductosTipo("cuerda");
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("productos",todosProductos);
        mv.setViewName("productosCuerda");
        System.out.println("HOLA");
        return mv;
    }

    @RequestMapping("/productosViento")
    public ModelAndView productosViento() {
        ModelAndView mv = new ModelAndView();

        List<Producto> todosProductos = productos.listaProductosTipo("viento");
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("productos",todosProductos);
        mv.setViewName("productosViento");
        return mv;
    }

    @RequestMapping("/productosPercusion")
    public ModelAndView productosPercusion() {
        ModelAndView mv = new ModelAndView();
        List<Producto> todosProductos = productos.listaProductosTipo("percusion");
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("productos",todosProductos);
        mv.setViewName("productosPercusion");
        System.out.println("HOLA");
        return mv;
    }

    @RequestMapping("/productosOtro")
    public ModelAndView productosOtros() {
        ModelAndView mv = new ModelAndView();
        List<Producto> todosProductos = productos.listaProductosTipo("otro");
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("productos",todosProductos);
        mv.setViewName("productosOtro");
        return mv;
    }
    @RequestMapping("/prueba")
    public ModelAndView pruebas() {
        ModelAndView mv = new ModelAndView();
        List<Prueba> todasPruebas = pruebas.listaPruebas();
        mv.addObject("prueba",todasPruebas);
        mv.setViewName("prueba");
        return mv;
    }

    @RequestMapping("/producto/{id}")
    public ModelAndView producto(@PathVariable int id, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        Optional<Producto> producto = productos.bbuscarProducto(id);
        Producto p;
        if (producto.isPresent()) p=producto.get(); else p=null;
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("producto",p);
        mv.setViewName("producto");
        mv.addObject("opinion", new Opinion());
        try{
            mv.addObject("correo",auth.getName());
        }catch (Exception e){

        }

        return mv;
    }

    @PostMapping("/crearOpinion")
    public String crearOpinion(@ModelAttribute Opinion opinion, Model model, Authentication auth, @RequestParam("idProducto") int idProducto) {
        Date myDate = new Date();

        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
        Optional<Producto> producto = productos.bbuscarProducto(idProducto);
        Opinion nuevaOpinion = new Opinion(opinion.getTexto(), opinion.getValoracion(), auth.getName(),fecha,producto.get());
        opiniones.guardarOpinion(nuevaOpinion);
        return "redirect:/producto/"+producto.get().getId();
    }


    @PostMapping("/registrarUser")
    public ModelAndView crearUser(@ModelAttribute Users user, Model model) {
        ModelAndView mv = new ModelAndView();
        Optional<Users> userBuscado = users.bbuscarUser(user.getUsername());
        String passwordEncriptado = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncriptado);
        if (userBuscado.isPresent()){
            System.out.println("El correo "+user.getUsername()+" ya esta utilizado");
        }else{
            users.registrarUser(user);
        }
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/direccion")
    public ModelAndView direccion(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try{
            List<Direccion> direccionEmail = direcciones.listaDireccionesEmail(auth.getName());
            mv.addObject("direcciones",direccionEmail);
        }catch (Exception e){
        }
        mv.setViewName("direccion");
        return mv;
    }

    @RequestMapping("/carrito")
    public ModelAndView carrito(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try{
            Carrito carrito = carritos.carritoEmail(auth.getName());
            mv.addObject("carrito",carrito);
            mv.addObject("productos", carrito.getProductos());
        }catch (Exception e){
        }
        mv.setViewName("carrito");
        return mv;
    }

    @RequestMapping("/tarjeta")
    public ModelAndView tarjeta(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        System.out.println(auth.getName());
        try{
            List<Tarjeta> tarjetaEmail = tarjetas.listaTarjetasEmail(auth.getName());
            mv.addObject("tarjetas",tarjetaEmail);
        }catch (Exception e){
        }

        mv.setViewName("tarjeta");
        return mv;
    }

    @RequestMapping("/crearDireccionPantalla")
    public ModelAndView crearDireccionPantalla(Authentication auth) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("crearDireccionPantalla");
        mv.addObject("direccion", new Direccion());
        return mv;
    }

    @RequestMapping("/crearTarjetaPantalla")
    public ModelAndView crearTarjetaPantalla(Authentication auth) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("crearTarjetaPantalla");
        mv.addObject("tarjeta", new Tarjeta());
        return mv;
    }

    @PostMapping("/crearDireccion")
    public ModelAndView crearOpinion(@ModelAttribute Direccion direccion, Model model, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        Direccion nuevaDireccion = new Direccion(direccion.getNombre(), direccion.getTelefono(), direccion.getCalle(), direccion.getNumero(), direccion.getCodigo(),direccion.getCiudad(), direccion.getProvincia(), direccion.getComentario(), auth.getName());
        direcciones.guardarDireccion(nuevaDireccion);
        try{
            List<Direccion> direccionEmail = direcciones.listaDireccionesEmail(auth.getName());
            mv.addObject("direcciones",direccionEmail);
        }catch (Exception e){
        }
        mv.setViewName("direccion");
        return mv;
    }

    @PostMapping("/crearTarjeta")
    public ModelAndView crearTarjeta(@ModelAttribute Tarjeta tarjeta, Model model, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        System.out.println(auth.getName());
        Tarjeta nuevaTarjeta = new Tarjeta(tarjeta.getNombre(), tarjeta.getNumero(),tarjeta.getCvc(), auth.getName());
        tarjetas.guardarTarjeta(nuevaTarjeta);

        try{
            List<Tarjeta> tarjetaEmail = tarjetas.listaTarjetasEmail(auth.getName());
            mv.addObject("tarjetas",tarjetaEmail);
        }catch (Exception e){
        }

        mv.setViewName("tarjeta");
        return mv;
    }

    @PostMapping("/borrarDireccion/{id}")
    public String borrarOpinion(@PathVariable int id, Authentication auth) {


        direcciones.borrarDireccion(id);
        List<Direccion> direccionEmail = direcciones.listaDireccionesEmail(auth.getName());

        return "redirect:/direccion";
    }

    @PostMapping("/borrarTarjeta/{id}")
    public String borrarTarjeta(@PathVariable int id, Authentication auth) {;

        tarjetas.borrarTarjeta(id);

        return "redirect:/tarjeta";
    }
    @PostMapping("/agregarCarrito")
    public String agregarCarrito(@RequestParam("producto") int id_Producto, Model model, Authentication auth) {

        int id = carritos.carritoEmail(auth.getName()).getId();
        System.out.println("id peticion");
        System.out.println(id_Producto);
        Optional<Producto> productoBuscado = productos.bbuscarProducto(id_Producto);
        Producto producto = productoBuscado.get();
        System.out.println("id pro");
        System.out.println(producto.getId());
        carritos.agregarCarritoEmail(auth.getName(), producto, id);

        return "redirect:/producto/"+id_Producto;
    }


}