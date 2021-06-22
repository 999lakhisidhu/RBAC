import java.util.HashMap;
import java.util.Map;


// class that mocks the database functionality 

public class Database {
    static Map<String,User> dbUser= new HashMap<>();
    static  Map<String,Role> dbRole= new HashMap<>();
    static Map<String,Resource> dbResource= new HashMap<>();
    
    static  void addUser(User user)
    {
        dbUser.put(user.getName(),user);
    }

    static  User getUser(String name)
    {
         return dbUser.get(name);
    }

    static  void addRole(Role role) {
        dbRole.put(role.name,role);
    }

    static  Role getRole(String name) {
        return dbRole.get(name);
    }

    static void addResource(Resource resource) {
        dbResource.put(resource.getResourceName(),resource);
    }
    
    static Resource getResource(String name) {
         return dbResource.get(name);
    } 
}
