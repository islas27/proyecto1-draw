package mx.uach.fing.almaceneshwrace.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.uach.fing.almaceneshwrace.models.Detail;
import mx.uach.fing.almaceneshwrace.models.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-17T02:11:00")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Date> dateOfDelivery;
    public static volatile ListAttribute<Order, Detail> details;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, Boolean> isApproved;
    public static volatile SingularAttribute<Order, User> customer;

}