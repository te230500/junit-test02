package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class UserTest {
    // TODO: テストケースを追加してください
    
    @Test
    public void 正常系_ユーザー管理コード登録参照() {
        User user = new User("U001");
        assertThat(user.getCode()).isEqualTo("U001");
    }
    
    @Test
    public void 正常系_名前登録参照() {
        User user = new User("U001");
        user.setName("山田太郎");
        assertThat(user.getName()).isEqualTo("山田太郎");
    }

    @Test
    public void 正常系_年齢登録参照() {
        User user = new User("U001");
        user.setAge(20);
        assertThat(user.getAge()).isEqualTo(20);
    }

    @Test
    public void 異常系_範囲外年齢登録() {
        User user = new User("U001");
        user.setAge(-1);
        assertThat(user.getAge()).isEqualTo(-1);
    }

    @Test
    public void 異常系_範囲外年齢が返される不具合() {
        User user = new User("U001");
        user.setAge(-1);

        assertThat(user.getAge()).isBetween(1, 199);
    }


}
