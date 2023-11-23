package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.item.Item;
import model.item.ItemProcessor;

@WebServlet("/item/add_handle")
public class ItemAddHandleController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		double minRate = Double.parseDouble(request.getParameter("minRate"));
		double maxRate = Double.parseDouble(request.getParameter("maxRate"));
		
		ItemProcessor itemsUtil = new ItemProcessor();
		
		try {
			Item found = itemsUtil.findByKey(code);
			if (found != null) {
				request.setAttribute("saveResult", false);
				request.setAttribute("existItem", found);
			}else {
				Item one = new Item(code, name, price, minRate, maxRate);
				itemsUtil.save(one);
				request.setAttribute("saveResult", true);
				request.setAttribute("savedItem", one);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/view/item/add_handle.jsp").forward(request, response);
		
	}
}
