package com.grupo6.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.grupo6.app.entidades.Reserva;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

//    @Query("SELECT r FROM Reserva r WHERE r.fechaIngreso =:i and r.fechaSalida =:s ")
//    List<Reserva> findAllFechasIngresoSalida (@Param("i") LocalDate inicio, @Param("s") LocalDate salida);

    @Query("SELECT r FROM Reserva r " +
            "WHERE (r.fechaIngreso < :i and r.fechaSalida > :i )" +
            "or (r.fechaIngreso < :s and r.fechaSalida > :s)" +
            "or(:i BETWEEN r.fechaIngreso and r.fechaSalida and :s BETWEEN r.fechaIngreso and r.fechaSalida)" +
            "or(r.fechaIngreso <= :i and r.fechaSalida >= :s)")
    List<Reserva> findAllFechasIngresoSalida (@Param("i") LocalDate inicio, @Param("s") LocalDate salida);

//    select id_habitacion
//    from reserva
//    where (fecha_ingreso < @fec_entrada and fecha_salida > @fec_entrada)
//    or (fecha_ingreso < @fec_salida and fecha_salida > @fec_salida)
//    or (@fec_entrada between fecha_ingreso and fecha_salida and @fec_salida between fecha_ingreso and fecha_salida)
//    or (fecha_ingreso <=@fec_entrada and fecha_salida >= @fec_salida)
}
