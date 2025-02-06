# SpringDemo_learn_xml_configuration
In this demo project i learn spring framework xml configuration

-->Configuration of Spring framework

First we need to initialize maven archetype project which is quick start project

Then you can add dependency which is 
    
    Spring Context
Dependency.

After that you can create the 
    
    spring.xml 
file into the class path which is main , in the main create a directory called resources.

then in your Class which have main method you can implement configure

  1.Create a public class 
    example : I create an Alien Class

    Alien Class--------    

    org.example

    public class Alien { 
        
        public Alien() {
            System.out.println("Object Created");
        }

        public void code() {
            System.out.println("Coding...");
        }
    }

After creating the Alien Class you can add the configuration to spring.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

        <bean id="alien" class="org.example.Alien" >
        // adding this, create an object when run the code using spring framework
        </bean>

    </beans>


then Main Class you can add ApplicationContext to create a container to objects and then spring create an object..

    Main Class--------
    
    org.example

    public class App {
        public static void main(String[] args) { 
            
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // in here it will create the objects which have configure in xml
            // when you have correctly add spring context dependency it automatically import the ApplicationContext
            
            Alien obj = context.getBean("alien",Alien.Class);
            obj.code();
            
        
        }
    }

then the scope of objects
--when we use scope in objects we have two types 
    
    1.Singleton -- when we create different objects in same class ,all variable values are same
    2.prototype -- but here when we create different objects it will work only object assign value..change for all objects;

Example ;

    Singleton Example

//

    Alien Class--------    

    org.example

    public class Alien { 
        
        int codeLine = 0;
        
        public Alien() {
            System.out.println("Object Created");
        }

        public void code() {
            System.out.println("Coding...");
        }
    }

//

spring.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

        <bean id="alien" class="org.example.Alien"  scope="singleton">
        // adding this, create an object when run the code using spring framework
        </bean>

    </beans>

//



    Main Class

    org.example
    
    public class App {
        public static void main(String[] args) { 
            
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // in here it will create the objects which have configure in xml
            // when you have correctly add spring context dependency it automatically import the ApplicationContext
            
            Alien obj = context.getBean("alien",Alien.Class);
            obj.codeLine = 20;
            System.out.println(obj.codeLine); //20
            
            Alien obj1 = context.getBean("alien",Alien.Class);
            System.out.println(obj1.codeLine); //20
            
            
        
        }
    }

it will give same value for both objects

    prototype

//

spring.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

        <bean id="alien" class="org.example.Alien"  scope="prototype">
        // adding this, create an object when run the code using spring framework
        </bean>

    </beans>

it will not give same value for variable.each objects must assign its own value

    Main Class

    org.example
    
    public class App {
        public static void main(String[] args) { 
            
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // in here it will create the objects which have configure in xml
            // when you have correctly add spring context dependency it automatically import the ApplicationContext
            
            Alien obj = context.getBean("alien",Alien.Class);
            obj.codeLine = 20;
            System.out.println(obj.codeLine); //20
            
            Alien obj1 = context.getBean("alien",Alien.Class);
            obj1.codeLine = 20;
            System.out.println(obj1.codeLine); //20
            
            
        
        }
    }

##Setter Injection

we can assign value when the object create for private varibale

    private int codeLine;

    public int getCodeLine() {
        return this.codeLine;
    }

    public void setCodeLine(int codeLine) { 
        this.codeLine = codeLine;
    }

now in spring.xml file we can configure both.
    1.for variable (primitive variable)
    2.when the class refer with another class object

1.for variable
    
in xml configuration we have bean and in bean we have property field

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="alien" class="org.example.Alien">
        <property name="codeLine" value="21">

        </property>
    </bean>

    </beans>

in property field it has name attribute and value attribute

---so simply you can add variable name for the name field and value for the value field..    

2.Ref attribute for object reference for the Alien Class

    for that first we need to create a varibale which type of laptop class

    private Laptop laptop;

    getters and setters..
    
spring.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="alien" class="org.example.Alien">
        <property name="codeLine" value="21">

        </property>
        <property name="laptop" ref="lap">

        </property>
    </bean>

    <bean id="lap" class="org.example.Laptop">

    </bean>

    </beans>

create a bean for Laptop class then use its id for Alien class bean property field named 
    
    ref=""


