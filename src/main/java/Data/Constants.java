package Data;

public class Constants {
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

    public enum SearchValue {
        VALUE1("asus rog zephtrus"),
        VALUE2("xiaomi mi band 5");

        private String value;
        public String getValue(){return this.value;}

        SearchValue(String value){
            this.value = value;
        }
    }
}
