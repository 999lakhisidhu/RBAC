import java.util.Scanner;

public class Utility {

    // this utility function create the new user
    static void  createUser(String name) {
        User usr= new User(name);
         Database.addUser(usr);
    }

    // this utilitu function creates the new role in the system
    static void createRole (String name) {
        Role role= new Role(name);
        Database.addRole(role);
    }
    
     // this utilitu function takes the input for the ACTION type
    static Action takeActionInput(Scanner sc) {
        System.out.println("Available actions  are: delete,read,write , please select one ");
        String inputAction =  sc.nextLine();
        Action actionEnum=Action.READ;

        if (inputAction.equals("delete")) {
           actionEnum=Action.DELETE;
        }

        else if (inputAction.equals("read")) {
            actionEnum=Action.READ;
         }

         
        else if (inputAction.equals("write")) {
            actionEnum=Action.WRITE;
         }
         return actionEnum;
    }

    // this function intilize the system
    static void init() {
        User adminUser= new User("admin");
        User usr1= new User("usr1");
        Database.addUser(adminUser);
        Database.addUser(usr1);
        
        // intilizing the Resources
        Resource resource1 = new  Resource1("pods", 1);
        Database.addResource(resource1);
        Resource resource2 = new  Resource1("service", 2);
        Database.addResource(resource2);
        
        //intializing the admin role  and assiging it to the admin user
        Role adminRole= new Role("admin");
        Database.addRole(adminRole);
        adminRole.addResource(resource1);
        adminRole.addAction(resource1,Action.DELETE);
        adminRole.addAction(resource1,Action.WRITE);
        adminRole.addResource(resource2);
        adminRole.addAction(resource2,Action.DELETE);
        adminRole.addAction(resource2,Action.WRITE);
        adminUser.addRole(adminRole);
  
        // intializing the normal role and assiging it to the normal user 
        Role usrRole= new Role("usrRole");
        Database.addRole(usrRole);
        usrRole.addResource(resource1);
        usr1.addRole(usrRole);
        //System.out.println(adminUser.roleList.toString());
       // System.out.println(usr1.roleList.toString());
      }

}
