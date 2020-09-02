package domain.repositories;

import javax.persistence.criteria.CriteriaQuery;
import java.util.function.Predicate;

public class BusquedaCondicional {
    private Predicate condicionPredicado;
    private CriteriaQuery condicionCritero;

    public BusquedaCondicional(Predicate condicionPredicado, CriteriaQuery condicionCritero) {
        this.condicionPredicado = condicionPredicado;
        this.condicionCritero = condicionCritero;
    }

    public CriteriaQuery getCondicionCritero() {
        return condicionCritero;
    }

    public Predicate getCondicionPredicado() {
        return condicionPredicado;
    }
}
