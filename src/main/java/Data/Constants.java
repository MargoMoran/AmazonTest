package Data;

public class Constants {
    public enum SignUpValues {
        USER1("TesterUser1", "testermail2@gmail.com", "test1234"),
        USER2("TesterMargo","testermargo0@gmail.com", "test1234"),
        USER3("TesterMargo","testermargo1@gmail.com", "test1234+");

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
        VALUE1("asus rog zephyrus"),
        VALUE2("xiaomi mi band 5"),
        VALUE3("iphone"),
        VALUE_OF_NUMBER(40),
        VALUE_OF_MAX_PRICE(100),
        VALUE_OF_MIN_PRICE(50);

        private String value;
        private int valueOfNumber;
        public String getValue(){return this.value;}

        SearchValue(String value){
            this.value = value;
        }
        SearchValue( int valueOfNumber){
            this.valueOfNumber = valueOfNumber;
        }

    }
}
