import java.util.ArrayList;
import java.util.List;

// class user
public class User {
    String name;
    //each user will have list of role associted with it 
    List<Role> roleList= new ArrayList<>();
    User(String name) {

      this.name = name;
    }

    void addRole(Role role) {
        roleList.add(role);
    }
    
    String getName() {
        return name;
    }
    List<Role> getRoles() {
        return roleList;
    }
}
