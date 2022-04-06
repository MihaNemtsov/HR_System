package services;

import implementations.PostDaoImpl;
import models.Post;
import java.util.List;

public class PostService {
    private PostDaoImpl postDao = new PostDaoImpl();

    public PostService() {}

    public Post findPost(int id) {
        return postDao.findById(id);
    }

    public void savePost(Post post) {
        postDao.save(post);
    }

    public void deletePost(Post post) {
        postDao.delete(post);
    }

    public void updatePost(Post post) {
        postDao.update(post);
    }

    //public List<Post> findAllPosts() { return postDao.findAll(); }
}
