package Values;

public class Constans {
    public enum SignUpValues {
        USER("TesterUser1", "testermail2@gmail.com", "test1234"),
        USER2("TesterMargo","testermargo0@gmail.com", "test1234");

        private String userName;
        private String email;
        private String password;

        public String getUserName() {
            return this.userName;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.password;
        }

        SignUpValues(String userName, String email, String password) {
            this.userName = userName;
            this.email = email;
            this.password = password;
        }
    }
}
