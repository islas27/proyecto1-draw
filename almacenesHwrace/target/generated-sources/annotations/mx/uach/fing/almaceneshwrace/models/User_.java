package mx.uach.fing.almaceneshwrace.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.uach.fing.almaceneshwrace.models.Order;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-16T23:13:34")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Order> orders;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, Boolean> isAdmin;
    public static volatile SingularAttribute<User, String> email;

}