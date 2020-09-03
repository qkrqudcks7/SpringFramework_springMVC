package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// 맨 처음 오버라이드 시캬서, 정해져있는 거니깐 외워서 써
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 1. 형변환
		UserBean userBean=(UserBean) target;
		
		String beanName=errors.getObjectName();
		
		if(beanName.equals("joinUserName") || beanName.equals("modifyUserBean")){
			if(userBean.getUser_pw().equals(userBean.getUser_pw2())==false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		if(beanName.equals("joinUserBean")) {
			if(userBean.isUserIdExist()==false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}	
		}
	}
}
