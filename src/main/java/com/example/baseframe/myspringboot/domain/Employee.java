package com.example.baseframe.myspringboot.domain;

/**
 * @author 01378803
 * @date 2018/10/17 15:46
 * Description  :
 */
public class Employee {

    private Long id;
    private String userName;
    private String userPhone;
    private String jobNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }
}
