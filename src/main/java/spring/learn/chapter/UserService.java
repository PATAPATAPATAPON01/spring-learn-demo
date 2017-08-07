package spring.learn.chapter;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: za-lvjian
 * Date: 2017/8/7 14:19
 * DESC:
 */
@Validated
@Service
public class UserService {

    public @NotNull(message = "Null returns are not permitted")
    String getUser(@NotNull(message = "你传入null 这是不允许的") String uuid) {
        return null;
    }
}
