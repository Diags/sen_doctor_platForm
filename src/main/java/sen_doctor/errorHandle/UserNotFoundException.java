package sen_doctor.errorHandle;


import sen_doctor.model.Professionnal;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find customer id =  " + id);
    }

    public UserNotFoundException(Professionnal customer) {
        super("Could not find customer " + customer);
    }
    public UserNotFoundException(String user){
        super("Could not find user id {user} =  "+ user );
    }

}
