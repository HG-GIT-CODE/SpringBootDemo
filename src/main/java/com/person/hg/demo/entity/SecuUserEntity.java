package com.person.hg.demo.entity;

import com.suncreate.core.BaseUser;

/**
 * <p>Title: SecuUserEntity.java</p>
 * <p>Description:系统用户实体</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * @author fanlianwei
 * @date 2017-9-6 9:01:14
 * @version V1.0
 */
public class SecuUserEntity extends BaseUser{

    /**用户ID*/
    private String userId;
    /**登陆名*/
    private String userLogin;
    /**姓名*/
    private String userName;
    /**军人证件号*/
    private String userCardNo;
    /**密码*/
    private String userPassword;
    /**用户排序*/
    private Long userPriority;
    /**工作级别*/
    private Long userLevel;
    /**系统ID*/
    private String cmpyId;
    /**所属单位代码*/
    private String parentId;
    /**电子邮箱*/
    private String userEmail;
    /**办公电话*/
    private String userOfficePhone;
    /**家庭电话*/
    private String userHomePhone;
    /**移动电话*/
    private String userMobile;
    /**办公地址*/
    private String userOfficeRoom;
    /**家庭地址*/
    private String userHomeRoom;
    /**刷新时间*/
    private Long userRefreshTime;
    /**1为系统用户，2为被禁用，3为还未开通用户名，9为被删除*/
    private Long userFlag;
    /**有效期起*/
    private Long accountStartTime;
    /**有效期止*/
    private Long accountStopTime;
    /**创建人*/
    private String userCreateId;
    /**注册时间*/
    private Long registerTime;
    /**备注*/
    private String areaCode;
    /**系统风格（主题\皮肤）*/
    private String userStyle;

    public String getUserStyle() {
        return userStyle;
    }

    public void setUserStyle(String userStyle) {
        this.userStyle = userStyle;
    }

    /**
     *无参构造函数
     */
    public SecuUserEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public SecuUserEntity(String id){
        super();
        this.userId=id;
    }

    /**
     * 获取用户ID
     * @return
     */
    public   String getUserId(){
        return this.userId;
    }


    /**
     * 设置用户ID
     * @param userId
     */
    public void setUserId(String  userId){
        this.userId=(userId == null ? null : userId.trim());
    }
    /**
     * 获取登陆名
     * @return
     */
    public   String getUserLogin(){
        return this.userLogin;
    }


    /**
     * 设置登陆名
     * @param userLogin
     */
    public void setUserLogin(String  userLogin){
        this.userLogin=(userLogin == null ? null : userLogin.trim());
    }
    /**
     * 获取姓名
     * @return
     */
    public   String getUserName(){
        return this.userName;
    }


    /**
     * 设置姓名
     * @param userName
     */
    public void setUserName(String  userName){
        this.userName=(userName == null ? null : userName.trim());
    }
    /**
     * 获取军人证件号
     * @return
     */
    public   String getUserCardNo(){
        return this.userCardNo;
    }


    /**
     * 设置军人证件号
     * @param userCardNo
     */
    public void setUserCardNo(String  userCardNo){
        this.userCardNo=(userCardNo == null ? null : userCardNo.trim());
    }
    /**
     * 获取密码
     * @return
     */
    public   String getUserPassword(){
        return this.userPassword;
    }


    /**
     * 设置密码
     * @param userPassword
     */
    public void setUserPassword(String  userPassword){
        this.userPassword=(userPassword == null ? null : userPassword.trim());
    }
    /**
     * 获取用户排序
     * @return
     */
    public   Long getUserPriority(){
        return this.userPriority;
    }


    /**
     * 设置用户排序
     * @param userPriority
     */
    public void setUserPriority(Long  userPriority){
        this.userPriority=userPriority;
    }
    /**
     * 获取工作级别
     * @return
     */
    public   Long getUserLevel(){
        return this.userLevel;
    }


    /**
     * 设置工作级别
     * @param userLevel
     */
    public void setUserLevel(Long  userLevel){
        this.userLevel=userLevel;
    }
    /**
     * 获取系统ID
     * @return
     */
    public   String getCmpyId(){
        return this.cmpyId;
    }


    /**
     * 设置系统ID
     * @param cmpyId
     */
    public void setCmpyId(String  cmpyId){
        this.cmpyId=(cmpyId == null ? null : cmpyId.trim());
    }
    /**
     * 获取所属单位代码
     * @return
     */
    public   String getParentId(){
        return this.parentId;
    }


