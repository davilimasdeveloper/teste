package br.com.home.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Stateless
public class AbstractBase {

    @PersistenceContext(unitName = "primary")
    public EntityManager manager;

}
