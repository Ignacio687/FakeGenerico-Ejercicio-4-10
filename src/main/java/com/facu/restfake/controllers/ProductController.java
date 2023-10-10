package com.facu.restfake.controllers;

import com.facu.restfake.entities.Producto;
import com.facu.restfake.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "fakestoreapi.com/products")
public class ProductController extends BaseControllerImpl<Producto, ProductServiceImpl>{
    @GetMapping("/mayor")
    public ResponseEntity<?> buscarPorPrecioMenor(@RequestParam Double precioMinimo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorPrecioMayorA(precioMinimo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/entre")
    public ResponseEntity<?> buscarPorPrecioEntre(@RequestParam Double precioMinimo, @RequestParam Double precioMaximo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorPrecioEntre(precioMinimo, precioMaximo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
