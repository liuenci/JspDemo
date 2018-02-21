package cn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 鍒樻仼璧�
 * @time 2017骞�10鏈�28鏃�
 * @function 閫氱敤servlet
 */
public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contentPath;// 鍐呭璺緞
	private ThreadLocal<HttpServletRequest> req = new ThreadLocal<>();// 璇锋眰瀵硅薄
	private ThreadLocal<HttpServletResponse> resp = new ThreadLocal<>();// 鍝嶅簲瀵硅薄
	private final String PARAM_KEY = "_paramKey_";

	@Override
	protected final void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 璁剧疆鍙傛暟
			this.contentPath = request.getContextPath();// 鑾峰彇鏍圭洰褰曪紝涓嶆槸getContentPath();
			// 璁剧疆缂栫爜
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// 灏嗗唴瀹逛繚瀛樺湪璇锋眰浣滅敤鍩熶腑
			request.setAttribute("cxt", this.contentPath);
			req.set(request);
			resp.set(response);
			// 澶勭悊閲嶅畾鍚戝弬鏁�
			// 鑾峰彇session涓殑閲嶅畾鍚戝弬鏁伴泦鍚�
			HashMap<String, Object> params = (HashMap<String, Object>) request.getSession().getAttribute(PARAM_KEY);
			// 濡傛灉闆嗗悎涓嶄负绌猴紝鍒欒鍙栭泦鍚堜腑鐨勬暟鎹�
			if (params != null && !params.isEmpty()) {
				// 閬嶅巻闆嗗悎涓殑鏁版嵁
				for (Entry<String, Object> e : params.entrySet()) {
					// 灏嗘暟鎹繚鐣欏埌璇锋眰浣滅敤鍩�
					request.setAttribute(e.getKey(), e.getValue());
				}
			}
			super.service(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	/**
	 * 杞彂
	 * @param viewName
	 * @throws ServletException
	 * @throws IOException
	 */
	public final void forward(String viewName) throws ServletException, IOException {
		//澶勭悊杞彂
		req.get().getRequestDispatcher("/WEB-INF/"+viewName+".jsp").forward(req.get(), resp.get());
	}
	/**
	 * 閲嶅畾鍚�
	 * @param uri
	 * @throws IOException
	 */
	public final void redirect(String uri) throws IOException {
		//澶勭悊閲嶅畾鍚�
		resp.get().sendRedirect(this.contentPath+uri);
	}
	
	public final void redirect(String uri,HashMap<String,Object> params) throws IOException {
		//灏嗗弬鏁颁繚瀛樺湪session涓�
		req.get().getSession().setAttribute(this.PARAM_KEY, params);
		this.redirect(uri);
	}

}
