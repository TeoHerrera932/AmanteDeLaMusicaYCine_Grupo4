package objetosServicio;

public class Periodo {
    private Fecha inicio;
    private Fecha fin;

    public Periodo() {
    }

    public Periodo(Fecha inicio, Fecha fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Fecha getInicio() {
        return inicio;
    }

    public void setInicio(Fecha inicio) {
        this.inicio = inicio;
    }

    public Fecha getFin() {
        return fin;
    }

    public void setFin(Fecha fin) {
        this.fin = fin;
    }

    public boolean contiene(Fecha fecha) {
        if (fecha == null || inicio == null || fin == null) {
            return false;
        }
        return !esPosterior(fecha, fin) && !esAnterior(fecha, inicio);
    }

    private boolean esAnterior(Fecha fecha, Fecha comparacion) {
        if (fecha.getAnio() != comparacion.getAnio()) {
            return fecha.getAnio() < comparacion.getAnio();
        }
        if (fecha.getMes() != comparacion.getMes()) {
            return fecha.getMes() < comparacion.getMes();
        }
        return fecha.getDia() < comparacion.getDia();
    }

    private boolean esPosterior(Fecha fecha, Fecha comparacion) {
        if (fecha.getAnio() != comparacion.getAnio()) {
            return fecha.getAnio() > comparacion.getAnio();
        }
        if (fecha.getMes() != comparacion.getMes()) {
            return fecha.getMes() > comparacion.getMes();
        }
        return fecha.getDia() > comparacion.getDia();
    }

    @Override
    public String toString() {
        return inicio + " - " + fin;
    }
}
