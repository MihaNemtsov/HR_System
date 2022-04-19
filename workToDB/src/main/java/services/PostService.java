package services;

import implementations.PostDaoImpl;
import models.Post;
import send.MailService;

public class PostService {
    private PostDaoImpl postDao = new PostDaoImpl();
    public PostService() {}

    public Post findPost(int id) {
       return postDao.findById(id);
    }

    public void savePost(Post post) {
        postDao.save(post);
        new MailService().sendMail("hatulmadan144@gmail.com","Save post");
    }

    public void deletePost(Post post) {
        postDao.delete(post);
        new MailService().sendMail("hatulmadan144@gmail.com","Delete post with id = " + post.getId());
    }

    public void updatePost(Post post) {
        postDao.update(post);
        new MailService().sendMail("hatulmadan144@gmail.com","Update post with id = " + post.getId());
    }

    //public List<Post> findAllPosts() { return postDao.findAll(); }
}
