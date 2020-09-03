package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import beans.BoardInfoBean;

public interface TopMenuMapper {
	
	// 상단 바 같이 모든 화면에 나오는 것은 인터페이스로 작성하면 편하다
	@Select("select * from board_info_table order by board_info_idx")
	List<BoardInfoBean> getTopMenuList();
}
