package com.yatong.exam.service;

public interface LoginService {

    /**
     * @Author HouYi
     * @Date 2023/12/20 16:52
     * @Description 登录验证
     * @Param [username, password, code, uuid]
     * @Return java.lang.String
     * @Since version-1.0
     */
    public String login(String username, String password);
    
    /**
     * @Author HouYi
     * @Date 2023/12/21 16:37
     * @Description 登录前置校验
     * @Param [username, password]
     * @Return void
     * @Since version-1.0
     */
    public Boolean loginPreCheck(String username, String password);

    /**
     * @Author HouYi
     * @Date 2023/12/20 16:51
     * @Description 记录登录信息
     * @Param [userId]
     * @Return void
     * @Since version-1.0
     */
    public void recordLoginInfo(Integer userId);

}
