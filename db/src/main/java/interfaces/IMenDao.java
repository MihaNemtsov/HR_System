package interfaces;

import models.Mens;

public interface IMenDao {
    public Mens findById(int id);

    public void save(Mens men);

    public void update(Mens men);

    public void delete(Mens men);

    //public Mens findUserByUsername(String username);
}
