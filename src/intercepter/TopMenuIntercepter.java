package intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import beans.BoardInfoBean;
import beans.UserBean;
import service.TopMenuService;

public class TopMenuIntercepter implements HandlerInterceptor{
	
	//주의**** autowire로 자동주입이 안된다
	private TopMenuService topMenuService;
	
	private UserBean loginUserBean;
	
	public TopMenuIntercepter(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService=topMenuService;
		this.loginUserBean=loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		return true;
	}
}
