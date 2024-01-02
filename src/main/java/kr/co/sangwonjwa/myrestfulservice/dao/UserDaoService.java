package kr.co.sangwonjwa.myrestfulservice.dao;

import kr.co.sangwonjwa.myrestfulservice.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static{
        users.add(new User(1,"sangwon",new Date()));
        users.add(new User(2,"donguk",new Date()));
        users.add(new User(3, "sanghyun",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        if(user.getJoinDate() == null){
            user.setJoinDate(new Date());
        }
        users.add(user);

        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return  null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateById(int id, User newUser){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                if(newUser.getId() != null){
                    user.setId(newUser.getId());
                }
                if(newUser.getName() != null){
                    user.setName(newUser.getName());
                }
                return user;
            }
        }
        return null;
    }
}
