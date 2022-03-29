package HR_Interface;

import DBInterface.WorkDB;
import MailService.WorkToMailServer;

public class HRSystemAPI {
    void menu() {
        WorkDB db = new WorkDB();
    }
    void sendMail() {
        WorkToMailServer server = new WorkToMailServer();
    }
}