    /**
     * 设置所属单位代码
     * @param parentId
     */
    public void setParentId(String  parentId){
        this.parentId=(parentId == null ? null : parentId.trim());
    }
    /**
     * 获取电子邮箱
     * @return
     */
    public   String getUserEmail(){
        return this.userEmail;
    }


    /**
     * 设置电子邮箱
     * @param userEmail
     */
    public void setUserEmail(String  userEmail){
        this.userEmail=(userEmail == null ? null : userEmail.trim());
    }
    /**
     * 获取办公电话
     * @return
     */
    public   String getUserOfficePhone(){
        return this.userOfficePhone;
    }


    /**
     * 设置办公电话
     * @param userOfficePhone
     */
    public void setUserOfficePhone(String  userOfficePhone){
        this.userOfficePhone=(userOfficePhone == null ? null : userOfficePhone.trim());
    }
    /**
     * 获取家庭电话
     * @return
     */
    public   String getUserHomePhone(){
        return this.userHomePhone;
    }


    /**
     * 设置家庭电话
     * @param userHomePhone
     */
    public void setUserHomePhone(String  userHomePhone){
        this.userHomePhone=(userHomePhone == null ? null : userHomePhone.trim());
    }
    /**
     * 获取移动电话
     * @return
     */
    public   String getUserMobile(){
        return this.userMobile;
    }


    /**
     * 设置移动电话
     * @param userMobile
     */
    public void setUserMobile(String  userMobile){
        this.userMobile=(userMobile == null ? null : userMobile.trim());
    }
    /**
     * 获取办公地址
     * @return
     */
    public   String getUserOfficeRoom(){
        return this.userOfficeRoom;
    }


    /**
     * 设置办公地址
     * @param userOfficeRoom
     */
    public void setUserOfficeRoom(String  userOfficeRoom){
        this.userOfficeRoom=(userOfficeRoom == null ? null : userOfficeRoom.trim());
    }
    /**
     * 获取家庭地址
     * @return
     */
    public   String getUserHomeRoom(){
        return this.userHomeRoom;
    }


    /**
     * 设置家庭地址
     * @param userHomeRoom
     */
    public void setUserHomeRoom(String  userHomeRoom){
        this.userHomeRoom=(userHomeRoom == null ? null : userHomeRoom.trim());
    }
    /**
     * 获取刷新时间
     * @return
     */
    public   Long getUserRefreshTime(){
        return this.userRefreshTime;
    }


    /**
     * 设置刷新时间
     * @param userRefreshTime
     */
    public void setUserRefreshTime(Long  userRefreshTime){
        this.userRefreshTime=userRefreshTime;
    }
    /**
     * 获取1为系统用户，2为被禁用，3为还未开通用户名，9为被删除
     * @return
     */
    public   Long getUserFlag(){
        return this.userFlag;
    }


    /**
     * 设置1为系统用户，2为被禁用，3为还未开通用户名，9为被删除
     * @param userFlag
     */
    public void setUserFlag(Long  userFlag){
        this.userFlag=userFlag;
    }
    /**
     * 获取有效期起
     * @return
     */
    public   Long getAccountStartTime(){
        return this.accountStartTime;
    }


    /**
     * 设置有效期起
     * @param accountStartTime
     */
    public void setAccountStartTime(Long  accountStartTime){
        this.accountStartTime=accountStartTime;
    }
    /**
     * 获取有效期止
     * @return
     */
    public   Long getAccountStopTime(){
        return this.accountStopTime;
    }


    /**
     * 设置有效期止
     * @param accountStopTime
     */
    public void setAccountStopTime(Long  accountStopTime){
        this.accountStopTime=accountStopTime;
    }
    /**
     * 获取创建人
     * @return
     */
    public   String getUserCreateId(){
        return this.userCreateId;
    }


    /**
     * 设置创建人
     * @param realUserId
     */
    public void setUserCreateId(String  realUserId){
        this.userCreateId=(realUserId == null ? null : realUserId.trim());
    }
    /**
     * 获取注册时间
     * @return
     */
    public   Long getRegisterTime(){
        return this.registerTime;
    }


    /**
     * 设置注册时间
     * @param registerTime
     */
    public void setRegisterTime(Long  registerTime){
        this.registerTime=registerTime;
    }
    /**
     * 获取备注
     * @return
     */
    public   String getAreaCode(){
        return this.areaCode;
    }


    /**
     * 设置备注
     * @param areaCode
     */
    public void setAreaCode(String  areaCode){
        this.areaCode=(areaCode == null ? null : areaCode.trim());
    }

    @Override
    public String getBaseUserId() {
        return this.userId;
    }

    @Override
    public String getBaseStrUserId() {
        return this.userId;
    }

}
