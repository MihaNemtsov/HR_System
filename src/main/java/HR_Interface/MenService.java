package HR_Interface;

import Models.Mens;
import dao.MenDao;

public class MenService {
    private MenDao menDao = new MenDao();

    public Mens findMen(int id) {
        return menDao.findById(id);
    }

    public void saveMen(Mens men) {
        menDao.save(men);
    }

    public void deleteMen(Mens men) {
        menDao.delete(men);
    }

    public void updateMen(Mens men) {
        menDao.update(men);
    }
}
