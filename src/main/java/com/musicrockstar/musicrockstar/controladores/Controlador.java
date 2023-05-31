package com.musicrockstar.musicrockstar.controladores;

import com.musicrockstar.musicrockstar.jpa.*;
import com.musicrockstar.musicrockstar.repositorio.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    PedidoService pedidos;
    @RequestMapping("/")
    public ModelAndView raiz(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            mv.setViewName("index");
            System.out.println(auth.getName());
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
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
    public ModelAndView productos(Authentication auth) {
        ModelAndView mv = new ModelAndView();

        try {

            List<Producto> todosProductos = productos.listaProductos();
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Productos");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductos();
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Productos");
            mv.setViewName("productos");
            return mv;
        }
    }

    @RequestMapping("/productosOferta")
    public ModelAndView productosOferta(Authentication auth) {
        ModelAndView mv = new ModelAndView();

        try {

            List<Producto> todosProductos = productos.listaProductosOferta();
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Ofertas");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosOferta();
            //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Ofertas");
            mv.setViewName("productos");
            return mv;
        }
    }

    @RequestMapping("/productosCuerda")
    public ModelAndView productosCuerda(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            List<Producto> todosProductos = productos.listaProductosTipo("cuerda");
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Cuerda");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosTipo("cuerda");
            //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Cuerda");
            mv.setViewName("productos");
            return mv;
        }
    }


    @RequestMapping("/productosViento")
    public ModelAndView productosViento(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            List<Producto> todosProductos = productos.listaProductosTipo("viento");
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Viento");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosTipo("viento");
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Viento");
            mv.setViewName("productos");
            return mv;
        }
    }

    @RequestMapping("/productosPercusion")
    public ModelAndView productosPercusion(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            List<Producto> todosProductos = productos.listaProductosTipo("percusion");
            //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Percusion");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosTipo("percusion");
            //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Percusion");
            mv.setViewName("productos");
            return mv;
        }
    }

    @RequestMapping("/productosOtro")
    public ModelAndView productosOtros(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try {

            List<Producto> todosProductos = productos.listaProductosTipo("otro");
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Otros");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosTipo("otro");
            //List<Producto> todosProductos = Arrays.asList(new Producto(1, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10),new Producto(2, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10), new Producto(3, "Guitarra", "Cuerda", "cuerda.jpg", 3, 130.0f, 90, 10));
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Otros");
            mv.setViewName("productos");
            return mv;
        }
    }

    @GetMapping("/busquedaProducto")
    public ModelAndView procesarFormulario(@RequestParam("buscar") String buscar, Authentication auth) {
        ModelAndView mv = new ModelAndView();
        System.out.println("Valor de búsqueda: " + buscar);

        try {

            List<Producto> todosProductos = productos.listaProductosBusqueda(buscar);
            mv.addObject("productos",todosProductos);
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("productoBuscado","Resultados de '"+buscar+"'");
            mv.setViewName("productos");
            return mv;

        }catch(Exception e){
            List<Producto> todosProductos = productos.listaProductosBusqueda(buscar);
            mv.addObject("productos",todosProductos);
            mv.addObject("productoBuscado","Resultados de '"+buscar+"'");
            mv.setViewName("productos");
            return mv;
        }

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
        List<Opinion> opiniones = p.getOpiniones();
        int o = 0;
        for (int i = 0; i< opiniones.size(); i++){
            o = o + opiniones.get(i).getValoracion();
        }
        double mediaValoracion = (double) o / opiniones.size();
        long mediaRedondeada = Math.round(mediaValoracion);
        if (opiniones.size()!=0){
            mv.addObject("valoracionMedia", mediaRedondeada);
            mv.addObject("valoracionNumero", opiniones.size());
            System.out.println("Media = "+mediaRedondeada);
            System.out.println("Media 2= "+mediaValoracion);
        }
        mv.addObject("producto",p);
        mv.setViewName("producto");
        mv.addObject("opinion", new Opinion());
        try{
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
        }catch (Exception e){

        }

        return mv;
    }

    @PostMapping("/crearOpinion")
    public String crearOpinion(@ModelAttribute Opinion opinion, Model model, Authentication auth, @RequestParam("idProducto") int idProducto) {
        Date myDate = new Date();

        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(myDate);
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
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            if (direccionEmail.size() > 0) {
                mv.addObject("direcciones",direccionEmail);
            }

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
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            mv.addObject("carrito",carrito);
            if (carrito.getProductos().size()>0){
                mv.addObject("productos", carrito.getProductos());
                float precioTotal =0;
                for (int i=0; i<carrito.getProductos().size();i++){
                    precioTotal = precioTotal + carrito.getProductos().get(i).getPrecio();
                }
                precioTotal = (float) (Math.round(precioTotal * 100.0) / 100.0);
                System.out.println(precioTotal);
                mv.addObject("precioTotal", precioTotal);
                mv.addObject("numeroProductos", carrito.getProductos().size());
            }

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
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            List<Tarjeta> tarjetaEmail = tarjetas.listaTarjetasEmail(auth.getName());
            if (tarjetaEmail.size()>0){
                mv.addObject("tarjetas",tarjetaEmail);
            }

        }catch (Exception e){
        }

        mv.setViewName("tarjeta");
        return mv;
    }

    @RequestMapping("/pedidoLista")
    public ModelAndView pedidoLista(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        try{
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            List<Pedido> pedidoEmail = pedidos.pedidoEmail(auth.getName());
            Collections.reverse(pedidoEmail);
            if (pedidoEmail.size()>0){
                mv.addObject("pedidos",pedidoEmail);
            }
        }catch (Exception e){
        }
        mv.setViewName("pedidoLista");
        return mv;
    }

    @RequestMapping("/crearDireccionPantalla")
    public ModelAndView crearDireccionPantalla(Authentication auth) {
        ModelAndView mv = new ModelAndView();
        String correo = auth.getName();
        String[] correoSeparado = correo.split("@");
        String user = correoSeparado[0];
        mv.addObject("correo",user);
        mv.setViewName("crearDireccionPantalla");
        mv.addObject("direccion", new Direccion());
        return mv;
    }

    @RequestMapping("/crearTarjetaPantalla")
    public ModelAndView crearTarjetaPantalla(Authentication auth) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("crearTarjetaPantalla");
        String correo = auth.getName();
        String[] correoSeparado = correo.split("@");
        String user = correoSeparado[0];
        mv.addObject("correo",user);
        mv.addObject("tarjeta", new Tarjeta());
        return mv;
    }

    @PostMapping("/crearDireccion")
    public ModelAndView crearOpinion(@ModelAttribute Direccion direccion, Model model, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        Direccion nuevaDireccion = new Direccion(direccion.getNombre(), direccion.getTelefono(), direccion.getCalle(), direccion.getNumero(), direccion.getPuerta(), direccion.getCodigo(),direccion.getCiudad(), direccion.getProvincia(), direccion.getComentario(), auth.getName());
        direcciones.guardarDireccion(nuevaDireccion);
        try{
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
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
        Tarjeta nuevaTarjeta = new Tarjeta(tarjeta.getNombre(), tarjeta.getNumero(),tarjeta.getCvc(), auth.getName(), tarjeta.getFechaValidez());
        tarjetas.guardarTarjeta(nuevaTarjeta);

        try{
            String correo = auth.getName();
            String[] correoSeparado = correo.split("@");
            String user = correoSeparado[0];
            mv.addObject("correo",user);
            List<Direccion> direccionEmail = direcciones.listaDireccionesEmail(auth.getName());
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

    @PostMapping("/borrarPedido/{id}")
    public String borrarPedido(@PathVariable int id, Authentication auth) {


        pedidos.borrarPedido(id);
        List<Direccion> direccionEmail = direcciones.listaDireccionesEmail(auth.getName());

        return "redirect:/pedidoLista";
    }
    @PostMapping("/agregarCarrito")
    public String agregarCarrito(@RequestParam("producto") int id_Producto, Model model, Authentication auth) {

        int id = carritos.carritoEmail(auth.getName()).getId();
        System.out.println("id peticion");
        System.out.println(id_Producto);
        Optional<Producto> productoBuscado = productos.bbuscarProducto(id_Producto);
        Producto producto = productoBuscado.get();
        carritos.agregarCarritoEmail(auth.getName(), producto, id);

        return "redirect:/carrito";
    }

    @PostMapping("/pantallaCrearPedido/{id}")
    public ModelAndView crearPedido(@PathVariable int id, Model model, Authentication auth, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Producto> listaProductos= carritos.carritoEmail(auth.getName()).getProductos();
        List<Direccion> listaDirecciones = direcciones.listaDireccionesEmail(auth.getName());
        List<Tarjeta> listaTarjetas = tarjetas.listaTarjetasEmail(auth.getName());
        float precioTotal =0;
        for (int i=0; i<listaProductos.size();i++){
            precioTotal = precioTotal + listaProductos.get(i).getPrecio();
        }
        precioTotal = (float) (Math.round(precioTotal * 100.0) / 100.0);
        mv.addObject("precioTotal", precioTotal);
        String correo = auth.getName();
        String[] correoSeparado = correo.split("@");
        String user = correoSeparado[0];
        mv.addObject("correo",user);
        mv.addObject("pedido", new Pedido());
        mv.addObject("productosLista", listaProductos);
        if (listaDirecciones.size()>0){
            mv.addObject("direcciones", listaDirecciones);
        }
        if (listaTarjetas.size()>0){
            mv.addObject("tarjetas", listaTarjetas);
        }
        HttpSession session = request.getSession();
        session.setAttribute("listaProductos", listaProductos);
        System.out.println("Lista productos size ="+listaProductos.size());
        mv.setViewName("crearPedido");
        return mv;
    }

    @PostMapping("/ejecutarPedido")
    public ModelAndView ejecutarPedido(@ModelAttribute Pedido pedido, Model model, Authentication auth, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        float precioTotal= 0.0f;
        HttpSession session = request.getSession();
        List<Producto> productosListaSession = (List<Producto>) session.getAttribute("listaProductos");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<productosListaSession.size();i++){
            precioTotal = precioTotal + productosListaSession.get(i).getPrecio();
            sb.append(productosListaSession.get(i).getId()).append("/");
        }
        precioTotal = (float) (Math.round(precioTotal * 100.0) / 100.0);
        String id_productos = sb.toString().trim();
        System.out.println(productosListaSession.size());
        Date myDate = new Date();
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(myDate);

        Pedido pedidoFinal = new Pedido(auth.getName(), pedido.getDireccion(), pedido.getNumeroTarjeta(), fecha, precioTotal,id_productos);

        String correo = auth.getName();
        String[] correoSeparado = correo.split("@");
        String user = correoSeparado[0];
        mv.addObject("correo",user);
        pedidos.ejecutarPedido(pedidoFinal);
        carritos.vaciarCarritoEmail(auth.getName());
        mv.addObject("precioTotal",precioTotal);
        mv.addObject("productos",productosListaSession);
        productos.bajarInventario(productosListaSession);
        mv.setViewName("pedidoFinalizado");
        return mv;
    }

    @RequestMapping("/mostrarPedido/{id}")
    public ModelAndView mostrarPedido(@PathVariable int id, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        Optional<Pedido> pedido = pedidos.bbuscarPedido(id);
        Pedido p;
        if (pedido.isPresent()) p=pedido.get(); else p=null;
        mv.addObject("pedido",p);
        mv.setViewName("pedido");
        mv.addObject("opinion", new Opinion());
        String idString = p.getProductos();
        String[] ids = idString.split("/");

        List<Producto> productoList = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            String id_producto = ids[i];
            Optional<Producto> productoOptional= productos.bbuscarProducto(Integer.parseInt(id_producto));
            productoList.add(productoOptional.get());
        }

        String correo = auth.getName();
        String[] correoSeparado = correo.split("@");
        String user = correoSeparado[0];
        mv.addObject("correo",user);

        mv.addObject("productos",productoList);
        return mv;
    }
    @PostMapping("/borrarProductoPedido/{id}")
    public String borrarProductoCarrito(@PathVariable int id, Authentication auth) {

        try{
            Carrito carrito = carritos.carritoEmail(auth.getName());
            carritos.borrarElementoCarrito(carrito, id);

        }catch (Exception e){
        }
        return "redirect:/carrito";
    }

}