package Operation;

import DataBase_Enquiry.Enquiry_Employer_Account;
import DataBase_Enquiry.Enquiry_Staff_Account;

public class Compare_Information {
    String Input_Account;
    String Input_PassWord;
    String[] Account;
    String[] PassWord;
    boolean Flag = false;

    public Compare_Information(String s1, String s2, String s3) {
        this.Input_Account = s1;
        this.Input_PassWord = s2;
        if (s3 == "Employer") {
            Enquiry_Employer_Account Employer_Information = new Enquiry_Employer_Account();
            Account = Employer_Information.Get_Account();
            PassWord = Employer_Information.Get_PassWord();
        } else if (s3 == "Staff") {
            Enquiry_Staff_Account Staff_Information = new Enquiry_Staff_Account();
            Account = Staff_Information.Get_Account();
            PassWord = Staff_Information.Get_PassWord();
        }
    }

    public boolean Account_State() {
        for (int i = 0; i < Account.length; i++) {
            if (Account[i].equals(Input_Account) && PassWord[i].equals(Input_PassWord)) {
                Flag = true;
            }
        }
        return Flag;
    }
}
