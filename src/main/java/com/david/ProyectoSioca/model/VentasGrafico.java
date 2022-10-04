package com.david.ProyectoSioca.model;

public class VentasGrafico {

    private long total;
    private java.lang.String mes;
    
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
    public VentasGrafico(String mes,long total) {
        super();
        this.total = total;
        this.mes = mes;
    }
    public VentasGrafico() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "VentasGrafico [total=" + total + ", Mes=" + mes + "]";
    }
    
    
}
