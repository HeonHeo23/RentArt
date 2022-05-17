package com.rentart.rentart.web.manage;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.magazine.dto.InsertMagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineListDto;
import com.rentart.rentart.service.MagazineService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/magazine")
public class ManageMagazineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService;
       
    public ManageMagazineController() {
    	magazineService = new MagazineService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean login = (Boolean) request.getSession().getAttribute("managePrincipal");
		if(login == null) {
			Script.back(response, "로그인 해주시기 바랍니다.");
			return;
		}
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			String pg_ = request.getParameter("pg");
			int pg = (pg_ == null || pg_.equals("")) ? 1 : Integer.parseInt(pg_);
			String field = request.getParameter("field");
			field = (field == null || field.equals(""))? "m_title" : field;
			String query = request.getParameter("query");
			query = (query == null)? "%" : query;
			
			List<MagazineListDto> list = magazineService.getMagazineList(pg, field, query);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/manage/magazineList.jsp").forward(request, response);
			return;
		} else if(cmd.equals("update")) {
			try {
				String title = request.getParameter("title");
				String text = request.getParameter("text");
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				String date_ = request.getParameter("date");
				Timestamp date = new Timestamp (new SimpleDateFormat("yyyy-MM-dd").parse(date_).getTime());

				MagazineDto dto = new MagazineDto(no, title, text, date);
				
				int result = magazineService.update(dto);
				if(result != 1) {
					Script.back(response, "매거진 수정에 실패했습니다.");
					return;
				}
				
				Script.close(response, "매거진을 수정했습니다.");
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "내용을 다시 확인해 주시기 바랍니다.");
				return;
			} catch(Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else if(cmd.equals("delete")) {
			try {
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				int result = magazineService.delete(no);
				
				if(result != 1) {
					Script.back(response, "매거진 삭제에 실패했습니다.");
					return;
				}
				
				Script.close(response, "매거진을 삭제했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
			}
			
		} else if(cmd.equals("new")) {
			try {
				String title = request.getParameter("title");
				String text = request.getParameter("text");
				String date_ = request.getParameter("date");
				Timestamp date = new Timestamp (new SimpleDateFormat("yyyy-MM-dd").parse(date_).getTime());
				
				InsertMagazineDto dto = new InsertMagazineDto(title, text, date);
				
				int result = magazineService.insert(dto);
				if(result != 1) {
					Script.back(response, "매거진 등록에 실패했습니다.");
					return;
				}
				
				Script.close(response, "매거진을 등록했습니다.");
				
			} catch(Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
		}
		
	}
	
}
