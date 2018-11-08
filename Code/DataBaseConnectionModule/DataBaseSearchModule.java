package connector;

public interface DataBaseSearchModule {

   public Profile searchByName(String firstName, String middleName, String lastName, Address address );

   public Profile searchByPlate(String plateNumber, String state);

   public boolean isConnected();
   public Profile searchByID(String id);
}
