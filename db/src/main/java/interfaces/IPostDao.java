package interfaces;

import models.Post;

import java.util.List;

public interface IPostDao {
    public Post findById(int id);

    public void save(Post post);

    public void update(Post post);

    public void delete(Post post);

    //public List<Post> findAll();
}

