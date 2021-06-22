import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// role class , it maintain the list of resource and action on them what can be performed on particular resource
// supported action are :READ,WRITE,DELETE

public class Role {
    String name; 
    Map<Resource,Set<Action> > roleMap; 

    Role(String name) {
        this.name = name;
        roleMap = new HashMap<>();
    }

    //this add the resource to role with default READ PERMISSION
    void addResource(Resource resource)
    {
        Set<Action> st= new HashSet<>();
        st.add(Action.READ);
        roleMap.put(resource, st);
    }

    // to delete the resource from the role 
    void delResource(Resource resource)
    {  
        roleMap.remove(resource);
    }

    // this add the ACTION for particular resource in a role
    void addAction(Resource resource ,Action action) {
        roleMap.get(resource).add(action);
    }

    // this delete the ACTION for particular resource in a role
    void delAction(Resource resource ,Action action) {
        roleMap.get(resource).remove(action);
    }

    public String toString() {
        return "role name is: "+name+" role details is : "+roleMap.toString();
    }
    
}
