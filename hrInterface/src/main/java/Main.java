import models.Post;

public class Main {
    public static void main(String[] args) {

        PostService postService = new PostService();
        Post post = postService.findPost(1);

        System.out.println(post.getTitle());

    }
}
