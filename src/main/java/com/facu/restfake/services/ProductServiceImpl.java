package com.facu.restfake.services;


import com.facu.restfake.entities.Producto;
import com.facu.restfake.repositories.BaseRepository;
import com.facu.restfake.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl  extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> buscarPorPrecioMayorA(Double precioMinimo) throws Exception{
        try {
            List<Producto> productosList = productoRepository.buscarPorPrecioMayorA(precioMinimo);
            return productosList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Producto> buscarPorPrecioEntre(Double precioMinimo, Double precioMaximo) throws Exception{
        try {
            List<Producto> productosList = productoRepository.buscarPorPrecioEntre(precioMinimo, precioMaximo);
            return productosList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
