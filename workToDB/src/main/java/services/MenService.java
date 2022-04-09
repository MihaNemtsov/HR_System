package services;

import implementations.MensDaoImpl;
import models.Mens;
import send.MailService;

public class MenService {
    private MensDaoImpl menDao = new MensDaoImpl();

    public Mens findMen(int id) {
        return menDao.findById(id);
    }

    public void saveMen(Mens men) {
        menDao.save(men);
        new MailService().sendMail("example@gmail.com","Save men");
    }

    public void deleteMen(Mens men) {
        menDao.delete(men);
        new MailService().sendMail("example@gmail.com","Delete men with id = " + men.getId());
    }

    public void updateMen(Mens men) {
        menDao.update(men);
        new MailService().sendMail("example@gmail.com","Update men with id = " + men.getId());
    }
}
