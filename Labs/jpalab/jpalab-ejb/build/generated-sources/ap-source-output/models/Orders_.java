package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-20T01:15:39")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> total;
    public static volatile SingularAttribute<Orders, Client> clientId;
    public static volatile SingularAttribute<Orders, Integer> orderId;

}