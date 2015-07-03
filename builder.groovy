public class UserBuilder {

    private String type = "default-type";
    private String code = "code_value";

    public static build(Closure closure){
        new UserBuilder.with(closure)
    }

}

UserBuilder().build {
    type "type-alt"
    code "code-alt"
}
