package com.aluracursos.excepcion;

public class ErrorConversionTiempoExcepcion extends RuntimeException {

    private String mensaje;

    public ErrorConversionTiempoExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
