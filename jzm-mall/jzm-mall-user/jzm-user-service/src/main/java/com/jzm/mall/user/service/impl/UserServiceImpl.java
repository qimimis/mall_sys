import com.jzm.mall.user.mapper.UserInfoMapper;
import com.jzm.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @Override
//    public UserLoginDTO login(UserInfoParam userInfo, String ip, String token) {
//        return null;
//    }
}