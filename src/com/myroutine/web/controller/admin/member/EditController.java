package com.myroutine.web.controller.admin.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.user.MemberService;

@WebServlet("/admin/member/edit")
public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(404);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// JSON응답 세팅
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out;
		
		int id = 0;
		int result = 0;
		String idCheck = request.getParameter("id");
		if( idCheck == null || idCheck.equals("") ) {
			out = response.getWriter();
			out.printf("{\"result\":%d}", result);
			return;
		}
		
		// 아이디, 키 세팅
		id = Integer.parseInt(idCheck);
		String str = "email,name,nickname,phone,birthday,authority,receivingmail,publicinfo,receivingsms,delete";
		List<String> keys = new ArrayList<String>();
		Map<String, String> datas = new HashMap<String, String>();
		
		{ // 키들 넣기
			String[] temp = str.split(",");
			
			for(int i = 0; i < temp.length; i++)
				keys.add(temp[i]);
		}

		// 람다식 
		// 받아온 데이터가 없다면 keys에서 제거함
		// [email,name,nickname,phone,birthday,authority,receivingmail,publicinfo,receivingsms]
		// 거치면 아래가 나옴 대입 안해줘도 자동으로 들어감
		// [receivingmail]
		keys.removeIf( key -> {
			String temp = request.getParameter(key);
			if( temp == null || temp.equals("") ) {
				return true;
			}
			datas.put(key, temp);
			return false;
		});
		
		MemberService service = new MemberService();
		out = response.getWriter();
		
		// 키들 순회
		for(String key : keys) {
			String value = datas.get(key);
			
			// 삭제하는거일경우
			if( key.equals("delete") && value.equals("1")) {
				result = service.delete(id);
				out.printf("{\"result\":%d}", result);
				continue;
			}

			System.out.printf("admin.member.EditController -> EditController() 에서 메시지 id: %d, key: %s, value: %s\n", id, key, value);
			
			result = service.update(id, key, value);
			out.printf("{\"result\":%d}", result);
		}
		out.close();
	}
}
