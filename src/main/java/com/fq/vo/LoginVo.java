package com.fq.vo;

import com.fq.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

/**
 * @Auther: 冯庆
 * @Date: 2018/8/7 14:34
 * @Description:
 */
public class LoginVo {

    @IsMobile
    private String mobile;

    @Length(min=32)
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
