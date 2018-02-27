package dhbw.lamazon.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserBean {
    @PersistenceContext(unitName = "MySQL")
    EntityManager em;
}
