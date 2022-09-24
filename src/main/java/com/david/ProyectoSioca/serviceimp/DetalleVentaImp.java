package com.david.ProyectoSioca.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.ProyectoSioca.model.DetalleVenta;
import com.david.ProyectoSioca.model.Producto;
import com.david.ProyectoSioca.model.Venta;
import com.david.ProyectoSioca.repository.DetalleVentaRepository;
import com.david.ProyectoSioca.repository.ProductoRepository;
import com.david.ProyectoSioca.repository.VentaRepository;
import com.david.ProyectoSioca.service.DetalleVentaService;

@Component
public class DetalleVentaImp implements DetalleVentaService {

	@Autowired(required = true)
	private DetalleVentaRepository repositorio;

	@Autowired(required = true)
	private ProductoRepository repositorioProducto;

	@Autowired(required = true)
	private VentaRepository repositorioVenta;

	@Override
	public List<DetalleVenta> encontrarTodosLosDetalles() {
		return repositorio.findAll();
	}

	@Override
	public List<DetalleVenta> insertarDetalles(List<DetalleVenta> lista) {
		long sumatotal = 0;
		Producto producto = new Producto();
		Venta venta = new Venta();
		for (DetalleVenta dv : lista) {
			producto = repositorioProducto.findById(dv.getIdproducto().getId_producto());
			producto.setQuantity(producto.getQuantity() - dv.getCantidad());
			repositorioProducto.save(producto);
			sumatotal = sumatotal + dv.getSubtotal();
			venta = repositorioVenta.findById(dv.getIdventa().getId());
		}
		venta.setPrecio(sumatotal);
		repositorioVenta.save(venta);
		return repositorio.saveAll(lista);
	}

	@Override
	public DetalleVenta encontrarDetallePorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public DetalleVenta editarDetalle(DetalleVenta dv) {
		int diferencias=0;
		long sumatotal = 0;
		Producto producto = new Producto();
		Venta venta = new Venta();
		DetalleVenta dv2 = new DetalleVenta();
		producto = repositorioProducto.findById(dv.getIdproducto().getId_producto());
		if(dv2.getCantidad()>dv.getCantidad()) {
			diferencias=dv2.getCantidad()-dv.getCantidad();
			producto.setQuantity(producto.getQuantity() + diferencias);
		}else if(dv2.getCantidad()<dv.getCantidad()) {
			diferencias=dv.getCantidad()-dv2.getCantidad();
			producto.setQuantity(producto.getQuantity() - diferencias);
		}	
		dv2 = repositorio.save(dv);
		List<DetalleVenta> lista = new ArrayList<>();
		lista = repositorio.findAll();
		for (DetalleVenta dv3 : lista) {
			sumatotal = sumatotal + dv3.getSubtotal();
		}
		venta = repositorioVenta.findById(dv.getIdventa().getId());
		venta.setPrecio(sumatotal);
		repositorioProducto.save(producto);
		repositorioVenta.save(venta);
		return dv2;
	}

	@Override
	public DetalleVenta eliminarPorId(int id) {
		return repositorio.deleteById(id);
	}

	@Override
	public List<DetalleVenta> encontrarDetallesPorFactura(int id) {
		return repositorio.encontrarDetallesPorVenta(id);
	}
}
