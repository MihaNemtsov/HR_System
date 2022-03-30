package HR_Interface;

import Models.Post;
import dao.PostDao;

public class PostService {
    private PostDao postDao = new PostDao();

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
