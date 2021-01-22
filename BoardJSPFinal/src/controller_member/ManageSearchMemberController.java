package controller_member;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.Controller;
import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class ManageSearchMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		if(search.equals(null)) search="";
		
		List<MemberVO> list =  MemberService.getInstance().manageSearchMemeber(kind,search);
		
		JSONObject jsonObject = new JSONObject();
    	jsonObject.put("kind",kind);
    	jsonObject.put("search",search);
    	JSONArray jsonArray = new JSONArray(list);
    	
//    	for(int i=0;i<list.size();i++) {
//    		JSONObject temp = new JSONObject();
//    		temp.put("id",list.get(i).getId());
//    		temp.put("name",list.get(i).getName());
//    		temp.put("age",list.get(i).getAge());
//    		temp.put("grade_name",list.get(i).getGrade());
//    		jsonArray.put(temp);
//    	}
    	
    	jsonObject.put("result",jsonArray);
    	try {
			response.getWriter().write((jsonObject.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
