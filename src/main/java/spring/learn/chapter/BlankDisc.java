package spring.learn.chapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/7 15:31
 * DESC:
 */
@Service
@Data
public class BlankDisc {

    public String artist = "James ..";

    public String selectList() {
        return "霉霉++";
    }

    public int count = 100;


    private String email = "www";

    private String[] songs = {"penpen", "PAPPA", "dodo"};

    private songBean[] beans = {new songBean("pata"), new songBean("dodo")};

    @Data
    @AllArgsConstructor
    class songBean {


        private String artist;

        public void method1() {
            System.out.println("1===");
        }

    }
}
