
// resource of type resource2 for simlicty gave a name to it

public class Resource2 implements Resource {
    private  String resourceName;
    private int id;
    Resource2(String resourceName,int id) {
      this.resourceName = resourceName;
      this.id = id;
    }
    @Override
    public String getResourceName() {
        // TODO Auto-generated method stub
      return resourceName;
    }
     public int getId() {
         return id;
     }    
}
