
// resource of type resource1 for simlicty gave a name to it

public class Resource1 implements Resource {
    private  String resourceName;
    private int id;

    Resource1(String resourceName,int id) {
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

     public String toString() {
       return resourceName;
     }
}
