/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-11-14
 */
public class JtydWeiboUser extends DataEntity<JtydWeiboUser> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 用户userID
	private String userName;		// 用户昵称
	private String baseAddress;		// base_address
	private String gender;		// gender
	private String sex;		// sex
	private String emotion;		// emotion
	private Date birthday;		// birthday
	private String blood;		// blood
	private String constellation;		// constellation
	private String intro;		// intro
	private String blog;		// blog
	private String msn;		// msn
	private String qq;		// qq
	private String school;		// school
	private String company;		// company
	private String companyAddr;		// company_addr
	private String companyJob;		// company_job
	private String tag;		// tag
	private String attentions;		// attentions
	private String fans;		// fans
	private String sendCount;		// send_count
	private String grabTag;		// grab_tag
	private String classTag;		// class_tag
	private Date fetchedTime;		// fetched_time
	private String url;		// 用户地址
	
	public JtydWeiboUser() {
		super();
	}

	public JtydWeiboUser(String id){
		super(id);
	}

	@NotNull(message="用户userID不能为空")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=30, message="用户昵称长度必须介于 0 和 30 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=30, message="base_address长度必须介于 0 和 30 之间")
	public String getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}
	
	@Length(min=0, max=1, message="gender长度必须介于 0 和 1 之间")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Length(min=0, max=10, message="sex长度必须介于 0 和 10 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=10, message="emotion长度必须介于 0 和 10 之间")
	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=1, message="blood长度必须介于 0 和 1 之间")
	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}
	
	@Length(min=0, max=3, message="constellation长度必须介于 0 和 3 之间")
	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	
	@Length(min=0, max=70, message="intro长度必须介于 0 和 70 之间")
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	@Length(min=0, max=100, message="blog长度必须介于 0 和 100 之间")
	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}
	
	@Length(min=0, max=50, message="msn长度必须介于 0 和 50 之间")
	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	@Length(min=0, max=10, message="qq长度必须介于 0 和 10 之间")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Length(min=0, max=100, message="school长度必须介于 0 和 100 之间")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Length(min=0, max=100, message="company长度必须介于 0 和 100 之间")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Length(min=0, max=30, message="company_addr长度必须介于 0 和 30 之间")
	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	
	@Length(min=0, max=30, message="company_job长度必须介于 0 和 30 之间")
	public String getCompanyJob() {
		return companyJob;
	}

	public void setCompanyJob(String companyJob) {
		this.companyJob = companyJob;
	}
	
	@Length(min=0, max=100, message="tag长度必须介于 0 和 100 之间")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Length(min=0, max=20, message="attentions长度必须介于 0 和 20 之间")
	public String getAttentions() {
		return attentions;
	}

	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}
	
	@Length(min=0, max=20, message="fans长度必须介于 0 和 20 之间")
	public String getFans() {
		return fans;
	}

	public void setFans(String fans) {
		this.fans = fans;
	}
	
	@Length(min=0, max=20, message="send_count长度必须介于 0 和 20 之间")
	public String getSendCount() {
		return sendCount;
	}

	public void setSendCount(String sendCount) {
		this.sendCount = sendCount;
	}
	
	@Length(min=0, max=20, message="grab_tag长度必须介于 0 和 20 之间")
	public String getGrabTag() {
		return grabTag;
	}

	public void setGrabTag(String grabTag) {
		this.grabTag = grabTag;
	}
	
	@Length(min=0, max=20, message="class_tag长度必须介于 0 和 20 之间")
	public String getClassTag() {
		return classTag;
	}

	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFetchedTime() {
		return fetchedTime;
	}

	public void setFetchedTime(Date fetchedTime) {
		this.fetchedTime = fetchedTime;
	}
	
	@Length(min=0, max=100, message="用户地址长度必须介于 0 和 100 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}