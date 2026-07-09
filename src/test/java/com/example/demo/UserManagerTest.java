package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class UserManagerTest {

    @Test
    public void 正常系_UserManagerインスタンス同一() {
        UserManager manager1 = UserManager.getInstance();
        UserManager manager2 = UserManager.getInstance();
        assertThat(manager1).isSameAs(manager2);
    }

    @Test
    public void 正常系_userList登録参照() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();
        
        User user = new User("U001");
        manager.setUserToList(user);
        
        assertThat(manager.getUserList()).contains(user);
    }

    @Test
    public void 正常系_userMap登録参照() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();
        
        User user = new User("U001");
        manager.setUserToMap(user);
        
        assertThat(manager.getUserMap()).containsKeys("U001");
    }

    @Test
    public void 正常系_user全削除() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();
        
        User user = new User("U001");
        manager.setUserToList(user);
        manager.setUserToMap(user);
        
        manager.deleteAllUser();
        
        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }

    @Test
    public void 正常系_code指定user削除() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();
        
        User user1 = new User("U001");
        User user2 = new User("U002");
        manager.setUserToList(user1);
        manager.setUserToList(user2);
        manager.setUserToMap(user1);
        manager.setUserToMap(user2);
        
        manager.deleteUser("U001");
        
        assertThat(manager.getUserList()).doesNotContain(user1);
        assertThat(manager.getUserList()).contains(user2);
    }

    @Test
    public void 異常系_同コードのユーザーが削除されない不具合() {
        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();
        
        User user1 = new User("U001");
        User user2 = new User("U001");
        manager.setUserToList(user1);
        manager.setUserToList(user2);
        
        manager.deleteUser("U001");
        
        assertThat(manager.getUserList()).contains(user2);
    }
}
