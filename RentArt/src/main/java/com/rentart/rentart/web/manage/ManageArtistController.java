package com.rentart.rentart.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistListDto;
import com.rentart.rentart.domain.artist.dto.InsertArtistDto;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/artist")
public class ManageArtistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistService artistService;
       
    public ManageArtistController() {
    	artistService = new ArtistService();
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
			field = (field == null || field.equals(""))? "artist_name" : field;
			String query = request.getParameter("query");
			query = (query == null)? "%" : query;
			
			List<ArtistListDto> list = artistService.getManageArtistList(pg, field, query);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/manage/artistList.jsp").forward(request, response);
			return;
		} else if(cmd.equals("update")) {
			try {
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				String text = request.getParameter("text");
				
				int result = artistService.updateArtist(no, name, password);
				if(result != 1) {
					Script.back(response, "작가 정보 수정에 실패했습니다.");
					return;
				}
				result = artistService.updateInfo(no, text);
				if(result != 1) {
					Script.back(response, "작가 정보 수정에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작가 정보를 수정했습니다.");
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "내용을 다시 확인해 주시기 바랍니다.");
				return;
			} catch(Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else if(cmd.equals("new")) {
			try {
				String id_ = request.getParameter("id");
				int id = Integer.parseInt(id_);				
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String text = request.getParameter("text");
				
				InsertArtistDto dto = new InsertArtistDto(id, name, password, text);
				
				int result = artistService.insert(dto);
				
				if(result != 1) {
					Script.back(response, "작품 등록에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작품을 등록했습니다.");
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
				int result = artistService.delete(no);
				
				if(result != 1) {
					Script.back(response, "작가 삭제에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작가를 삭제했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
			}
			
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
		
	}
	
}
