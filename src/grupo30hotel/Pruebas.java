package grupo30hotel;

import AccesoDatos.TipoHabitacionData;
import AccesoDatos.HuespedData;
import AccesoDatos.HabitacionData;

import AccesoDatos.ReservaData;

import Entidades.CategoriaHabitacion;
import Entidades.Habitacion;
import Entidades.Huesped;

import Entidades.Reserva;
import Entidades.TipoHabitacion;

import java.time.LocalDate;
import java.time.Month;

public class Pruebas {

    public static void main(String[] args) {

////  CREAR HUSPED
//          Huespedj hues2 =new Huespedj("DNI"," 123457", "Pardo", "Felipe", "la plata 2309", 1123458, "felipe@hotmail.com", true, true);
//          HuespedDataj a=new HuespedDataj();
//          a.guardarHuesped(hues2);
////   ELIMINAR HUSPED
        //   a.eliminarHuesped(1);
////    MODIFICAR HUESPED
//      Huespedj hues1=new Huespedj("DNI"," 123456", "Lopez  ", "jose", "la plata 2345", 11234567, "jose@hotmail.com",true,true);
//      a.modificarHuesped(hues1);


///// CAMBIAR  PRECIO
//      TipoHabitacionData m = new TipoHabitacionData();
//      TipoHabitacion hab1= new TipoHabitacion(1, CategoriaCama.DOBLE, 4, 2, 70.000);
//      m.cambiarPrecio(hab1);



////BUSCAR TIPOHABITACION
//     TipoHabitacionData h= new TipoHabitacionData();
//     TipoHabitacion habitacionEncontrada=h.buscarTipoHabitacion(2);
//     if(habitacionEncontrada!=null){
//    System.out.println("CategoriaCama "+habitacionEncontrada.getCategoriaCama());
//    System.out.println("cantPersonasMax "+habitacionEncontrada.getCantPersonasMax());
//    System.out.println("cantCamas "+habitacionEncontrada.getCantCamas());
//    System.out.println("precioNoche "+habitacionEncontrada.getPrecioNoche());
//}
///CREAR HABITACION
//       HabitacionData hd= new HabitacionData();
//       Habitacion h1= new Habitacion(2,"doble", "39", "superlujo", true);
//       hd.guardarHabitacion(h1);
//       
////MODIFICAR HABITACION
//       HabitacionData hd = new HabitacionData();
//       Habitacion h= new Habitacion(27, 3, "sencilla", "78", "pruega juan", true);
//        hd.modificarHabitacion(h);
//ELIMINAR HABITACION
//          HabitacionData hd=new HabitacionData();
//          hd.eliminarHabitacion(5);
////CREAR TIPO HABITACION
//        TipoHabitacionData thd = new TipoHabitacionData();
 //       HabitacionData hd = new HabitacionData();
//
 //       TipoHabitacion hab1 = new TipoHabitacion(3, CategoriaCama.KING_SIZE, 2, 2, 50.000);
//        TipoHabitacion hab1 = new TipoHabitacion(1, CategoriaCama.DOBLE, 4, 2, 45.000);
//        Habitacion h = new Habitacion(hab1, CategoriaHabitacion.DOBLE, 11, "paseos", true);
//          hd.guardarHabitacion(h);
////ELIMINAR TIPO HABITACION
//        hd.eliminarHabitacion(30);
//        Habitacion h = new Habitacion(27,hab1, CategoriaHabitacion.DOBLE, 2, "sin desayuno", true);
////MODIFICAR TIPO HABITACION    
//        TipoHabitacionData thd = new TipoHabitacionData();       
//        TipoHabitacion hab1 = new TipoHabitacion(3, CategoriaCama.KING_SIZE, 2, 2, 50.000);     
//    }
////CREAR RESERVA
//          Reserva res1 = new Reserva(1 , 3, 1, LocalDate.of(2023, Month.OCTOBER, 17), LocalDate.of(2023, Month.OCTOBER, 17), LocalDate.of(2023, Month.OCTOBER ,18), "sencilla", true, 1);
//          Reserva res2 = new Reserva(4 , 23, 1, LocalDate.of(2023, Month.OCTOBER, 17), LocalDate.of(2023, Month.OCTOBER, 17), LocalDate.of(2023, Month.OCTOBER ,18), "sencilla", true, 2);
          ReservaData r=new ReservaData();
//          r.guardarReserva(res2);
//          
////  ELIMINAR RESERVA
 //        r.eliminarReserva(4);
////  MODIFICAR RESERVA
//           Reserva resv1=new Reserva(4,1 , 3, 2, LocalDate.of(2023, Month.OCTOBER, 16), LocalDate.of(2023, Month.OCTOBER, 18), LocalDate.of(2023, Month.OCTOBER ,19), "sencilla", true, 1);
//           r.modificarReserva(resv1);

////BUSCAR RESERVA
//        Reserva reservaEncontrada= r.buscarReserva(4);
//        if (reservaEncontrada !=null) {
//            System.out.println("reserva "+reservaEncontrada.getIdReserva());
//            System.out.println("Huesped "+reservaEncontrada.getIdHuesped());
//            System.out.println("Habitación "+reservaEncontrada.getIdHabitacion());
//            System.out.println("Cantidad de Personas "+reservaEncontrada.getCantPersonas());
//            System.out.println("fecha reserva "+reservaEncontrada.getFechaEntrada());
//            System.out.println("Fecha de ingreso "+reservaEncontrada.getFechaEntrada());
//            System.out.println("fecha salida "+reservaEncontrada.getFechaSalida());
//            System.out.println("estado "+reservaEncontrada.getEstado());
//            System.out.println("tipo reserva "+reservaEncontrada.getTipoReserva());
//            System.out.println("pago "+reservaEncontrada.getIdPago());
//            
//            } 
//////BUSCAR RESERVA POR HUESPED
//        Reserva reservaEncontrada= r.buscarReservaPorHuesped(1);
//        if (reservaEncontrada !=null) {
//            System.out.println("reserva "+reservaEncontrada.getIdReserva());
//            System.out.println("Huespedj "+reservaEncontrada.getIdHuesped());
//            System.out.println("Habitación "+reservaEncontrada.getIdHabitacion());
//            System.out.println("Cantidad de Personas "+reservaEncontrada.getCantPersonas());
//            System.out.println("fecha reserva "+reservaEncontrada.getFechaEntrada());
//            System.out.println("Fecha de ingreso "+reservaEncontrada.getFechaEntrada());
//            System.out.println("fecha salida "+reservaEncontrada.getFechaSalida());
//            System.out.println("estado "+reservaEncontrada.isEstado());
//            System.out.println("tipo reserva "+reservaEncontrada.getTipoReserva());
//            System.out.println("pago "+reservaEncontrada.getIdPago());
//            
//            } 

////CREAR PAGO
//            Pago pag1 = new Pago(2, LocalDate.of(2023, Month.OCTOBER, 17), true);
//            Pago pag2= new Pago(3, LocalDate.of(2023, Month.OCTOBER, 17), true);
//           PagoData p=new PagoData();
 //             p=new PagoData();
//            p.guardarPago(pag2);


////MODIFICAR PAGO
//   Pago pag1=new Pago(2,LocalDate.of(2023, Month.OCTOBER, 18), true);
//   p.modificarPago(pag1);

////ELIMINAR PAGO
//   p.eliminarPago(2);


////CALCULAR DIAS
//    r.calcularDias();
//    r.calcularDiaMesAño();
     
    } 
  
}