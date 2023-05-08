package com.musicrockstar.musicrockstar.controladores;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.musicrockstar.musicrockstar.jpa.Opinion;
import com.musicrockstar.musicrockstar.jpa.Producto;
import com.musicrockstar.musicrockstar.jpa.Prueba;
import com.musicrockstar.musicrockstar.jpa.Users;
import com.musicrockstar.musicrockstar.repositorio.ProductoService;
import com.musicrockstar.musicrockstar.repositorio.PruebaService;
import com.musicrockstar.musicrockstar.repositorio.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
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
    @RequestMapping("/prueba")
    public ModelAndView pruebas() {
        ModelAndView mv = new ModelAndView();
        List<Prueba> todasPruebas = pruebas.listaPruebas();
        mv.addObject("prueba",todasPruebas);
        mv.setViewName("prueba");
        return mv;
    }

    @RequestMapping("/producto/{id}")
    public ModelAndView producto(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();

        Optional<Producto> producto = productos.bbuscarProducto(id);
        Producto p;
        if (producto.isPresent()) p=producto.get(); else p=null;
        //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
        mv.addObject("producto",p);
        mv.setViewName("producto");
        return mv;
    }

    @PostMapping("/crear-opinion")
    public String crearOpinion(@RequestParam("texto") String texto, @RequestParam("texto") String valoracion, Authentication auth) {
        // Aquí podrías crear y guardar la nueva opinión en la base de datos usando JPA
        // y luego redirigir al usuario a la página de detalles del instrumento usando su ID


        return "result";
    }

    @PostMapping("/registrarUser")
    public String crearUser(@ModelAttribute Users user, Model model) {
        ModelAndView mv = new ModelAndView();
        Optional<Users> userBuscado = users.bbuscarUser(user.getUsername());
        String passwordEncriptado = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncriptado);
        if (userBuscado.isPresent()){
            System.out.println("El correo "+user.getUsername()+" ya esta utilizado");
        }else{
            users.registrarUser(user);
        }
        return "resultado";
    }


}