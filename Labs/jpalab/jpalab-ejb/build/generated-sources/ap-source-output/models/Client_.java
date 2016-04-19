package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-20T01:15:39")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> fio;
    public static volatile SingularAttribute<Client, Integer> age;
    public static volatile ListAttribute<Client, Orders> ordersList;

}