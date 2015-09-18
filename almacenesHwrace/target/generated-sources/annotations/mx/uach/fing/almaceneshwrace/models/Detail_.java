package mx.uach.fing.almaceneshwrace.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.uach.fing.almaceneshwrace.models.Order;
import mx.uach.fing.almaceneshwrace.models.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-18T00:10:19")
@StaticMetamodel(Detail.class)
public class Detail_ { 

    public static volatile SingularAttribute<Detail, Product> product;
    public static volatile SingularAttribute<Detail, Long> quantity;
    public static volatile SingularAttribute<Detail, Long> id;
    public static volatile SingularAttribute<Detail, Order> order;

}