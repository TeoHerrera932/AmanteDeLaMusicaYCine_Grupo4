package persistencia;
import java.util.ArrayList;

import excepciones.PersistenciaException;
import objetosNegocio.Medio;
public class Medios {
    protected Medio medios[];
    protected int numMedios = 0;

    public int indice(Medio medio){
        //Recorre linealmente
        for (int i = 0; i < numMedios; i++){
            //Si lo haya regresa a su indice
            if (medio.equals(medios[i]))return i;
        }
        //Si no, regres -1
        return -1;
    }
    public Medio obten(Medio medio){
        //Busca el indice del medio de clave
        int pos = indice(medio);
        //Si lo encuentra lo regres
        if (pos >= 0) return medios[pos];
        //si no, regresa null
        return null;
    }
    public ArrayList lista(){
        ArrayList lista = new ArrayList();
        for (int i = 0; i < numMedios; i++){
            lista.add(medios[i]);
        }
        return lista;
    }
    public void agrega(Medio medio) throws PersistenciaException{
        //si no hay espacio en el arreglo no se agrega
        if (numMedios >= medios.length) throw new PersistenciaException("Arreglo lleno");
        medios[numMedios] = medio;
        numMedios++;
    }
    public void actualiza(Medio medio) throws PersistenciaException{
        int pos;
        pos = indice(medio);
        if (pos < 0) throw new PersistenciaException("Medio inexistente");
        //Si lo hay , actualizalo
        medios[pos] = medio;
    }
    public void elimina(Medio medio) throws PersistenciaException{
        int pos;
        pos = indice(medio);
        if (pos < 0) throw new PersistenciaException("La Cancion o pelicula no existe" );
        //Si lo hay lo borra
        medios[pos] = null;
        empaca();
    }
    private void empaca(){
        for (int i = 0; i < numMedios; i++){
            if (medios[i] == null){
                for (int j = i; j < numMedios - 1; j++){
                    medios[j] = medios[j+1];
                }
                medios[numMedios - 1] = null;
                numMedios--;
                i--;
            }
        }
    }
}
