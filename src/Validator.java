import java.util.List;
import java.util.Set;

//this class validate if a particular user can perform a ACTION on particular resource with its roles

public class Validator {
    
    static boolean canUsrPerformIt(User user,Resource resource, Action action) {
       List<Role> list =user.getRoles();
       for (Role role :list) {
           if( role.roleMap.containsKey(resource)) {
               Set<Action> st=role.roleMap.get(resource);
               if(st.contains(action)) {
                   return true;
               }
           }
       }
       return false;
    }
    
}
