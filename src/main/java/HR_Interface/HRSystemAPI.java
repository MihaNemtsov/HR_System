package HR_Interface;

import DataBase.Departmens;
import DataBase.Mens;
import DataBase.Post;
import MailService.WorkToMailServer;

public class HRSystemAPI {
    void addDepartmentCard() {
        Departmens dp = new Departmens();
    }
    void getDepartmentCard() {}
    void deleteDepartmentCard() {}

    void addMenCard() {
        Mens men = new Mens();
    }
    void getMenCard() {}
    void deleteMenCard() {}

    void addPostCard() {
        Post post = new Post();
    }
    void getPostCard() {}
    void deletePostCard() {}

    void sendMail() {
        WorkToMailServer server = new WorkToMailServer();
    }
}
