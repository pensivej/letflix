package post.cmd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.biz.PostBiz;
import post.entity.PostEntity;

/**
 * Servlet implementation class ImageSlide
 */
@WebServlet("/post/ImageSlide")
public class ImageSlideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageSlideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String postId = (String) request.getParameter("id");
		PostBiz biz = new PostBiz();
		try {
			PostEntity post = biz.selectPost(postId);
			if (post != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/post/imageSlide.jsp");
				request.setAttribute("post", post);
				rd.forward(request, response);
			} 
		} catch (Exception e) {
			
		}
	}

}
