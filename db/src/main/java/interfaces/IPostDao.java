package interfaces;

import models.Post;

public interface IPostDao {
    public Post findById(int id);

    public void save(Post post);

    public void update(Post post);

    public void delete(Post post);

    //public List<Post> findAll();
}

