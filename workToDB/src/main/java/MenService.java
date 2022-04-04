import implementations.MensDaoImpl;
import models.Mens;

public class MenService {
    private MensDaoImpl menDao = new MensDaoImpl();

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
