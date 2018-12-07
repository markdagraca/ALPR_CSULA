package refrenceCode;
/**
 * @author Mark D
 *
 */
public interface dataBaseSearchModule {
    /**
     *
     * @return a profile of a person that matches the given parameters if one of the field is not
     * provided then the search shall not cross reference that field, if no person is found NULL
     * is returned
     */
    public Profile searchByName(String firstName, String middleName, String lastName, Address address );

    /**
     *
     * @return a profile of a person that matches the given parameters if state parameter field  is not
     * provided then the search shall not cross reference that field, if no person is found NULL
     * is returned
     *
     */
    public Vehicle searchByPlate(String plateNumber, States state);

    /**
     * Check if the program is connected the internet and database
     * @return
     */
    public boolean isConnected();
    public Profile searchByID(String id,States state);



}
