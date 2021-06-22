import java.util.Scanner;

public class App {
     
    
   
    
    
    public static void main(String[] args) throws Exception {
        System.out.println("starting the RBAC application ");
        System.out.println("only adming user can edit the role and assign to other users ");
        Scanner sc = new Scanner(System.in);
        
        int action;
        int k;
        Utility.init();

        // setting the default user to admin 

        User usr=Database.getUser("admin");

        //interaction session to use the application 

        while(true) {
            System.out.println("running in  admin mode and press 1 for log in other user, other wise press 0 ");
            k=Integer.parseInt(sc.nextLine());
            if(k==1)
            {
                System.out.println("Available users are , please select with which user you want to continue: "+ Database.dbUser.keySet());
                String userName=sc.nextLine();
                usr = Database.getUser(userName);
               
                while(true) {
                    System.out.println("which action you want to perform\n 0: view role\n 1: Access Resoures\n 2: login other user");
                    action = Integer.parseInt(sc.nextLine());

                //this block tackles the view role case scenario     
                if(action==0) {
                    System.out.println("Assigned roles are : "+ usr.getRoles());
                }
                // this block tackles when user want to perform some action on particular resource
                else if (action==1) {
                    System.out.println("Available Resources are , please select one: "+Database.dbResource.keySet());
                    String resourceName =  sc.nextLine();
                    Resource resource = Database.getResource(resourceName);
                    Action actionEnum=Utility.takeActionInput(sc);
                     boolean usrCanPerform = Validator.canUsrPerformIt(usr, resource, actionEnum);

                     if (usrCanPerform) {
                        System.out.println("user can perform the required action");
                     }
                     else {
                        System.out.println("User can not perform the required action");
                     }
                }

                //this block is to switch to other user 
                else {
                    break;
                }
            }
            }

            //this block is when user is operating in admin mode 
            else {
                while(true) {
                
                    System.out.println("you are log in as admin user\n0: create user, \n1: create role,\n2: edit role, \n3: assign role \n4: login other user");
                    k=Integer.parseInt(sc.nextLine());

                    // to create the user 
                    if(k==0) {
                        System.out.println("Please provide the user name");
                        String userName=sc.nextLine();
                        Utility.createUser(userName);
                        System.out.println("user is created available users in the system are :"+Database.dbUser.keySet()); 
                    }

                    //to create the new role 
                    else if(k==1) {
                        System.out.println("Please provide the  role name");
                        String roleName=sc.nextLine();
                        Utility.createRole(roleName);
                        System.out.println("role is created available roles in the system are :"+Database.dbRole.keySet());

                    }
                    // to edit a particular role    
                    else if (k==2) {
                        System.out.println("Please select which role you want to edit  :"+Database.dbRole.keySet());
                        String roleName=sc.nextLine();
                        Role role=Database.getRole(roleName);
                        System.out.println("role details are as : "+role.toString());
                        System.out.println("Please provide resource you want to modify :"+Database.dbResource.entrySet());
                        String resourceName=sc.nextLine();
                        Resource resource =Database.getResource(resourceName);
                        System.out.println("Please press\n 0: to add this resource to role,\n 1: delete this resource from role, \n 2: modify the ACTION for this resource");
                        int  kk=Integer.parseInt(sc.nextLine());
                        if(kk==0)
                        {
                            role.addResource(resource);   
                        }
                        else if(kk==1) {
                            role.delResource(resource);
                        }
                        else {
                            System.out.println("Please press\n  0: for add  an ACTION and \n 1:for removing the ACTION"); 
                            int  kkk = Integer.parseInt(sc.nextLine());
                            Action actionEnum=Utility.takeActionInput(sc);
                            if (kkk==0) {
                               
                               role.addAction(resource, actionEnum);
                            }
                             else {
                               role.delAction(resource, actionEnum);
                             }

                        }
                        System.out.println(" After editing the role, role details are as : "+role.toString());
                    }

                    //to assign a particular  role to particular user
                    else if (k==3)
                    {
                        System.out.println("Please select which role you want to assign  :"+Database.dbRole.keySet());
                        String roleName=sc.nextLine();
                        Role role=Database.getRole(roleName);
                        System.out.println("Available users are , please select to which user you want to grant: "+ Database.dbUser.keySet());
                        String userName=sc.nextLine();
                        User usr1 = Database.getUser(userName);
                        usr1.addRole(role);
                        System.out.println("role is assigned to user successfully all roles for user are as :" +usr1.getRoles());

                    }

                    // for switch to other user
                    else {
                        break;
                    }
                } 
            }

        }
    }
}
