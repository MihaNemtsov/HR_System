import implementations.PostDaoImpl;
import models.Post;

public class PostService {
    private PostDaoImpl postDao = new PostDaoImpl();

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
}
