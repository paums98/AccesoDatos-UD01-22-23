package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("institutos")
public class ListaInstitutos implements Serializable {
    @XStreamImplicit(itemFieldName = "instituto")
    private List<Instituto> lista;

    public ListaInstitutos(){}

    public ListaInstitutos(final List<Instituto> lista) {
        this.lista = lista;
    }

    public List<Instituto> getLista() {
        return this.lista;
    }

    public void setLista(final List<Instituto> lista) {
        this.lista = lista;
    }

    public void add(Instituto instituto){
        this.lista.add(instituto);
    }
}
